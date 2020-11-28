package com.xinao.serlinkoperate.login_register;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.util.IHelper;
import com.xinao.serlinkoperate.util.IKey;
import com.xinao.serlinkoperate.util.IntentUtils;
import com.xinao.serlinkoperate.util.RegexUtil;
import com.xinao.serlinkoperate.util.ToastUtil;
import com.xinao.serlinkoperate.wedgit.NoDoubleClickListener;

import butterknife.BindView;

public class LoginActivity extends BaseActivity<Presenter> implements IBaseView {
    private static final String TAG = LoginActivity.class.getName();

    @BindView(R.id.ll_back)
    LinearLayout llBack;

    @BindView(R.id.tv_login_phone)
    TextView tvPhone;//手机号
    @BindView(R.id.tv_login_register)
    TextView tvRegister;//注册

    @BindView(R.id.tv_login_other_phone)
    TextView tvOther;//其它手机号登录
    @BindView(R.id.tv_login_user_password)
    TextView tvPassword;//账户密码登录

    @BindView(R.id.tv_agreement_user)
    TextView tvUser;//用户协议
    @BindView(R.id.tv_agreement_privacy_policy)
    TextView tvPrivacyPolicy;//隐私政策

    @BindView(R.id.cl_login_onekey)
    ConstraintLayout clOnekey;//一键登录
    @BindView(R.id.cl_phone_input)
    ConstraintLayout clInput;//其它手机登录
    @BindView(R.id.cl_hone_password)
    ConstraintLayout clPassword;//账户密码登录

    @BindView(R.id.ace_login_phone)
    AppCompatEditText acePhone;//手机号输入 loginType = 2 才会触发
    @BindView(R.id.ace_login_input_user)
    AppCompatEditText aceInputUser;//账户输入 loginType = 3 才会触发
    @BindView(R.id.ace_login_input_password)
    AppCompatEditText acePassword;//密码输入 loginType = 3 才会触发

    @BindView(R.id.iv_password_icon)
    ImageView ivPassword;//密码的显示与隐藏开关
    @BindView(R.id.tv_password_error_tips)
    TextView tvPasswordError;//密码错误的提示文本
    @BindView(R.id.tv_retrieve_password)
    TextView tvRetrievePassword;//找回密码

    @BindView(R.id.tv_login_submit)
    TextView tvSubmit;//提交登录

    //登录类型
    private int loginType = IHelper.LOGIN_TYPE_ONEKEY;
    //控制密码显示与隐藏的开关
    private boolean isPasswordOpen = false;

    public static LoginActivity instance;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initPresenter() {
        if (null==instance) {
            instance = this;
        }
        mPresenter = new Presenter(this);
        mPresenter.init();
    }

    @Override
    protected void destory() {

    }

    @Override
    public void init() {

        llBack.setOnClickListener(noDoubleClickListener);
        tvRegister.setOnClickListener(noDoubleClickListener);
        tvOther.setOnClickListener(noDoubleClickListener);
        tvPassword.setOnClickListener(noDoubleClickListener);
        tvUser.setOnClickListener(noDoubleClickListener);
        tvPrivacyPolicy.setOnClickListener(noDoubleClickListener);
        ivPassword.setOnClickListener(noDoubleClickListener);
        tvRetrievePassword.setOnClickListener(noDoubleClickListener);
        tvSubmit.setOnClickListener(noDoubleClickListener);

        findViewById(R.id.iv_login_weichat).setOnClickListener(noDoubleClickListener);
    }

    private NoDoubleClickListener noDoubleClickListener = new NoDoubleClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.ll_back:
                    layoutBackClick();
                    break;
                case R.id.tv_login_register:
                    //注册
                    onekeyLogin(false);
                    otherLogin(true);
                    break;
                case R.id.tv_login_other_phone:
                    //其它手机登录
                    tvOtherClick();
                    break;
                case R.id.tv_login_user_password:
                    //账户密码
                    tvPasswordClick();
                    break;
                case R.id.iv_password_icon:
                    //控制密码可见或不可见的开关
                    passwordHideOrOpen();
                    break;
                case R.id.tv_retrieve_password:
                    //找回密码
                    IntentUtils.getIntance().intent(LoginActivity.this, ForgetPasswordActivity.class, null);
                    break;
                case R.id.tv_agreement_user:
                    //用户协议
                    break;
                case R.id.tv_agreement_privacy_policy:
                    //隐私政策
                    break;
                case R.id.tv_login_submit:
                    //提交登录
                    submitClick();
                    break;
                case R.id.iv_login_weichat:
                    //微信登录
                    IntentUtils.getIntance().intent(LoginActivity.this, BindPhoneActivity.class, null);
                    break;
            }
        }
    };

    /**
     * 返回键
     */
    private void backLayout(boolean isVisibility) {
        llBack.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
    }

    /**
     * 一键登录
     */
    private void onekeyLogin(boolean isVisibility) {
        clOnekey.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
        if (isVisibility) {
            //恢复一键登录状态标识
            loginType = IHelper.LOGIN_TYPE_ONEKEY;
            //返回按钮变为隐藏状态
            backLayout(false);
            //恢复《其它手机号登录》文本
            tvOther.setText(getResources().getString(R.string.other_phone));
            //恢复《账密登录》文本
            tvPassword.setText(getResources().getString(R.string.user_password_login));
            //提交按钮文字变为《本地号码一键登录》
            tvSubmit.setText(getResources().getString(R.string.login_txt));
        }
    }


    /**
     * 其它手机登录
     */
    private void otherLogin(boolean isVisibility) {
        clInput.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
        if (isVisibility) {
            //标识变为 手机号发送验证码状态
            loginType = IHelper.LOGIN_TYPE_PHONE_CODE;
            //返回按钮变为显示状态
            backLayout(true);
            //《其它手机号登录》文本变为《密码登录》
            tvOther.setText(getResources().getString(R.string.password_login));
            //《账密登录》文本变为《遇到问题》
            tvPassword.setText(getResources().getString(R.string.problems_encountered));
            //提交按钮文字变为《发送验证码》
            tvSubmit.setText("发送验证码");
        }
    }

    /**
     * 账户密码登录
     */
    private void userAndPasswordLogin(boolean isVisibility) {
        clPassword.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
        if (isVisibility) {
            //标识变为 账户密码输入状态
            loginType = IHelper.LOGIN_TYPE_USER_PASSWORD;
            //返回按钮变为显示状态
            backLayout(true);
            //《密码登录》文本变为《验证码登录》
            tvOther.setText(getResources().getString(R.string.code_login));
            //《遇到问题》文本变为《立即注册》
            tvPassword.setText(getResources().getString(R.string.immediately_register));
            //提交按钮文字变为《登录》
            tvSubmit.setText("登录");
        }
    }

    /**
     * 返回键点击
     */
    private void layoutBackClick() {
        switch (loginType) {
            case IHelper.LOGIN_TYPE_PHONE_CODE:
                //处于手机验证码登录状态标识时候 按下返回键 返回一键登录状态
                loginType = IHelper.LOGIN_TYPE_ONEKEY;
                otherLogin(false);
                onekeyLogin(true);
                break;
            case IHelper.LOGIN_TYPE_USER_PASSWORD:
                //处于账户密码登录状态标识时候 按下返回键 返回一键登录状态
                loginType = IHelper.LOGIN_TYPE_ONEKEY;
                userAndPasswordLogin(false);
                onekeyLogin(true);
                break;
        }
    }

    /**
     * 其它手机号按钮点击
     */
    private void tvOtherClick() {
        switch (loginType) {
            case IHelper.LOGIN_TYPE_ONEKEY:
                /*
                 * 处于初始状态的时候，按下当前按钮
                 * 1、隐藏一键登录布局
                 * 2、放开手机输入框布局
                 * 3、显示返回按钮
                 * 4、标识变为手机验证码登录标识 loginType=IHelper.LOGIN_TYPE_PHONE_CODE
                 */
                onekeyLogin(false);
                //方法里面已包含 2 3 4项
                otherLogin(true);
                break;
            case IHelper.LOGIN_TYPE_PHONE_CODE:
                /*
                 * 处于手机验证码登录状态的时候，按下当前按钮
                 * 1、隐藏手机输入框布局
                 * 2、放开账户密码输入框布局
                 * 3、显示返回按钮
                 * 4、标识变为账户密码登录标识 loginType=IHelper.LOGIN_TYPE_USER_PASSWORD
                 */
                otherLogin(false);
                //该方法已包含 2 3 4项
                userAndPasswordLogin(true);
                break;
            case IHelper.LOGIN_TYPE_USER_PASSWORD:
                /*
                 * 处于账户密码登录状态的时候，按下当前按钮
                 * 1、隐藏账户密码输入框布局
                 * 2、放开一键登录布局
                 * 3、隐藏返回按钮
                 * 4、标识变为初始状态标识 loginType=IHelper.LOGIN_TYPE_PHONE_CODE
                 */
                userAndPasswordLogin(false);
                otherLogin(true);
                break;
        }
    }

    /**
     * 账密登录按钮点击
     */
    private void tvPasswordClick() {
        switch (loginType) {
            case IHelper.LOGIN_TYPE_ONEKEY:
                /*
                 * 处于初始状态的时候，按下当前按钮
                 * 1、隐藏一键登录布局
                 * 2、放开账户密码输入框布局
                 * 3、显示返回按钮
                 * 4、标识变为手机验证码登录标识 loginType=IHelper.LOGIN_TYPE_USER_PASSWORD
                 */
                onekeyLogin(false);
                //方法里面已包含 2 3 4项
                userAndPasswordLogin(true);
                break;
            case IHelper.LOGIN_TYPE_PHONE_CODE:
                /*
                 * 处于手机验证码登录状态的时候，按下当前按钮
                 * 点击前往《遇到问题》
                 */
                ToastUtil.show(getApplicationContext(), "遇到问题");
                break;
            case IHelper.LOGIN_TYPE_USER_PASSWORD:
                /*
                 * 处于账户密码登录状态的时候，按下当前按钮
                 * 1、隐藏账户密码输入框布局
                 * 2、放开一键登录布局
                 * 3、隐藏返回按钮
                 * 4、标识变为初始状态标识 loginType=IHelper.LOGIN_TYPE_ONEKEY
                 */
                userAndPasswordLogin(false);
                onekeyLogin(true);
                break;
        }
    }

    /**
     * 提交按钮点击
     */
    private void submitClick() {
        switch (loginType) {
            case IHelper.LOGIN_TYPE_ONEKEY:
                //本地一键登录的操作逻辑
                break;
            case IHelper.LOGIN_TYPE_PHONE_CODE:
                //下一步 操作-发送验证码
                String phone = RegexUtil.textToString(acePhone);
                if (!RegexUtil.checkMobile(phone)) {
                    ToastUtil.show(getApplicationContext(), "手机号码不符合要求");
                    return;
                }
                bundle.putString(IKey.KEY_BUNDLE_PHONE, phone);
                IntentUtils.getIntance().intent(LoginActivity.this, CodeActivity.class, bundle);
                break;
            case IHelper.LOGIN_TYPE_USER_PASSWORD:
                //登录逻辑
                break;
        }
    }

    /**
     * 密码的可见与不可见
     */
    private void passwordHideOrOpen() {
        if (isPasswordOpen) {
            //设置密码为隐藏的
            acePassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ivPassword.setImageResource(R.drawable.icon_password_hide);
        } else {
            //设置密码为可见的
            acePassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ivPassword.setImageResource(R.drawable.icon_password_open);
        }
        isPasswordOpen = !isPasswordOpen;
    }

    /**
     * 用户协议
     */
    private void agreementUser() {

    }

    /**
     * 隐私政策
     */
    private void privacyPolicy() {

    }

}