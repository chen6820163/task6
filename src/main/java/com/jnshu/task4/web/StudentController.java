package com.jnshu.task4.web;

import com.github.pagehelper.PageInfo;
import com.jnshu.task4.common.bean.Student;
import com.jnshu.task4.service.interfaces.IStudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @program: task4
 * @description:
 * @author: Mr.Chen
 * @create: 2019-03-09 17:13
 * @contact:938738637@qq.com
 **/
@Controller
@RequestMapping("task2")
public class StudentController {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public IStudentService studentService;
    /**
     * @Description: 添加学生,并做一点参数校验功能
     * @Param: [student, model, redirectAttributes]
     * @return: java.lang.String
     * @Author: Mr.Chen
     * @Date: 2018/12/24 0024
     */
    @RequestMapping(value="/student", method = RequestMethod.POST)
//    @ResponseBody
    public String saveStudent(@Validated Student student, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error:allErrors
            ) {
                logger.info(error.getDefaultMessage());
//                model.addAttribute("errors",allErrors);
                redirectAttributes.addFlashAttribute("msg1","添加学生信息失败");
                return "redirect:/show/save";
            }
        }
        try {
            student.setCreateAt(System.currentTimeMillis());
            student.setUpdateAt(System.currentTimeMillis());
            System.out.println(student);
            studentService.saveStudent(student);
            redirectAttributes.addFlashAttribute("msg2","添加学生信息成功,且id为："+student.getId());
            logger.info("添加学生信息成功,并打印学生信息："+student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("***********************分割线***************************");
        return "redirect:/show/save";
    }
    /**
     * @Description: 删除对应id的学生信息
     * @Param: [id, model, redirectAttributes]
     * @return: java.lang.String
     * @Author: Mr.Chen
     * @Date: 2018/12/25 0025
     */
    @RequestMapping(value = "/student/{id}/{pageNum}",method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable(value = "id") Integer id, @PathVariable(value = "pageNum") Integer pageNum, Model model) {
        try {
            boolean b = studentService.deleteStudentById(id);
            if (false==b) {
                logger.debug("删除失败");
            }
            logger.debug("删除成功");
            PageInfo<Student> studentPageInfo = studentService.queryAllStudentsWithPage(pageNum, 5);
            model.addAttribute("studentPageInfo",studentPageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("***********************分割线***************************");
        return "redirect:/task2/index";
    }


    /**
     * @Description: 修改学生信息
     * @Param: [student, model, redirectAttributes]
     * @return: java.lang.String
     * @Author: Mr.Chen
     * @Date: 2018/12/25 0025
     */
    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public String updateStudent( Student student,Model model,RedirectAttributes redirectAttributes) {
        try {
            boolean b = studentService.updateStudent(student);
            Student student1 = studentService.queryByPrimaryKey(student.getId());
            if (false==b) {
                logger.debug("更新失败");
                redirectAttributes.addFlashAttribute("msg1","修改学生信息失败,请重新修改");
                logger.info("***********************分割线***************************");
            }
            redirectAttributes.addFlashAttribute("s1",student1);
            redirectAttributes.addFlashAttribute("msg2","修改成功");
            logger.debug("更新成功并打印更新后学生信息："+student1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("***********************分割线***************************");
        return "redirect:/show/update";
    }
    /**
     * @Description: 更新之前,先根据id查询对应学生信息
     * @Param: [id, model]
     * @return: java.lang.String
     * @Author: Mr.Chen
     * @Date: 2018/12/25 0025
     */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String selectStudentById( @PathVariable int id,Model model) {
        try {
            Student student = studentService.queryByPrimaryKey(id);
            if (student==null) {
                model.addAttribute("msg1","该学生不存在");
                logger.debug("该学生不存在");
            } else {
                model.addAttribute("s",student);
                logger.info("查询成功并打印学生信息："+student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("***********************分割线***************************");
        return "update";
    }


    /**
     * @Description:  分页展示学生信息
     * @Param: [page, model]
     * @return: java.lang.String
     * @Author: Mr.Chen
     * @Date: 2018/12/21 0021
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getStudentsAllWithPage(@RequestParam(value="page",required=false,defaultValue="1") int page, Model model) {
        logger.info("进入首页了。。。。");
        try {
            PageInfo<Student> studentPageInfo = studentService.queryAllStudentsWithPage(page, 5);
            logger.info("共查询到"+studentPageInfo.getTotal()+"条记录");
//            for (Student s:studentPageInfo.getList()) {
//                logger.info(s);
//            }
            model.addAttribute("studentPageInfo",studentPageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("***********************分割线***************************");
        return "index";
    }
    /**
     * @Description: 根据名字模糊查询
     * @Param: [name, model]
     * @return: java.lang.String
     * @Author: Mr.Chen
     * @Date: 2018/12/25 0025
     */
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String selectStudentByName(@RequestParam(value="page",required=false,defaultValue="1") int page,@RequestParam(value = "name") String name,Model model) {
        if (null == name) {
            logger.debug("名字为空");
        }
        logger.info("传入姓名为："+name);
        try {
            PageInfo<Student> studentPageInfo = studentService.queryStudentsByName(name,page, 5);
            logger.info("共查询到"+studentPageInfo.getTotal()+"条记录");
            if (studentPageInfo.getList()==null) {
                logger.debug("姓名为"+name+"的学生不存在,请重新输入");
                model.addAttribute("msg1","姓名为"+name+"的学生不存在,请重新输入");
            } else {
                logger.info("查询成功");
                model.addAttribute("studentPageInfo",studentPageInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("***********************分割线***************************");
        return "select";
    }
}
