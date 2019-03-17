package com.jnshu.task4.dao;

import com.jnshu.task4.common.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    Long insert(User record);

    User selectByName(String userName);

    User selectByPrimaryKey(Long id);

    List<User> queryAllUsers();

    int updateByPrimaryKeySelective(User record);

}