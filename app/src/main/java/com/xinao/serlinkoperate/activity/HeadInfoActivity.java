package com.xinao.serlinkoperate.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.Presenter;

public class HeadInfoActivity extends BaseActivity {


    @Override
    protected int provideContentViewId() {
        return R.layout.activity_head_info;
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