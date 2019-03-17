package com.jnshu.task4.service.interfaces;

import com.jnshu.task4.common.bean.User;

import java.util.List;

public interface IUserService {
    /** 
    * @Description: 新增用户 
    * @Param: [user]  用户信息
    * @return: java.lang.Long id 主键
    * @Author: Mr.Chen
    * @Date: 2019/2/27 0027 
    */ 
    Long insertUser(User user);
    /**
    * @Description: 根据id删除用户
    * @Param: [id] 主键
    * @return: java.lang.Boolean true-----删除成功，false------更新失败
    * @Author: Mr.Chen
    * @Date: 2019/2/27 0027
    */
    Boolean deleteUserById(Long id);
    /** 
    * @Description: 更新用户信息
    * @Param: [user] 用户信息 
    * @return: java.lang.Boolean true-----更新成功，false------更新失败
    * @Author: Mr.Chen
    * @Date: 2019/2/27 0027 
    */ 
    Boolean updateStudent(User user);
    /** 
    * @Description: 根据用户名查询用户 
    * @Param: [userName] 用户名
    * @return: com.jnshu.task4.common.bean.User 
    * @Author: Mr.Chen
    * @Date: 2019/2/27 0027 
    */ 
    User queryUserByName(String userName);
    /** 
    * @Description: 根据id查询用户 
    * @Param: [id] 
    * @return: com.jnshu.task4.common.bean.User 
    * @Author: Mr.Chen
    * @Date: 2019/2/27 0027 
    */ 
    User queryUserById(Long id);
    /** 
    * @Description: 查询所有用户信息 
    * @Param: [] 
    * @return: java.util.List<com.jnshu.task4.common.bean.User> 
    * @Author: Mr.Chen
    * @Date: 2019/2/27 0027 
    */ 
    List<User> queryAllUsers();
}
