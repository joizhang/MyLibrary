package com.joizhang.mylibrary.service;

import com.joizhang.mylibrary.model.vo.User;

import java.util.List;

/**
 * Created by Administrator on 2016/5/4.
 */
public interface IUserService {

    /**
     * 创建用户
     * @param user 用户信息
     * */
    void createUser(User user);

    /**
     * 获得所有用户
     * */
    List<User> getAllUsers();

    /**
     * 获得所有的用户名
     * */
    @SuppressWarnings("uncheck")
    List getAllUserNames();
}
