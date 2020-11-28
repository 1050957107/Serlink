package com.xinao.serlinkoperate.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SafeActivity extends BaseActivity {




    @Override
    protected int provideContentViewId() {
        return R.layout.activity_safe;
    }

    @Override
    protected void initPresenter() {
        mPresenter = new Presenter(this);
        mPresenter.init();
    }

    @Override
    protected void destory() {

    }

    @Override
    public void init() {


    }

}