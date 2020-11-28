package com.xinao.serlinkoperate.bean.login;

import java.io.Serializable;

/**
 * 登录成功之后返回的数据实体
 */
public class LoginResponse implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
