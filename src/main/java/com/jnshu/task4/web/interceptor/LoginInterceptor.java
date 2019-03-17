package com.jnshu.task4.web.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.jnshu.task4.common.utils.JwtUtils;
import com.jnshu.task4.service.interfaces.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: task4
 * @description: 登录拦截
 * @author: Mr.Chen
 * @create: 2019-02-28 16:31
 * @contact:938738637@qq.com
 **/
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    IUserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean flag = false;
        //请求到登录页面放行
        if(request.getServletPath().startsWith("/a/u/gologin")) {
            logger.info("当前页面为登录界面,认证通过");
            flag = true;
            return flag;
        }
        // 获取 cookie
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            // 遍历cookie如果找到登录状态则返回true执行原来controller的方法
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    logger.info("cookie中存在token");
                    String token = cookie.getValue();
                    JwtUtils jwtUtils = new JwtUtils();
                    long date = System.currentTimeMillis();
                    DecodedJWT jwt = jwtUtils.decodedToken(token);
                    // token 是否过期，签发者 是否为jnshu, 用户名 是否为空，用户名 是否一致
                    if (date < jwt.getExpiresAt().getTime() && "jnshu".equals(jwt.getIssuer())) {
                        String username = jwt.getClaim("username").asString();
                        if (userService.queryUserByName(username)!=null) {
                            logger.info("token认证成功,重置token过期时间");
                            // 60分钟后token过期
                            long maxAge = 60L * 60L * 1000L;
                            String newToken = jwtUtils.getToken(username, maxAge);
                            cookie.setValue(newToken);
                            cookie.setPath("/");
                            HttpSession session = request.getSession();
                            session.setAttribute("username", username);
                            flag = true;
                            return flag;
                        }
                    }
                }
            }
        }
        logger.info("token认证失败");
        //不符合条件的给出提示信息，并转发到登录页面
        request.setAttribute("msg", "您还没有登录，请先登录！");
        request.getRequestDispatcher("/a/u/gologin").forward(request, response);
        return flag;
    }
}
