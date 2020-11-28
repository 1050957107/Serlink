package com.xinao.serlinkoperate.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;


/**
 * Activity 基类
 *
 * @param <T>
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseView {
    protected T mPresenter;
    protected Context mContext;
    protected Bundle bundle;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null == bundle) {
            bundle = new Bundle();
        }
        setContentView(provideContentViewId());
        ButterKnife.bind(this);
        mContext = this;
        initPresenter();
    }



    @Override
    protected void onDestroy() {
        mPresenter.removeView();
        destory();
        super.onDestroy();
    }

    @Override
    public final void onBackPressed() {
        if (!onBackPressedInternal()) {
            super.onBackPressed();
        }
    }

    public boolean onBackPressedInternal() {
        return false;
    }

    /**
     * 布局
     *
     * @return
     */
    protected abstract int provideContentViewId();

    /**
     * 初始化 presenter层
     */
    protected abstract void initPresenter();


    protected abstract void destory();


}
