package com.library.service;

import com.library.bean.User;
import com.library.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 周黎
 * @Date: 2019/11/11
 * @Description: com.library.service
 * @version: 1.0
 */
@Service
public class UserService{
    @Autowired
    UserDao userDao;
    public List<User> serarchUser(){
        return userDao.searchUser();
    }
}
