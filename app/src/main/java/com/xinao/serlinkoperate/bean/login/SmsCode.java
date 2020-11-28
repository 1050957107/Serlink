package com.xinao.serlinkoperate.bean.login;

import java.io.Serializable;

/**
 * 获取验证码实体Bean 服务器返回数据
 */
public class SmsCode implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
