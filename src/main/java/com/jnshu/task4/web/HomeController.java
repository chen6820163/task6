package com.jnshu.task4.web;

import com.jnshu.task4.common.bean.Student;
import com.jnshu.task4.service.interfaces.IStudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: task4
 * @description:
 * @author: Mr.Chen
 * @create: 2019-02-20 23:00
 * @contact:938738637@qq.com
 **/
@Controller
public class HomeController {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    IStudentService studentService;

    @RequestMapping("a/u/home")
    public String home(Model model) {
        List<Student> students1 = studentService.selectAll();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            students.add(students1.get(i));
        }
        Integer total = studentService.countAll();
        Integer goodNum = studentService.countByStatus();
        logger.info("学员总数:"+total);
        logger.info("优秀学员数量:"+goodNum);
        model.addAttribute("total",total);
        model.addAttribute("goodNum",goodNum);
        model.addAttribute("students",students);
        return "home";
    }
}
