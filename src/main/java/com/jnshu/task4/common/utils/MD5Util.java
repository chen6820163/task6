package com.jnshu.task4.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: task4
 * @description:MD5加密解密及字符串对比工具类
 * @author: Mr.Chen
 * @create: 2019-02-27 14:27
 * @contact:938738637@qq.com
 **/
public class MD5Util {
    /** 
    * @Description:普通md5加密
    * @Param: [input] 
    * @return: java.lang.String 
    * @Author: Mr.Chen
    * @Date: 2019/2/27 0027 
    */ 
    public static String md5(String input) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return "check jdk";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = input.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    public static void main(String[] args) {
        String s = "sdg";

//        byte[] decode = Base64.getDecoder().decode(s);
//        for (byte b:decode
//             ) {
//            System.out.println(b);
//        }
        String s1 = MD5Util.md5(s);
        System.out.println(s1);
    }
}
