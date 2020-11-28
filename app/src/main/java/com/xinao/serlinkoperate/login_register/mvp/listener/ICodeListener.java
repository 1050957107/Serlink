package com.xinao.serlinkoperate.login_register.mvp.listener;

import com.xinao.serlinkoperate.base.IBaseListener;

public interface ICodeListener extends IBaseListener {

    /**
     * 登录成功 回调
     * @param response 返回数据体
     */
    void requestLoginByPhoneSuccess(Object response);

    /**
     * 登录失败 回调
     * @param status 响应服务错误状态码
     * @param errorMsg 响应服务错误日志信息
     */
    void requestLoginByPhoneFailure(int status, String errorMsg);
}
