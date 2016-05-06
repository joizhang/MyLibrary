package com.joizhang.mylibrary.controller;

import com.joizhang.mylibrary.model.vo.User;
import com.joizhang.mylibrary.service.IUserService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        return userService.getAllUserNames();
    }

    @RequestMapping(value = "/getBorrowerName", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getBorrowerName(HttpServletRequest request) {
        Map<String, Object> map = new HashedMap();
        String borrowerId = WebUtils.getCleanParam(request, "borrowerId");
        String borrowerName = userService.getBorrowName(borrowerId);
        if (borrowerName != null) {
            map.put("borrowerName", borrowerName);
        }
        return map;
    }

}
