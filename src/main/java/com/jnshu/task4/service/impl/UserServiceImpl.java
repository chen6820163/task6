package com.jnshu.task4.service.impl;

import com.jnshu.task4.common.bean.User;
import com.jnshu.task4.dao.UserMapper;
import com.jnshu.task4.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: task4
 * @description:
 * @author: Mr.Chen
 * @create: 2019-02-27 20:14
 * @contact:938738637@qq.com
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Long insertUser(User user) {
        Long id = userMapper.insert(user);
        return id;
    }

    @Override
    public Boolean deleteUserById(Long id) {
        boolean flag = false;
        int i = userMapper.deleteByPrimaryKey(id);
        if (i != 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Boolean updateStudent(User user) {
        boolean flag = false;
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i != 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public User queryUserByName(String userName) {
        User user = userMapper.selectByName(userName);
        return user;
    }

    @Override
    public User queryUserById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public List<User> queryAllUsers() {
        List<User> users = userMapper.queryAllUsers();
        return users;
    }
}
