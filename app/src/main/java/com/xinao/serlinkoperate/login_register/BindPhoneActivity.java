package com.xinao.serlinkoperate.login_register;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.util.IntentUtils;
import com.xinao.serlinkoperate.wedgit.NoDoubleClickListener;

import butterknife.BindView;

public class BindPhoneActivity extends BaseActivity<Presenter> implements IBaseView {

    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_code_back)
    TextView tvTitle;
    @BindView(R.id.tv_bind_submit)
    TextView tvBindSubmit;

    @BindView(R.id.cl_phone_input)
    ConstraintLayout clInput;



    @Override
    protected int provideContentViewId() {
        return R.layout.activity_bind_phone;
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
        tvTitle.setText("绑定手机号");
        llBack.setVisibility(View.VISIBLE);
        clInput.setVisibility(View.VISIBLE);
        tvBindSubmit.setOnClickListener(noDoubleClickListener);
        llBack.setOnClickListener(noDoubleClickListener);
    }

    private NoDoubleClickListener noDoubleClickListener=new NoDoubleClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.ll_back:
                    finish();
                    break;
                case R.id.tv_bind_submit:
                    IntentUtils.getIntance().intent(BindPhoneActivity.this,CodeActivity.class,null);
                    break;
            }
        }
    };
}