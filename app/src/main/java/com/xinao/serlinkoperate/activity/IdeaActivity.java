package com.xinao.serlinkoperate.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IdeaActivity extends BaseActivity<Presenter> implements IBaseView {


    @BindView(R.id.iv_code_back)
    ImageView ivCodeBack;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_idea;
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