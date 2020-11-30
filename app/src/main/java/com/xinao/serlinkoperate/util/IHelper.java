package com.xinao.serlinkoperate.util;

public interface IHelper {
    int LOGIN_DEFAULT = 0;
    int LOGIN_SUCCESS = 1;

    String LOGIN_MESSAGE = "需要您登录哟~";

    int LOGIN_TYPE_ONEKEY=1;//一键登录标识
    int LOGIN_TYPE_PHONE_CODE=2;//手机验证码登录标识
    int LOGIN_TYPE_USER_PASSWORD=3;//账户密码登录标识

    int NETWORK_SUCCESS = 200;
    int NETWORK_ERROR = 1002;//网络错误
    String NETWORK_ERROR_MSG = "访问失败";
    int SSL_ERROR = 1005;//证书出错
    String SSL_ERROR_MSG = "证书出错";
    int UNKNOWN = 1000;//未知错误
    int PARSE_ERROR = 1001;//数据解析错误
    String PARSE_ERROR_MSG = "访问失败";
    int NETWORK_404 = 404; //其它错误
    int NETWORK_999 = 999;
    String ERROR_ORDER_MSG = "请求失败";

    int HANDLER_LOGIN_CODE_SUCCESS=0x11;
    int HANDLER_LOGIN_CODE_ERROR=0x12;
    int HANDLER_MAIN_FIND_USER=0x13;

}

