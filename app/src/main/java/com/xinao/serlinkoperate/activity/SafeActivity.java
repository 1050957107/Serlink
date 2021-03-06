package com.xinao.serlinkoperate.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SafeActivity extends BaseActivity<Presenter> implements IBaseView {


    @BindView(R.id.iv_code_back)
    ImageView ivCodeBack;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.iv_arrow)
    ImageView ivArrow;
    @BindView(R.id.passset)
    RelativeLayout passset;

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


    @OnClick(R.id.iv_code_back)
    public void onViewClicked() {
        finish();
    }
}