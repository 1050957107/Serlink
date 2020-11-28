package com.xinao.serlinkoperate.login_register.mvp.impl;

import com.xinao.serlinkoperate.bean.login.SmsCode;
import com.xinao.serlinkoperate.login_register.mvp.listener.ILoginListener;
import com.xinao.serlinkoperate.login_register.mvp.model.ILoginModel;
import com.xinao.serlinkoperate.net.body.login.SmsCodeBody;
import com.xinao.serlinkoperate.net.manager.Response;
import com.xinao.serlinkoperate.net.manager.ResquestManager;
import com.xinao.serlinkoperate.util.IHelper;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginModelImpl implements ILoginModel {
    private ILoginListener listener;
    public LoginModelImpl(ILoginListener l){
        this.listener=l;
    }

    /**
     * 获取验证码
     * @param params 参数
     */
    @Override
    public void requestDefault(Object params) {
        Call<Response<SmsCode>> call= ResquestManager.getInstance().iLoginApiServer().requestSmsCodeForLogin((SmsCodeBody) params);
        call.enqueue(new Callback<Response<SmsCode>>() {
            @Override
            public void onResponse(Call<Response<SmsCode>> call, retrofit2.Response<Response<SmsCode>> response) {
                Response<SmsCode> smsCode = response.body();
                if (null == smsCode) {
                    if (null != listener) {
                        listener.requestFailure(IHelper.NETWORK_404, IHelper.ERROR_ORDER_MSG);
                    }
                    return;
                }
                if (smsCode.getCode() == IHelper.NETWORK_SUCCESS) {
                    if (null != listener) {
                        listener.requestSuccess(smsCode.getData());
                    }
                } else {
                    if (null != listener) {
                        listener.requestFailure(smsCode.getCode(), smsCode.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<Response<SmsCode>> smsCode, Throwable t) {
                if (null != listener)
                    listener.requestFailure(IHelper.NETWORK_ERROR, IHelper.NETWORK_ERROR_MSG);
            }
        });
    }
}
