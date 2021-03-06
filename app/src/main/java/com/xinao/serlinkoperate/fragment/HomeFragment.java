package com.xinao.serlinkoperate.fragment;

import android.os.Bundle;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseFragment;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;

public class HomeFragment extends BaseFragment<Presenter> implements IBaseView {

    public static HomeFragment newInstance(Bundle bundle) {
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void refreshData() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initPresenter() {
        mPresenter=new Presenter(this);
        mPresenter.init();
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void init() {

    }
}
