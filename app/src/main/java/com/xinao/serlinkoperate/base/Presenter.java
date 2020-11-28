package com.xinao.serlinkoperate.base;

public class Presenter extends BasePresenter<IBaseView> {

    public Presenter(IBaseView mView) {
        super(mView);
    }

    @Override
    protected void removeView() {
        mView=null;
    }
}
