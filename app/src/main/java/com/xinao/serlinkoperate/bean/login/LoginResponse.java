package com.xinao.serlinkoperate.bean.login;

import java.io.Serializable;

/**
 * 登录成功之后返回的数据实体
 */
public class LoginResponse implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
    private String token;
    private int userId;
    private String mobile;

    public int getUserId() {
        return userId;
    }

    public LoginResponse setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public LoginResponse setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
