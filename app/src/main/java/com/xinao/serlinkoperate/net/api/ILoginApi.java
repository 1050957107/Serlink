package com.xinao.serlinkoperate.net.api;

/**
 * 对应每个模块的API请求连接
 */
public interface ILoginApi {

    /**
     * 获取登录验证码
     */
    String URL_SMS_CODE_FOR_LOGIN="business/smsCodeForLogin";

    /**
     * 手机验证码登录
     */
    String URL_LOGIN_BY_PHONE="business/loginByPhone";

}
