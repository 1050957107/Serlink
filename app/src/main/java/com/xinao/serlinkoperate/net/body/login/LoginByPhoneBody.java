package com.xinao.serlinkclient.net.body.login;

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
    //推送设备token，指的是注册推送平台成功返回的token
    private String deviceCode;
    //设备类型 2-Android
    private String osType;
    //用户登录类型 1-客户端
    private String userType;

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

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
