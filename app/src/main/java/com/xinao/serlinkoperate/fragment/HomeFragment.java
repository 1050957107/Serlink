package com.xinao.serlinkoperate.fragment;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseFragment;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<Presenter> implements IBaseView {

    @BindView(R.id.webview)
    WebView webview;

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
        mPresenter = new Presenter(this);
        mPresenter.init();
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void init() {
        webview.loadUrl("http://49.232.144.208:8080/index.html#/");
        webview.setWebViewClient(new WebViewClient());
    }
}
