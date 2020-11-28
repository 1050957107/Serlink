package com.xinao.serlinkoperate.net.server;

import com.xinao.serlinkoperate.bean.login.LoginResponse;
import com.xinao.serlinkoperate.bean.login.SmsCode;
import com.xinao.serlinkoperate.net.api.ILoginApi;
import com.xinao.serlinkoperate.net.body.login.LoginByPhoneBody;
import com.xinao.serlinkoperate.net.body.login.SmsCodeBody;
import com.xinao.serlinkoperate.net.manager.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ILoginApiServer {

    /**
     * 登录获取验证码
     * @param smsCodeBody 参数
     * @return
     */
    @POST(ILoginApi.URL_SMS_CODE_FOR_LOGIN)
    Call<Response<SmsCode>> requestSmsCodeForLogin(@Body SmsCodeBody smsCodeBody);

    /**
     * 登录获取验证码
     * @param loginByPhoneBody 参数
     * @return
     */
    @POST(ILoginApi.URL_LOGIN_BY_PHONE)
    Call<Response<LoginResponse>> requestLoginByPhone(@Body LoginByPhoneBody loginByPhoneBody);

}
