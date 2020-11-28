package com.xinao.serlinkoperate.net.body.login;

/**
 * 获取验证码 参数 Body实体类
 * 这个最后通过Retrfit底层演变成一个 Json字符串
 * 如：{"phoneNo":xxxxxxxxx}
 */
public class SmsCodeBody {
    //手机号 Json串的key值
    private String phoneNo;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
