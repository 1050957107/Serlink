package com.xinao.serlinkoperate.activity.set;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends BaseActivity<Presenter> implements IBaseView {

    @BindView(R.id.setting_set)
    RelativeLayout settingSet;
    @BindView(R.id.set_aboutapp)
    RelativeLayout setAboutapp;
    @BindView(R.id.iv_code_back)
    ImageView ivCodeBack;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_settings;
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


    @OnClick({R.id.setting_set, R.id.set_aboutapp,R.id.iv_code_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_set:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.set_aboutapp:
                startActivity(new Intent(this, AboutAppActivity.class));
                break;
            case R.id.iv_code_back:
                finish();
                break;
        }
    }

}