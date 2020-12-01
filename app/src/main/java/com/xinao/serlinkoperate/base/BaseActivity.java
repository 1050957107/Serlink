package com.xinao.serlinkoperate.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

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

    public void closeInputMethod(){

        try {

            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))

                    .hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),

                            InputMethodManager.HIDE_NOT_ALWAYS);

        } catch (Exception e) { }finally{ }

    }

    /**

     *

     * @MethodName:openInputMethod

     * @Description:打开系统软键盘

     * @throws

     */

    public void openInputMethod(View v){

        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

    }
}
