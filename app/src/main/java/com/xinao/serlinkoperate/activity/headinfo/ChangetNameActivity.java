package com.xinao.serlinkoperate.activity.headinfo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangetNameActivity extends BaseActivity<Presenter> implements IBaseView {


    @BindView(R.id.group3)
    LinearLayout group3;
    @BindView(R.id.iv_code_back)
    ImageView ivCodeBack;
    @BindView(R.id.group1)
    RelativeLayout group1;
    @BindView(R.id.group2)
    LinearLayout group2;
    @BindView(R.id.nc_name)
    TextView ncName;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_changet_name;
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


    @OnClick(R.id.iv_code_back)
    public void onViewClicked() {
        finish();
    }
}