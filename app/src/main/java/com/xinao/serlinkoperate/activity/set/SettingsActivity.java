package com.xinao.serlinkoperate.activity.set;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.util.IntentUtils;
import com.xinao.serlinkoperate.util.ToastUtil;
import com.xinao.serlinkoperate.wedgit.NoDoubleClickListener;

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
    @BindView(R.id.clear_context)
    TextView clearContext;
    @BindView(R.id.clear)
    RelativeLayout clear;

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
        setAboutapp.setOnClickListener(doubleClickListener);
        settingSet.setOnClickListener(doubleClickListener);
        ivCodeBack.setOnClickListener(doubleClickListener);
        clear.setOnClickListener(doubleClickListener);
    }

    private NoDoubleClickListener doubleClickListener=new NoDoubleClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.setting_set:
                    IntentUtils.getIntance().intent(SettingsActivity.this,SettingActivity.class,null);
                    break;
                case R.id.set_aboutapp:
                    IntentUtils.getIntance().intent(SettingsActivity.this,AboutAppActivity.class,null);
                    break;
                case R.id.iv_code_back:
                    finish();
                    break;
                case R.id.clear:
                    ToastUtil.show(SettingsActivity.this,"清除完毕");
                    clearContext.setText("0M");
                    break;
            }
        }
    };

}