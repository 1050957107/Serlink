package com.xinao.serlinkoperate.fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseFragment;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.fragment.messageinfo.AlarmFragment;
import com.xinao.serlinkoperate.fragment.messageinfo.FocusFragment;
import com.xinao.serlinkoperate.fragment.messageinfo.NotificationFragment;
import com.xinao.serlinkoperate.wedgit.FragmentAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;

public class MessageFragment extends BaseFragment<Presenter> implements IBaseView {


    @BindView(R.id.group1)
    RelativeLayout group1;
    @BindView(R.id.tang)
    ImageView tang;
    @BindView(R.id.unmessage)
    TextView unmessage;
    @BindView(R.id.group2)
    RelativeLayout group2;
    @BindView(R.id.message_banner)
    BGABanner messageBanner;
    @BindView(R.id.message_TabLayout)
    TabLayout messageTabLayout;
    @BindView(R.id.message_NoSlidingViewPager)
    ViewPager messageNoSlidingViewPager;


    public static MessageFragment newInstance(Bundle bundle) {
        MessageFragment fragment = new MessageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void refreshData() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_message;
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
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getActivity().getSupportFragmentManager(), fragments());
        messageNoSlidingViewPager.setCurrentItem(0);
        messageNoSlidingViewPager.setOffscreenPageLimit(0);
        messageNoSlidingViewPager.setAdapter(fragmentAdapter);
        messageTabLayout.setupWithViewPager(messageNoSlidingViewPager);
        messageTabLayout.getTabAt(0).setText("告警");
        messageTabLayout.getTabAt(1).setText("重点关注(51)");
        messageTabLayout.getTabAt(2).setText("通知");
    }


    public ArrayList<Fragment> fragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new AlarmFragment());
        fragments.add(new FocusFragment());
        fragments.add(new NotificationFragment());
        return fragments;
    }
}
