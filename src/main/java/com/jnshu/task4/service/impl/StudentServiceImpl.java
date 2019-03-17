package com.jnshu.task4.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jnshu.task4.common.bean.Career;
import com.jnshu.task4.common.bean.Student;
import com.jnshu.task4.common.utils.MemCachedManager;
import com.jnshu.task4.dao.StudentMapper;
import com.jnshu.task4.service.interfaces.IStudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: task4
 * @description:
 * @author: Mr.Chen
 * @create: 2019-02-20 22:50
 * @contact:938738637@qq.com
 **/
@Service
public class StudentServiceImpl implements IStudentService {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    MemCachedManager memCachedManager;
    @Autowired
    StudentMapper studentMapper;
    @Override
    public Student selectCareerById(Integer id) {
        if (memCachedManager.get("student_"+id)==null) {
            Student student = studentMapper.queryByPrimaryKey(id);
            boolean b = memCachedManager.set("student_" + id, student);
            if (b==true) {
                logger.info("缓存写入成功");
                return (Student) memCachedManager.get("student_"+id);
            } else {
                logger.info("缓存写入失败");
                return student;
            }
        }
        return (Student) memCachedManager.get("student_"+id);
    }

    @Override
    public List<Student> selectAll() {
        if (memCachedManager.get("students")==null) {
            List<Student> students = studentMapper.queryAllStudent();
            boolean b = memCachedManager.set("students", students);
            if (b==true) {
                logger.info("缓存写入成功");
                return (List<Student>) memCachedManager.get("students");
            } else {
                logger.info("缓存写入失败");
                return students;
            }
        }
        logger.info("缓存读取成功");
        return (List<Student>) memCachedManager.get("students");
    }

    @Override
    public Integer countByStatus() {
        Integer i = studentMapper.countByStatus();
        return i;
    }

    @Override
    public Integer countAll() {
        Integer i = studentMapper.countAll();
        return i;
    }

    @Override
    public int saveStudent(Student student) throws Exception {
        if (student==null) {
            logger.error("传入学生为空，添加学生信息失败");
            throw new Exception("传入学生为空");
        }
        int i = studentMapper.insert(student);
        if (i != 0) {
            logger.info("数据已经更新，缓存失效。清空全部缓存");
            memCachedManager.flashAll();
            // MemcacheUtils.delete("students"+page.getStart());
        }
        return i;
    }

    @Override
    public boolean deleteStudentById(Integer id) throws Exception {
        if (id == null) {
            logger.error("传入学生为空，添加学生信息失败");
            throw new Exception("传入id失败");
        }
        boolean flag = false;
        logger.info("删除id为：{}的学生", id);
        // 记录将要删除的信息
        logger.info("删除的学生信息:"+studentMapper.queryByPrimaryKey(id));
        int i = studentMapper.deleteByPrimaryKey(id);
        if (i != 0) {
            logger.info("数据已经删除，缓存失效。清空全部缓存");
            memCachedManager.flashAll();
            // MemcacheUtils.delete("students"+page.getStart());

            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateStudent(Student student) throws Exception {
        if (student==null) {
            throw new Exception("修改学生信息失败");
        }
        boolean flag = false;
        logger.info("更新id:{}",student.getId());
        logger.info("更新的信息:"+student);
        int i = studentMapper.updateByPrimaryKeySelective(student);
        if (i != 0) {
            logger.info("数据已经更新，缓存失效,直接清空全部缓存");
            memCachedManager.flashAll();
            // MemcacheUtils.delete("students"+page.getStart());

            flag = true;
        }
        return flag;
    }

    @Override
    public Student queryByPrimaryKey(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("传入id失败");
        }
        Student student = studentMapper.queryByPrimaryKey(id);
        if (student == null) {
            throw new Exception("查询id为"+id+"的学生信息失败");
        }
        return student;
    }

    @Override
    public PageInfo<Student> queryStudentsByName(String name, int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = studentMapper.queryStudentsByName(name);
        if(students.size()==0) {
            return null;
        }
        return PageInfo.of(students);
    }

    @Override
    public List<Student> queryAllStudent() throws Exception {
        List<Student> students = studentMapper.queryAllStudent();
        if (students == null) {
            throw new Exception("学生表为空");
        }
        return students;
    }

    @Override
    public PageInfo<Student> queryAllStudentsWithPage(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        if (memCachedManager.get("students")==null) {
            List<Student> students = studentMapper.queryAllStudent();
            if (students == null) {
                throw new Exception("学生表为空");
            }
            boolean b = memCachedManager.set("students", students);
            if (b==true) {
                logger.info("缓存写入成功");
                return PageInfo.of((List<Student>) memCachedManager.get("students"));
            } else {
                logger.info("缓存写入失败");
                return PageInfo.of(students);
            }
        }
        logger.info("缓存读取成功");
        return PageInfo.of((List<Student>) memCachedManager.get("students"));
    }

}
