package com.xinao.serlinkoperate.login_register;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.util.RegexUtil;
import com.xinao.serlinkoperate.util.ToastUtil;
import com.xinao.serlinkoperate.wedgit.NoDoubleClickListener;
import com.xinao.serlinkoperate.wedgit.TimerCount;

import butterknife.BindView;

public class ForgetPasswordActivity extends BaseActivity<Presenter> implements IBaseView {

    @BindView(R.id.ll_back)
    LinearLayout llBack;

    @BindView(R.id.tv_forget_code)
    TextView tvCode;
    @BindView(R.id.ace_forget_phone)
    AppCompatEditText acePhone;
    @BindView(R.id.ace_forget_code)
    AppCompatEditText aceCode;

    private String tel = "";
    private TimerCount timer;




    @Override
    protected int provideContentViewId() {
        return R.layout.activity_forget_password;
    }

    @Override
    protected void initPresenter() {
        mPresenter=new Presenter(this);
        mPresenter.init();
    }

    @Override
    protected void destory() {

    }

    @Override
    public void init() {
        llBack.setVisibility(View.VISIBLE);
        tvCode.setOnClickListener(noDoubleClickListener);
        llBack.setOnClickListener(noDoubleClickListener);

        if (null == timer) {
            timer = new TimerCount(60000, 1000, tvCode);
            timer.setTxt("重新发送");
        }
    }

    private NoDoubleClickListener noDoubleClickListener = new NoDoubleClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.ll_back:
                    finish();
                    break;
                case R.id.tv_forget_code:
                    //发送验证码的逻辑
                    sendCode();
                    break;
            }
        }
    };

    /**
     * 发送验证码
     */
    private void sendCode(){
        tel = RegexUtil.textToString(acePhone);
        if (!RegexUtil.checkMobile(tel)) {
            ToastUtil.show(getApplicationContext(), "手机号码不符合要求");
            return;
        }
        if (null != timer) {
            timer.start();
        }
        //获取验证码
    }
}