package com.jnshu.task4.common.aop;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jnshu.task4.common.bean.Student;
import com.jnshu.task4.common.utils.MemCachedManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @program: task4
 * @description: 项目中加入缓存memcache
 * @author: Mr.Chen
 * @create: 2019-03-08 23:06
 * @contact:938738637@qq.com
 **/
@Aspect
@Component
public class MemcachedAspect {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
//    @Autowired
//    MemCachedClient memCachedClient;
//    @Qualifier("memCachedManager")
    @Autowired
    MemCachedManager memCachedManager;
    //时间 缓存时间
    public static final int TIMEOUT = 360000;//秒
    private int expiry = TIMEOUT;

    @Around(value = "execution(* com.jnshu.task4.service.impl.StudentServiceImpl.query*(..))||execution(* com.jnshu.task4.service.impl.StudentServiceImpl.select*(..)) ")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object o = null;
        String cacheKey = getCacheKey(pjp);
        if (memCachedManager.getMemCachedClient().stats().isEmpty()) {
            logger.info("Memcached服务器可能不存在或是连接不上");
            return pjp.proceed();
        }
        List<Student> list = (List<Student>) memCachedManager.get(cacheKey);
        if (list.size()==0&&list.isEmpty()) {
            o = pjp.proceed();
            logger.info("缓存写入成功:"+cacheKey);
            memCachedManager.set(cacheKey,o);
        }
        logger.info("缓存读取成功:"+memCachedManager.get(cacheKey));
        if (list.size() == 1&&!list.isEmpty()) {
            Student student = list.get(0);
            return student;
        }
        return list;
    }

    //后置由于数据库数据变更  清理get*
    @After(value = "execution(* com.jnshu.task4.service.interfaces.IStudentService.updateStudent(..))||execution(* com.jnshu.task4.service.interfaces.IStudentService.deleteStudentById(..)) ")
    public void doAfter(JoinPoint jp){
        //包名+ 类名 + 方法名 + 参数(多个)  生成Key
        //包名+ 类名
        String packageName = jp.getTarget().getClass().getName();

        //包名+ 类名  开始的 都清理
        List<String> keys = memCachedManager.getAllKeys(memCachedManager.getMemCachedClient());
        //遍历
        for (String s:keys
             ) {
            if (s.startsWith(packageName)) {
                memCachedManager.delete(s);
            }
        }
        logger.info("缓存清理成功");
    }

    //包名+ 类名 + 方法名 + 参数(多个)  生成Key
    public String getCacheKey(ProceedingJoinPoint pjp){
        //StringBuiter
        StringBuilder key = new StringBuilder();
        //包名+ 类名   cn.itcast.core.serice.product.ProductServiceImpl.productList
        String packageName = pjp.getTarget().getClass().getName();
        key.append(packageName);
        // 方法名
        String methodName = pjp.getSignature().getName();
        key.append(".").append(methodName);

        //参数(多个)
        Object[] args = pjp.getArgs();

        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        for(Object arg : args){

            //流
            StringWriter str = new StringWriter();

            //对象转Json  写的过程     Json是字符串流
            try {
                om.writeValue(str, arg);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //参数
            key.append(".").append(str);
        }

        return key.toString();
    }
    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

}
