package com.joizhang.mylibrary.service.impl;

import com.joizhang.mylibrary.dao.IBaseDao;
import com.joizhang.mylibrary.model.po.SysUser;
import com.joizhang.mylibrary.model.vo.User;
import com.joizhang.mylibrary.service.IUserService;
import com.joizhang.mylibrary.utils.PasswordHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/5/4.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IBaseDao<SysUser> userIBaseDao;

    public void createUser(User user) {
        //加密密码
        PasswordHelper helper = new PasswordHelper();
        helper.encryptPassword(user);

        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        sysUser.setUserId(UUID.randomUUID().toString());
        sysUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
        if ((userIBaseDao.find("from SysUser where username=?0", new String[]{sysUser.getUsername()})).size() == 0) {
            userIBaseDao.saveOrUpdate(sysUser);
        }

    }

    public List<User> getAllUsers() {
        //System.out.println(changeModel(userIBaseDao.find("from SysUser")));
        return changeModel(userIBaseDao.find("from SysUser"));
    }

    public List getAllUserNames() {
        //System.out.println(userIBaseDao.find("select username from SysUser"));
        return userIBaseDao.find("select username from SysUser");
    }

    private List<User> changeModel(List<SysUser> sysUsers) {        //将RmsUser转换为User
        List<User> users = new ArrayList<User>();
        if (sysUsers != null && sysUsers.size() > 0) {
            for (SysUser sysUser : sysUsers) {
                User user = new User();
                BeanUtils.copyProperties(sysUser, user, "sysUserRoles");

                users.add(user);
            }
        }
        return users;
    }
}
