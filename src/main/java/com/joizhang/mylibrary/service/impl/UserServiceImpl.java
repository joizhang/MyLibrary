package com.joizhang.mylibrary.service.impl;

import com.joizhang.mylibrary.dao.IBaseDao;
import com.joizhang.mylibrary.model.po.SysUser;
import com.joizhang.mylibrary.model.vo.User;
import com.joizhang.mylibrary.service.IUserService;
import com.joizhang.mylibrary.utils.PasswordHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/5/4.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IBaseDao<SysUser> userIBaseDao;
    private PasswordHelper helper;

    public void createUser(User user) {
        //加密密码
        helper.encryptPassword(user);
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        sysUser.setUserId(String.valueOf(keyHolder.getKey().longValue()));
        sysUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
        userIBaseDao.save(sysUser);

    }
}
