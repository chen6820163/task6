package com.jnshu.task4.web;

import com.jnshu.task4.common.bean.User;
import com.jnshu.task4.common.utils.JwtUtils;
import com.jnshu.task4.common.utils.MD5Util;
import com.jnshu.task4.service.interfaces.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * @program: task5
 * @description:用户的注册，登录与注销
 * @author: Mr.Chen
 * @create: 2019-02-27 20:36
 * @contact:938738637@qq.com
 **/
@Controller
public class UserController {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    IUserService userService;

    //  -----------登录------------------
    @RequestMapping("a/u/gologin")
    public String goLogin(){
        return "login";
    }
    //  -----------注册------------------
    @RequestMapping("a/u/goreg")
    public String goReg(){
        return "reg";
    }
    /** 
    * @Description: 用户注册 
    * @Param: [] 
    * @return: java.lang.String 
    * @Author: Mr.Chen
    * @Date: 2019/2/27 0027 
    */ 
    @PostMapping("a/u/reg")
    public String reg(User user, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();
        String message = null;

        // 判定输入用户名或者密码是否为空，若其中一项为空，则返回注册页面
        if(username.isEmpty() || password.isEmpty()){
            logger.info("用户名或密码为空");
            message = "用户名或者密码不能为空";
            model.addAttribute("msg",message);
            return "reg";
        }
        User user1 = userService.queryUserByName(username);
        // 判定输入的用户名是否已存在
        if (user1!=null) {
            logger.info("用户名"+username+"已存在");
            message = "用户名已存在";
            model.addAttribute("msg",message);
            return "reg";
        }
        //将用户名作为salt
        String pwd = MD5Util.md5(username + password);
        user.setPassword(pwd);
        long l = System.currentTimeMillis();
        user.setCreateAt(l);
        user.setUpdateAt(l);
        userService.insertUser(user);
        logger.info("注册成功");
        logger.info(user);
        return "redirect:/a/u/gologin";
    }

    //token认证
    @PostMapping("a/u/login")
    public String login(String username, String password, HttpSession session, Model model, HttpServletResponse response) {
        String message = null;
        // 判定输入用户名或者密码是否为空，若其中一项为空，则返回登录页面
        if(username.isEmpty() || password.isEmpty()){
            logger.info("用户名或者密码为空");
            message = "用户名或者密码不能为空";
            model.addAttribute("msg",message);
            return "login";
        }
        User user = userService.queryUserByName(username);
        String pwd = MD5Util.md5(username + password);
        if (user == null || !pwd.equals(user.getPassword())) {
            logger.info("用户名或密码错误");
            message = "用户名或密码错误,请重新输入";
            return "login";
        }
        try {
            logger.info("登陆成功");
            JwtUtils jwtUtils = new JwtUtils();
            // 1小时后 过期
            long maxTime = 30*60L*1000L;
            String token = jwtUtils.getToken(username, maxTime);
            Cookie cookie = new Cookie("token", token);
            logger.info("生成token认证:"+token);
            // 过期时间：1小时
            cookie.setMaxAge(60*60);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 30分钟过期
        session.setMaxInactiveInterval(30*60);
        session.setAttribute("username",username);
        return "redirect:/a/u/home";
    }
    //退出登录
    @GetMapping("/u/loginOut")
    public String loginOut( HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        // 删除session
        session.invalidate();
        Cookie[] cookies = request.getCookies();
        // setMaxAge(0)------删除Cookie失效----------默认 setMaxAge(-1) ,关闭浏览器删除Cookie
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName()) || "JSESSIONID".equals(cookie.getName())) {
                //cookie.setValue("");
                cookie.setValue(null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        logger.info("退出登录");
        return "redirect:/a/u/home";
    }
}
