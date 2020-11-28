package com.xinao.serlinkoperate.login_register.mvp.presenter;

import com.xinao.serlinkoperate.base.BasePresenter;
import com.xinao.serlinkoperate.login_register.mvp.impl.CodeModelImpl;
import com.xinao.serlinkoperate.login_register.mvp.listener.ICodeListener;
import com.xinao.serlinkoperate.login_register.mvp.model.ICodeModel;
import com.xinao.serlinkoperate.login_register.mvp.view.ICodeView;

public class CodePresenter extends BasePresenter<ICodeView> implements ICodeModel, ICodeListener {
    private CodeModelImpl model;
    public CodePresenter(ICodeView mView) {
        super(mView);
        this.model=new CodeModelImpl(this);
    }

    @Override
    protected void removeView() {
        if (null!=mView){
            mView=null;
        }
    }

    /**
     * 验证码获取成功回调
     * @param response Requested data returned successfully
     */
    @Override
    public void requestSuccess(Object response) {
        if (null!=mView){
            mView.requestSuccess(response);
        }
    }

    /**
     * 验证码获取失败回调
     * @param status The Error status code
     * @param errorMsg The Error log information
     */
    @Override
    public void requestFailure(int status, String errorMsg) {
        if (null!=mView){
            mView.requestFailure(status, errorMsg);
        }
    }

    /**
     * 获取验证码 发起请求
     * @param params 参数
     */
    @Override
    public void requestDefault(Object params) {
        if (null!=model){
            model.requestDefault(params);
        }
    }

    /**
     * 登录成功 回调
     * @param response 返回数据体
     */
    @Override
    public void requestLoginByPhoneSuccess(Object response) {
        if (null!=mView){
            mView.requestLoginByPhoneSuccess(response);
        }
    }

    /**
     * 登录失败 回调
     * @param status 响应服务错误状态码
     * @param errorMsg 响应服务错误日志信息
     */
    @Override
    public void requestLoginByPhoneFailure(int status, String errorMsg) {
        if (null!=mView){
            mView.requestLoginByPhoneFailure(status, errorMsg);
        }
    }
    /**
     * 手机验证码登录
     * @param params 参数
     */
    @Override
    public void requestLoginByPhone(Object params) {
        if (null!=mView){
            mView.loginRequestLoading();
        }
        if (null!=model){
            model.requestLoginByPhone(params);
        }
    }
}
