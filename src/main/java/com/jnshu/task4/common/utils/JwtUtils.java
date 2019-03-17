package com.jnshu.task4.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

/**
 * @program: task4
 * @description:
 * @author: Mr.Chen
 * @create: 2019-03-02 00:13
 * @contact:938738637@qq.com
 **/
public class JwtUtils {
    public String secretkey = "ABCDEFGHIJKLMNOPQRSTWXYZabcdefghijklmnopqrstwxyz0123456789-_.";

    /**
     * JWT 添加至HTTP HEAD中的前缀
     */
    private static final String JWT_SEPARATOR = "Bearer ";

    public JwtUtils(){}

    public JwtUtils(String key){
        this.secretkey = key;
    }

    /**
     * 创建 token
     * @param name 用户名
     * @param maxAge  最大有效时间
     * @return
     * @throws IllegalArgumentException
     * @throws UnsupportedEncodingException
     */
    public  String getToken(String name,long maxAge) throws IllegalArgumentException, UnsupportedEncodingException {

        String token = null ;

        //指定签名的时候使用的签名算法 和秘钥
        Algorithm algorithm = Algorithm.HMAC256(secretkey);


        //签发时间,当前系统时间
        Date nowTime = new Date();

        //设置过期时间
        Date expiresAt = new Date(System.currentTimeMillis()+ maxAge);
        token = JWT.create()
                // 签发者
                .withIssuer("jnshu")
                // 用户名
                // .withClaim
                .withClaim("username", name)
                // 过期时间
                .withExpiresAt(expiresAt)
                //设置签发时间
                .withIssuedAt(nowTime)
                // 使用了HMAC256加密算法。
                .sign(algorithm);
        // 在JWT字符串前添加"Bearer "字符串，用于加入"Authorization"请求头
//        return JWT_SEPARATOR+token;
        return token;

    }
    //验证
    public Map<String, Claim> verifyToken(String token) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretkey)).build();
        DecodedJWT jwt = null;
        try {
            token = StringUtils.substringAfter(token, JWT_SEPARATOR);
            jwt = verifier.verify(token);
        } catch (Exception e) {
            throw new RuntimeException("凭证过期！请重新登录!");
        }

        return jwt.getClaims();
    }

    //解密
    public DecodedJWT decodedToken(String token) throws Exception, JWTVerificationException, TokenExpiredException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretkey)).build();
        DecodedJWT jwt ;
        try {
//            token = StringUtils.substringAfter(token, JWT_SEPARATOR);
            jwt = verifier.verify(token);
        } catch (TokenExpiredException e) {
            e.fillInStackTrace();
            throw new RuntimeException("凭证过期！请重新登录!");
        }
        return jwt;
    }

    public static void main(String[] args) throws Exception {

        JwtUtils jwtUtils = new JwtUtils();
        // 1小时后 过期
        long maxTime = 60*60L*1000L;

        // 生成token
        String token = jwtUtils.getToken("chenpeng",maxTime);
        String s = " Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJqbnNodSIsImV4cCI6MTU1MTYwNDcyNiwiaWF0IjoxNTUxNjAxMTI2LCJ1c2VybmFtZSI6ImNoZW5wZW5nIn0.uKy_UYry6qCrQer8WsWFjRQMZjVfrzhMAlnGy2znsp0";
//        boolean verify = jwtUtils.verify(s);
//        System.out.println(verify);
//        // 打印token
        System.out.println("token: " + token);
//        String s = StringUtils.substringAfter(token, null);
//        System.out.println(s);
        // 解密token
        DecodedJWT jwt = jwtUtils.decodedToken(s);
        System.out.println("签发者: " + jwt.getIssuer());
        System.out.println("name: " + jwt.getClaim("username").asString());
        System.out.println("过期时间： " + jwt.getExpiresAt());
        System.out.println("签发时间：   " + jwt.getIssuedAt());


    }
}
