package com.joizhang.mylibrary.controller;

import com.joizhang.mylibrary.model.vo.User;
import com.joizhang.mylibrary.service.IUserService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/4.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(){
        List<User> users = userService.getAllUsers();
        //logger.info(ReflectionToStringBuilder.toString(users));
        System.out.println(users);
        return users;
    }

    @RequestMapping(value = "/getAllUserName", method = RequestMethod.GET)
    @ResponseBody
    public List getAllUserName() {
        List userNames = userService.getAllUserNames();
        return userNames;
    }

}
