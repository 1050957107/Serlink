package com.xinao.serlinkoperate.login_register;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.kongzue.dialog.v3.TipDialog;
import com.kongzue.dialog.v3.WaitDialog;
import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.activity.MainActivity;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.bean.login.LoginResponse;
import com.xinao.serlinkoperate.bean.login.SmsCode;
import com.xinao.serlinkoperate.login_register.mvp.presenter.CodePresenter;
import com.xinao.serlinkoperate.login_register.mvp.view.ICodeView;
import com.xinao.serlinkoperate.net.body.login.LoginByPhoneBody;
import com.xinao.serlinkoperate.net.body.login.SmsCodeBody;
import com.xinao.serlinkoperate.room.RoomManager;
import com.xinao.serlinkoperate.room.entity.UserInfo;
import com.xinao.serlinkoperate.util.IHandlerListener;
import com.xinao.serlinkoperate.util.IHelper;
import com.xinao.serlinkoperate.util.IKey;
import com.xinao.serlinkoperate.util.IntentUtils;
import com.xinao.serlinkoperate.util.LoggerUtils;
import com.xinao.serlinkoperate.util.PublicHander;
import com.xinao.serlinkoperate.util.ToastUtil;
import com.xinao.serlinkoperate.wedgit.NoDoubleClickListener;
import com.xinao.serlinkoperate.wedgit.NumberCaptchaInputView;
import com.xinao.serlinkoperate.wedgit.TimerCount;

import butterknife.BindView;

public class CodeActivity extends BaseActivity<CodePresenter> implements ICodeView, IHandlerListener {
    private static final String TAG = CodeActivity.class.getName();

    @BindView(R.id.ll_back)
    LinearLayout llBack;

    @BindView(R.id.tv_code_phone_name)
    TextView tvPhoneName;
    @BindView(R.id.tv_code_again_send)
    TextView tvAgainSend;
    @BindView(R.id.nciv_code)
    NumberCaptchaInputView ncivCode;

    private TimerCount timer;
    private Bundle bundle;
    private String phone;

    private PublicHander publicHander;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_code;
    }

    @Override
    protected void initPresenter() {
        bundle = getIntent().getExtras();
        mPresenter = new CodePresenter(this);
        mPresenter.init();
    }

    @Override
    protected void destory() {
        if (null != timer) {
            timer.onFinish();
        }
        if (null != publicHander) {
            publicHander.removeMessages(IHelper.HANDLER_LOGIN_CODE_SUCCESS);
            publicHander.removeMessages(IHelper.HANDLER_LOGIN_CODE_ERROR);
            publicHander = null;
        }
    }

    @Override
    public void init() {
        llBack.setVisibility(View.VISIBLE);

        if (null == timer) {
            timer = new TimerCount(60000, 1000, tvAgainSend);
            timer.setTxt("重新发送验证码");
        }
        if (null == publicHander) {
            publicHander = new PublicHander();
        }
        //增加监听
        publicHander.setHandlerListener(this);

        requestSmsCode();

        tvAgainSend.setOnClickListener(noDoubleClickListener);
        llBack.setOnClickListener(noDoubleClickListener);

        ncivCode.setListener(new NumberCaptchaInputView.OnCaptchaListener() {
            @Override
            public void onCaptchaInputFinish(CharSequence captcha) {
                LoggerUtils.e(TAG, "onCaptchaInputFinish.captcha" + captcha.toString());
                //验证码输入完自动触发登录请求
                requestLoginByPhone("1234");
            }

            @Override
            public void onCaptchaTextSize(CharSequence captcha, int size) {
                LoggerUtils.e(TAG, "onCaptchaTextSize.captcha" + captcha.toString());
            }
        });
    }

    private NoDoubleClickListener noDoubleClickListener = new NoDoubleClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.ll_back:
                    finish();
                    break;
                case R.id.tv_code_again_send:
                    //重新发送验证码的逻辑
                    requestSmsCode();
                    break;
            }
        }
    };

    /**
     * 获取验证码
     */
    private void requestSmsCode() {
        if (null != bundle && bundle.containsKey(IKey.KEY_BUNDLE_PHONE)) {
            phone = bundle.getString(IKey.KEY_BUNDLE_PHONE);
            String phoneTxt = getResources().getString(R.string.input_code_name);
            tvPhoneName.setText(phoneTxt + phone);

            if (null != timer) {
                timer.start();
            }

            //配置参数
            SmsCodeBody body = new SmsCodeBody();
            body.setPhoneNo(phone);
            //发起请求
            mPresenter.requestDefault(body);
        }
    }

    /**
     * 登录
     */
    private void requestLoginByPhone(String code) {
        LoginByPhoneBody body = new LoginByPhoneBody();
        if (!TextUtils.isEmpty(phone)) {
            body.setPhoneNo(phone);
        }
        body.setSmsCode(code);
        if (null!=bundle && bundle.containsKey(IKey.KEY_BUNDLE_TOKEN)){
            body.setDeviceCode(bundle.getString(IKey.KEY_BUNDLE_TOKEN));
        }
        body.setOsType(IKey.VALUE_OSTYPE);
        body.setUserType(IKey.VALUE_USERTYPE);
        mPresenter.requestLoginByPhone(body);
    }

    /**
     * 登录加载进度框UI
     */
    @Override
    public void loginRequestLoading() {
        WaitDialog.show(CodeActivity.this, "登录中...")
                .setOnBackClickListener(() -> false);
    }

    /**
     * 获取验证码成功 回调
     *
     * @param response Requested data returned successfully
     */
    @Override
    public void requestSuccess(Object response) {
        SmsCode smsCode = (SmsCode) response;
        if (null != smsCode) {
            ToastUtil.show(getApplicationContext(), "验证码：" + smsCode.getData());
        }
    }

    /**
     * 获取验证码失败 回调
     *
     * @param status   The Error status code
     * @param errorMsg The Error log information
     */
    @Override
    public void requestFailure(int status, String errorMsg) {
        ToastUtil.show(getApplicationContext(), errorMsg);
    }

    /**
     * 登录成功 回调
     *
     * @param response 返回数据体
     */
    @Override
    public void requestLoginByPhoneSuccess(Object response) {
        LoginResponse login = (LoginResponse) response;
        if (null != login && null != publicHander) {
            publicHander.removeMessages(IHelper.HANDLER_LOGIN_CODE_SUCCESS);
            Message message = publicHander.obtainMessage(IHelper.HANDLER_LOGIN_CODE_SUCCESS);
            message.obj = login.getToken();
            publicHander.sendMessageDelayed(message, 1000);
        }
    }

    /**
     * 登录失败 回调
     *
     * @param status   响应服务错误状态码
     * @param errorMsg 响应服务错误日志信息
     */
    @Override
    public void requestLoginByPhoneFailure(int status, String errorMsg) {
        if (null != publicHander) {
            publicHander.removeMessages(IHelper.HANDLER_LOGIN_CODE_ERROR);
            Message message = publicHander.obtainMessage(IHelper.HANDLER_LOGIN_CODE_ERROR);
            message.obj = errorMsg;
            publicHander.sendMessageDelayed(message, 1000);
        }
    }

    @Override
    public void handlerSendMsg(int status, Object obj) {
        switch (status) {
            case IHelper.HANDLER_LOGIN_CODE_SUCCESS:
                final String token = (String) obj;
                if (!TextUtils.isEmpty(token)) {
                    saveUserInfo(token);
                }
                TipDialog.show(CodeActivity.this, "登录成功！",
                        TipDialog.TYPE.SUCCESS).setOnDismissListener(() ->
                        {
                            if (null != LoginActivity.instance) {
                                LoginActivity.instance.finish();
                            }
                            IntentUtils.getIntance().intent(CodeActivity.this, MainActivity.class, null);
                        }
                );
                break;
            case IHelper.HANDLER_LOGIN_CODE_ERROR:
                String errorMsg = (String) obj;
                TipDialog.show(CodeActivity.this, errorMsg, TipDialog.TYPE.ERROR).doDismiss();
                break;
        }
    }

    /**
     * 将登陆返回的用户信息存入数据库中
     *
     * @param token
     */
    private void saveUserInfo(String token) {
        new Thread(() -> {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserid(String.valueOf(1));
            userInfo.setPhone(phone);
            userInfo.setToken(token);
            userInfo.setLoginstate(IHelper.LOGIN_SUCCESS);
            RoomManager.getInstance(CodeActivity.this).getUserDao().insertAll(userInfo);
        }).start();
    }
}