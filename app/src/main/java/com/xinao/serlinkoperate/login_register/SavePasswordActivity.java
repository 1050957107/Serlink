package com.xinao.serlinkoperate.login_register;


import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;

public class SavePasswordActivity extends BaseActivity<Presenter> implements IBaseView {
    private static final String TAG=SavePasswordActivity.class.getName();
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_save_password;
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

    }
}