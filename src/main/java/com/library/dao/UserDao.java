package com.library.dao;

import com.library.bean.Component;
import com.library.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 周黎
 * @Date: 2019/11/11
 * @Description: com.library.dao
 * @version: 1.0
 */

@Mapper
public interface UserDao {
    List<User> searchUser();
}
