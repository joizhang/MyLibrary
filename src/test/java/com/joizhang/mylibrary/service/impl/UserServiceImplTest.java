package com.joizhang.mylibrary.service.impl;

import com.joizhang.mylibrary.model.vo.User;
import com.joizhang.mylibrary.service.IUserService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/5/4.
 */
@ContextConfiguration(locations = {"classpath*:/spring*.xml"})
public class UserServiceImplTest extends AbstractJUnit4SpringContextTests {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    private IUserService userService;

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setUsername("joizhang");
        user.setPassword("123");
        logger.info(ReflectionToStringBuilder.toString(user));
        System.out.println(user == null);
        userService.createUser(user);
    }
}