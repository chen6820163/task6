package com.jnshu.task4.web;

import com.jnshu.task4.common.bean.Career;
import com.jnshu.task4.service.interfaces.ICareerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: task4
 * @description:
 * @author: Mr.Chen
 * @create: 2019-02-20 23:00
 * @contact:938738637@qq.com
 **/
@Controller
public class CareerrController {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    ICareerService careerService;

    @RequestMapping("u/career")
    public String getCareers(Model model) {
        List<Career> careers = careerService.selectALl();
        logger.info("查询career集合成功");
        model.addAttribute("careers",careers);
        return "career";
    }

    @RequestMapping("u/recommend")
    public String recommend() {
        return "recommend";
    }

    @RequestMapping("u/about")
    public String about() {
        return "about";
    }
}
