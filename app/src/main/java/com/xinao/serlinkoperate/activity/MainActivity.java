package com.xinao.serlinkoperate.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.fragment.HomeFragment;
import com.xinao.serlinkoperate.fragment.MeFragment;
import com.xinao.serlinkoperate.fragment.MessageFragment;
import com.xinao.serlinkoperate.fragment.ServiceFragment;
import com.xinao.serlinkoperate.util.ToastUtil;
import com.xinao.serlinkoperate.wedgit.BottomNavigation;
import com.xinao.serlinkoperate.wedgit.FragmentAdapter;
import com.xinao.serlinkoperate.wedgit.NoSlidingViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<Presenter> implements IBaseView {

    @BindView(R.id.vp_fragment_list_top)
    NoSlidingViewPager noSlidingViewPager;
    @BindView(R.id.main_bottomNavigation)
    BottomNavigation mainBottomNavigation;


    private FragmentAdapter fragmentAdapter;
    private List<Fragment> fragmentList;


    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
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
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments());
        noSlidingViewPager.setAdapter(fragmentAdapter);
        noSlidingViewPager.setScroll(false);
        noSlidingViewPager.setCurrentItem(0);
        noSlidingViewPager.setOffscreenPageLimit(0);
        mainBottomNavigation.addItem(R.drawable.tab_home_select, getString(R.string.tab_home))
                .addItem(R.drawable.tab_see_select, getString(R.string.tab_see))
                .addItem(R.drawable.tab_message_select, getString(R.string.tab_message))
                .addItem(R.drawable.tab_me_select, getString(R.string.tab_me))
                .apply();
        mainBottomNavigation.setTabSelectedListener(new BottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelect(View tab, int position) {
                if (position == 0) {
                    noSlidingViewPager.setCurrentItem(0);
                }else if(position == 1){
                    noSlidingViewPager.setCurrentItem(1);
                }else if(position == 2){
                    noSlidingViewPager.setCurrentItem(2);
                }else{
                    noSlidingViewPager.setCurrentItem(3);
                }
            }

            @Override
            public void onTabUnSelect(View tab, int position) {

            }

            @Override
            public void onTabReSelected(View tab, int position) {

            }
        });
    }
    private List<Fragment> fragments() {
        fragmentList = new ArrayList<>();
        fragmentList.clear();
        fragmentList.add(HomeFragment.newInstance(bundle));
        fragmentList.add(ServiceFragment.newInstance(bundle));
        fragmentList.add(MessageFragment.newInstance(bundle));
        fragmentList.add(MeFragment.newInstance(bundle));
        return fragmentList;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click(); // 调用双击退出函数
        }
        return false;
    }

    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            ToastUtil.show(getApplicationContext(), "再按一次退出程序");
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            //将任务放置到后台
//            moveTaskToBack(false);
            finish();
        }
    }


}