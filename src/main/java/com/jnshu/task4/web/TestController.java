package com.jnshu.task4.web;

import com.danga.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: task4
 * @description:
 * @author: Mr.Chen
 * @create: 2019-02-18 16:31
 * @contact:938738637@qq.com
 **/
@Controller
public class TestController {


    @RequestMapping("test1")
    public String test1() {
        System.out.println("我是Handle方法");
        return "recommend";
    }
    @Autowired
    MemCachedClient memCachedClient;
    @RequestMapping("memcached")
    public void setMemCachedClient() {
        System.out.println(memCachedClient.get("name"));
        System.out.println(memCachedClient.get("hello"));
        memCachedClient.delete("name");
        memCachedClient.delete("hello");
        boolean b = memCachedClient.add("user", "chnepeng");
        System.out.println("memcached 加载是否成功："+b);
        System.out.println("memcached 获取user的结果："+memCachedClient.get("user"));
        // 替换
        System.out.println("键对应的值 - " + memCachedClient.get("user"));
        boolean target = memCachedClient.replace("user","shixiong");
        System.out.println("replace 替换的状态:" + target);
        System.out.println("replace 替换的结果:" + memCachedClient.get("user"));
        // 移除
        memCachedClient.delete("user");
        System.out.println("delete 移除后结果："+memCachedClient.get("user"));
    }

    @RequestMapping("test4")
    public String test4() {
        return "home1";
    }

    @RequestMapping("test5")
    public String test5() {
        return "about1";
    }
    @RequestMapping("test6")
    public String test6() {
        return "reg1";
    }
}
