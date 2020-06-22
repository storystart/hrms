package com.xtu.hrms.service;

import com.xtu.hrms.bean.Salary;
import com.xtu.hrms.bean.User;

import java.util.List;

public interface IUserService {
//    后台登录
    User login(User user);

    User getUserById(Integer id);

    List<User> getAllUsers();

    int deleteUserById(Integer id);

    int addUser(User user);

    int updateUser(User user);
}
