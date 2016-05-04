package com.joizhang.mylibrary.controller;

import com.joizhang.mylibrary.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2016/5/4.
 */
@Controller("/user")
public class UserController {

    @Autowired
    private IUserService userService;

}
