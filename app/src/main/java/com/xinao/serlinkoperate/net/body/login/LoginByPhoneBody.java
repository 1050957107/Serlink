package com.xinao.serlinkoperate.net.body.login;

/**
 * 手机验证码登录 参数 Body实体类
 * 这个最后通过Retrfit底层演变成一个 Json字符串
 * 如：{"phoneNo":xxxxxxxxx,"smsCode":xxxxx}
 */
public class LoginByPhoneBody {
    //手机号
    private String phoneNo;
    //验证码
    private String smsCode;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
