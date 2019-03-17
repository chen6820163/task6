package com.jnshu.task4.common.aop;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @program: task6
 * @description:
 * @author: Mr.Chen
 * @create: 2019-03-12 16:18
 * @contact:938738637@qq.com
 **/
public class JedisTest {
//    public static void main(String[] args) {
//        Jedis jedis = new Jedis("47.106.245.125",6379);
//        jedis.auth("Chen6820163*");
////        jedis.set("hello","world");
//        String value = jedis.get("hello");
//        System.out.println(value);
//        jedis.close();
//    }

    public static void main(String[] args) {
        // JedisPool
        JedisPool jedisPool = new JedisPool("47.106.245.125",6379);
        // 通过连接池获取jedis对象
        Jedis jedis = jedisPool.getResource();
        jedis.auth("Chen6820163*");
        jedis.set("你好","世界");
        System.out.println(jedis.get("你好"));
        jedis.close();
        jedisPool.close();
    }
}
