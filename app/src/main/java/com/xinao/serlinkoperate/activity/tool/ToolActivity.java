package com.xinao.serlinkoperate.activity.tool;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.activity.tool.toolfragment.ProjectFragment;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.wedgit.FragmentAdapter;

import java.util.ArrayList;

import butterknife.BindView;

public class ToolActivity extends BaseActivity {


    @BindView(R.id.tool_tab)
    TabLayout toolTab;
    @BindView(R.id.tool_ViewPager)
    ViewPager toolViewPager;


    @Override
    protected int provideContentViewId() {
        return R.layout.activity_tool;
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
        initView();
    }

    protected void initView() {
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments());
        toolViewPager.setCurrentItem(0);
        toolViewPager.setOffscreenPageLimit(0);
        toolViewPager.setAdapter(fragmentAdapter);
        toolTab.setupWithViewPager(toolViewPager);
        toolTab.getTabAt(0).setText("光伏特");
        toolTab.getTabAt(1).setText("电力账单");
        toolTab.getTabAt(2).setText("热力托管");
        toolTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public ArrayList<Fragment> fragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragments.add(new ProjectFragment());
        }
        return fragments;
    }
}