package com.xinao.serlinkoperate.login_register.mvp.model;

import com.xinao.serlinkoperate.base.IBaseModel;

public interface ICodeModel extends IBaseModel {

    /**
     * 手机验证码登录
     * @param params 参数
     */
    void requestLoginByPhone(Object params);
}
