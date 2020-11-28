package com.xinao.serlinkoperate.login_register.mvp.presenter;

import com.xinao.serlinkoperate.base.BasePresenter;
import com.xinao.serlinkoperate.login_register.mvp.impl.LoginModelImpl;
import com.xinao.serlinkoperate.login_register.mvp.listener.ILoginListener;
import com.xinao.serlinkoperate.login_register.mvp.model.ILoginModel;
import com.xinao.serlinkoperate.login_register.mvp.view.ILoginView;

public class LoginPresenter extends BasePresenter<ILoginView> implements ILoginModel, ILoginListener {
    private LoginModelImpl model;
    public LoginPresenter(ILoginView mView) {
        super(mView);
        this.model=new LoginModelImpl(this);
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
}
