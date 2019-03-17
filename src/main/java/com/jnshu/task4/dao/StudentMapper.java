package com.jnshu.task4.dao;

import com.jnshu.task4.common.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    //根据学生ID删除学生
    int deleteByPrimaryKey(Integer id);
    //添加学生
    int insert(Student record);
    //根据学生ID查询学生信息
    Student queryByPrimaryKey(Integer id);
    //根据学生对象修改学生信息
    int updateByPrimaryKeySelective(Student record);
    //根据学生姓名查询学生信息并分页展示
    List<Student> queryStudentsByName(String name) ;
    //查询所有学生信息
    List<Student> queryAllStudent();

    Integer countAll();
    Integer countByStatus();

}