package com.jnshu.task4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: task2
 * @description: 展示页面
 * @author: Mr.Chen
 * @create: 2018-11-29 17:40
 * @contact:938738637@qq.com
 **/
@Controller
@RequestMapping("/show")
public class showController {
    @RequestMapping("/save")
    public String save() {
        return "save_student";
    }



    @RequestMapping("/update")
    public String update() {
        return "update";
    }



    @RequestMapping("/select")
    public String select() {
        return "select";
    }
}
