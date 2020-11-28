package com.xinao.serlinkoperate.base;

/**
 * 说明: Presenter中间层
 */

public abstract class BasePresenter<T extends IBaseView> {
    protected T mView;

    public BasePresenter(T mView) {
        this.mView = mView;
    }

    public void init() {
        if (mView != null) mView.init();
    }

    protected abstract void removeView();

}
