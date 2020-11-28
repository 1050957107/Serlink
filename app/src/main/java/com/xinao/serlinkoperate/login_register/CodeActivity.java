package com.xinao.serlinkoperate.login_register;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xinao.serlinkoperate.activity.MainActivity;
import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.bean.login.LoginResponse;
import com.xinao.serlinkoperate.bean.login.SmsCode;
import com.xinao.serlinkoperate.login_register.mvp.presenter.CodePresenter;
import com.xinao.serlinkoperate.login_register.mvp.view.ICodeView;
import com.xinao.serlinkoperate.net.body.login.LoginByPhoneBody;
import com.xinao.serlinkoperate.net.body.login.SmsCodeBody;
import com.xinao.serlinkoperate.util.IKey;
import com.xinao.serlinkoperate.util.IntentUtils;
import com.xinao.serlinkoperate.util.LoggerUtils;
import com.xinao.serlinkoperate.util.ToastUtil;
import com.xinao.serlinkoperate.wedgit.NoDoubleClickListener;
import com.xinao.serlinkoperate.wedgit.NumberCaptchaInputView;
import com.xinao.serlinkoperate.wedgit.TimerCount;

import butterknife.BindView;

public class CodeActivity extends BaseActivity<CodePresenter> implements ICodeView {
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
    }

    @Override
    public void init() {
        llBack.setVisibility(View.VISIBLE);

        if (null == timer) {
            timer = new TimerCount(60000, 1000, tvAgainSend);
            timer.setTxt("重新发送验证码");
        }

        requestSmsCode();

        tvAgainSend.setOnClickListener(noDoubleClickListener);
        llBack.setOnClickListener(noDoubleClickListener);

        ncivCode.setListener(new NumberCaptchaInputView.OnCaptchaListener() {
            @Override
            public void onCaptchaInputFinish(CharSequence captcha) {
                LoggerUtils.e(TAG, "onCaptchaInputFinish.captcha" + captcha.toString());
                //验证码输入完自动触发登录请求
                requestLoginByPhone(captcha.toString());
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
        mPresenter.requestLoginByPhone(body);
    }

    /**
     * 登录加载进度框UI
     */
    @Override
    public void loginRequestLoading() {
//        WaitDialog.show(CodeActivity.this, "登录中...")
//                .setOnBackClickListener(() -> false);
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
        if (null != login) {
//            new Handler().postDelayed(() ->
//                    runOnUiThread(() ->
//                            TipDialog.show(CodeActivity.this, "成功！",
//                                    TipDialog.TYPE.SUCCESS).setOnDismissListener(() ->
                                    IntentUtils.getIntance().intent(CodeActivity.this, MainActivity.class, null);
//        )), 1000);
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
        ToastUtil.show(getApplicationContext(), errorMsg);
//        new Handler().postDelayed(() -> runOnUiThread(() ->
//                TipDialog.show(CodeActivity.this,errorMsg,TipDialog.TYPE.ERROR).doDismiss()),1000);
    }
}