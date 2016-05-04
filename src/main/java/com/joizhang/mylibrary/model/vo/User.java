package com.joizhang.mylibrary.model.vo;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/5/4.
 */
public class User {
    private String userId;
    private String username;
    private String password;
    private String salt;
    private Timestamp createTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }
}
