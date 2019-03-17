package com.jnshu.task4.service.interfaces;

import com.github.pagehelper.PageInfo;
import com.jnshu.task4.common.bean.Student;

import java.util.List;

public interface IStudentService {
    Student selectCareerById(Integer id);
    List<Student> selectAll();
    Integer countByStatus();
    Integer countAll();
    //添加学生
    int saveStudent(Student student) throws Exception;
    //根据学生ID删除学生
    boolean deleteStudentById(Integer id) throws Exception;
    //修改学生信息
    boolean updateStudent(Student student) throws Exception;
    //根据学生ID和姓名查询学生信息
    Student queryByPrimaryKey(Integer id) throws Exception;
    //根据学生姓名查询学生信息并分页展示
    PageInfo<Student> queryStudentsByName(String name, int pageNum, int pageSize) throws Exception;
    //查询所有学生信息
    List<Student> queryAllStudent() throws Exception;
    //分页查询学生信息
    PageInfo<Student> queryAllStudentsWithPage(int pageNum, int pageSize) throws Exception;
}
