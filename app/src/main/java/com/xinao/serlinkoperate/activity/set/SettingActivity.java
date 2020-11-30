package com.xinao.serlinkoperate.activity.set;

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

public class SettingActivity extends BaseActivity<Presenter> implements IBaseView {


    @BindView(R.id.iv_code_back)
    ImageView ivCodeBack;
    @BindView(R.id.group1)
    LinearLayout group1;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.group2)
    RelativeLayout group2;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.group3)
    RelativeLayout group3;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.group4)
    RelativeLayout group4;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.group5)
    RelativeLayout group5;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_setting;
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