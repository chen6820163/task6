package com.jnshu.task4.common.utils;

/**
 * @program: task4
 * @description:
 * @author: Mr.Chen
 * @create: 2019-03-08 01:16
 * @contact:938738637@qq.com
 **/

import com.alibaba.fastjson.JSON;
import com.danga.MemCached.MemCachedClient;
import com.jnshu.task4.common.bean.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.*;

@Component("memCachedManager")
public class MemCachedManager {
    // 创建全局的唯一实例
//     MemCachedClient memCachedClient = new MemCachedClient();

    @Autowired
    MemCachedClient memCachedClient;

    public  MemCachedClient getMemCachedClient() {
        if (memCachedClient==null)
            memCachedClient = new MemCachedClient("memcache");
        return memCachedClient;
    }

//    // 设置与缓存服务器的连接池
//    static {
//        // 服务器列表和其权重
//        String[] servers = { "47.106.245.125:11211" };
//        Integer[] weights = { 3 };
//
//        // 获取socke连接池的实例对象
//        SockIOPool pool = SockIOPool.getInstance();
//
//        // 设置服务器信息
//        pool.setServers(servers);
//        pool.setWeights(weights);
//
//        // 设置初始连接数、最小和最大连接数以及最大处理时间
//        pool.setInitConn(5);
//        pool.setMinConn(5);
//        pool.setMaxConn(250);
//        pool.setMaxIdle(1000 * 60 * 60 * 6);
//
//        // 设置主线程的睡眠时间
//        pool.setMaintSleep(30);
//
//        // 设置TCP的参数，连接超时等
//        pool.setNagle(false);
//        pool.setSocketTO(3000);
//        pool.setSocketConnectTO(0);
//
//        // 初始化连接池
//        pool.initialize();
//
//        // 压缩设置，超过指定大小（单位为K）的数据都会被压缩
////        mcc.setCompressEnable(true);
////        mcc.setCompressThreshold(64 * 1024);
//    }

    public MemCachedManager() {
    }

    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public  Object get(String key) {
        Object obj = null;
        try {
            obj = memCachedClient.get(key);
        } catch (Exception e) {
            logger.error("Memcached get方法报错，key值：" + key + "\r\n" );
            e.printStackTrace();
        }
        return obj;
    }

    public String gett(String key) {
        String value = "";
        try {
            if (memCachedClient.get(key) != null) {
                value = memCachedClient.get(key).toString();
//                String[] strings = value.split("value:");
//                value = strings[1];
            }
        } catch (Exception e) {
            logger.error("memcached get exception: " + key, e);
        }

//        logger.debug("GET: key:{}, value:{}", key, value);
        return value;
    }

    public boolean delete(String key) {
        try {
            logger.info("DEL: key:{}", key);
            return memCachedClient.delete(key);
        } catch (Exception e) {
            logger.error("memcached delete exception: " + key, e);
        }
        return false;
    }

    public boolean set(String key, Object value) {
        try {
            logger.info("SET: key:{}, value:{}", key, value);
            return memCachedClient.set(key, value);
        } catch (Exception e) {
            logger.error("memcached set exception: " + key, e);
        }
        return false;
    }
    public boolean set(String key, String value, long millisecond) {
        try {
            logger.info("SET: key:{}, value:{}, expiretime:{}", key, value, millisecond);
            Date expiry = new Date(millisecond);
            return memCachedClient.set(key, value, expiry);
        } catch (Exception e) {
            logger.error("memcached set exception: " + key, e);
        }
        return false;
    }

    public boolean set(String key, String value) {
        try {
            logger.info("SET: key:{}, value:{}", key, value);
            return memCachedClient.set(key, value);
        } catch (Exception e) {
            logger.error("memcached set exception: " + key, e);
        }
        return false;
    }
//    对数字值做自增操作
    public long incr(String key) {
        return memCachedClient.incr(key);
    }
//添加或自增
    public long addOrIncr(String key, long value) {
        logger.info("SET: key:{}, value:{}", key, value);
        return memCachedClient.addOrIncr(key, value);
    }
//        遍历memcached中所有key
    public List<String> getAllKeys(MemCachedClient mcc) {
        logger.info("Get all key.......");
        List<String> list = new ArrayList<String>();
        Map<String, Map<String, String>> items = mcc.statsItems();
        for (Iterator<String> itemIt = items.keySet().iterator(); itemIt.hasNext();) {
            String itemKey = itemIt.next();
            Map<String, String> maps = items.get(itemKey);
            for (Iterator<String> mapsIt = maps.keySet().iterator(); mapsIt.hasNext();) {
                String mapsKey = mapsIt.next();
                String mapsValue = maps.get(mapsKey);
                if (mapsKey.endsWith("number")) { // memcached key 类型
                    // item_str:integer:number_str
                    String[] arr = mapsKey.split(":");
                    int slabNumber = Integer.valueOf(arr[1].trim());
                    int limit = Integer.valueOf(mapsValue.trim());
                    Map<String, Map<String, String>> dumpMaps = mcc.statsCacheDump(slabNumber,
                            limit);
                    for (Iterator<String> dumpIt = dumpMaps.keySet().iterator(); dumpIt
                            .hasNext();) {
                        String dumpKey = dumpIt.next();
                        Map<String, String> allMap = dumpMaps.get(dumpKey);
                        for (Iterator<String> allIt = allMap.keySet().iterator(); allIt
                                .hasNext();) {
                            String allKey = allIt.next();
                            list.add(allKey.trim());
                        }
                    }
                }
            }
        }
        logger.info("获取服务器中所有的key完成.......");
        return list;
    }
//            获得所有key的值
    public void getAllKeyVal(List<String> keys) {
        logger.info("--------------------getAllKeyVal");
        for (String key : keys) {
            String val = (String) memCachedClient.get(key);
            logger.info("get key: {} , val:{}", key, val);
        }
    }

    public void delAllKeys(List<String> keys) {
        logger.info("--------------------delAllKeys");
        for (String key : keys) {
            boolean ret = memCachedClient.delete(key);
            logger.info("delete key: {} , succ:{}", key, ret);
        }
    }

//    public void delKeysByPackageName(List<String> keys, String packageName) {
//
//    }

    public void regexGetKey(List<String> keyList, String regex) {
        logger.info("--------------------regex: {}", regex);
        for (String key : keyList) {
            if (key.matches(regex)) {
                logger.info("key: {}", key);
            }
        }
    }
    public boolean flashAll() {
        boolean flag = false;
        try {
            flag = memCachedClient.flushAll();
        } catch (Exception e) {
            logger.error("MemcachedflashAll方法报错");
        }
        return flag;
    }
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        MemCachedManager memCachedManager = (MemCachedManager) applicationContext.getBean("memCachedManager");
        Student student = new Student();
        student.setName("jack");
        boolean b = memCachedManager.set("student", student);
        System.out.println(b);
        Student student1 = (Student) memCachedManager.get("student");
        System.out.println(student1);
//        boolean b = memCachedManager.set("hello1", "world");
//        System.out.println(b);
//        System.out.println(memCachedManager.get("hello1"));
//        boolean b1 = memCachedManager.delete("hello1");
//        System.out.println(b1);

    }

}
