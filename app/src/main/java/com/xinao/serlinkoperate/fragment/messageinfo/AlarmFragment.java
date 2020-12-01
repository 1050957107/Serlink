package com.xinao.serlinkoperate.fragment.messageinfo;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseFragment;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.bean.AlarmBean;
import com.xinao.serlinkoperate.fragment.messageinfo.adapter.AlarmAdapter;
import com.xinao.serlinkoperate.util.SpacesItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @date：2020/11/28
 * @describe：
 * @author：DanDan
 */
public class AlarmFragment extends BaseFragment {
    @BindView(R.id.item1)
    TextView item1;
    @BindView(R.id.item2)
    TextView item2;
    @BindView(R.id.item3)
    ImageView item3;
    @BindView(R.id.item4)
    TextView item4;
    @BindView(R.id.item5)
    ImageView item5;
    @BindView(R.id.item6)
    TextView item6;
    @BindView(R.id.group1)
    RelativeLayout group1;
    @BindView(R.id.message_RecyclerView)
    RecyclerView messageRecyclerView;
    private AlarmAdapter alarmAdapter;
    private ArrayList<AlarmBean> alarmBeans;

    @Override
    protected void refreshData() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_alarm;
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        alarmAdapter = new AlarmAdapter();
        messageRecyclerView.setLayoutManager(linearLayoutManager);
        messageRecyclerView.addItemDecoration(new SpacesItemDecoration(30));
        messageRecyclerView.setAdapter(alarmAdapter);
        messageRecyclerView.addOnItemTouchListener(mScrollTouchListener);
        alarmBeans = new ArrayList<>();
        alarmBeans.add(getdata1());
        alarmBeans.add(getdata2());
        alarmBeans.add(getdata3());
        alarmBeans.add(getdata4());
        alarmBeans.add(getdata5());
        alarmBeans.add(getdata6());
        alarmBeans.add(getdata7());
        alarmAdapter.setAlarmBeans(alarmBeans);
    }

    public AlarmBean getdata1(){
        AlarmBean alarmBean = new AlarmBean();
        alarmBean.setTitle("A区配电室 (320)");
        alarmBean.setUnwinding("13未解除");
        alarmBean.setUnsure("5未确认");
        return alarmBean;
    }
    public AlarmBean getdata2(){
        AlarmBean alarmBean = new AlarmBean();
        alarmBean.setTitle("01中心配电室 (219)");
        alarmBean.setUnwinding("12未解除");
        return alarmBean;
    }
    public AlarmBean getdata3(){
        AlarmBean alarmBean = new AlarmBean();
        alarmBean.setTitle("科技园储能电站 (21)");
        alarmBean.setUnsure("5未确认");
        return alarmBean;
    }
    public AlarmBean getdata4(){
        AlarmBean alarmBean = new AlarmBean();
        alarmBean.setTitle("科技园储能电站 (21)");
        alarmBean.setUnwinding("3未解除");
        return alarmBean;
    }
    public AlarmBean getdata5(){
        AlarmBean alarmBean = new AlarmBean();
        alarmBean.setTitle("科技园储能电站 (21)");
        alarmBean.setUnwinding("13未解除");
        alarmBean.setUnsure("5未确认");
        return alarmBean;
    }
    public AlarmBean getdata6(){
        AlarmBean alarmBean = new AlarmBean();
        alarmBean.setTitle("科技园储能电站 (21)");
        alarmBean.setUnsure("5未确认");
        return alarmBean;
    }
    public AlarmBean getdata7(){
        AlarmBean alarmBean = new AlarmBean();
        alarmBean.setTitle("科技园储能电站 (21)");
        alarmBean.setUnsure("5未确认");
        return alarmBean;
    }
    RecyclerView.OnItemTouchListener mScrollTouchListener = new RecyclerView.OnItemTouchListener(){

        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            int action = e.getAction();
            switch(action){
                case MotionEvent.ACTION_MOVE:
                    rv.getParent().requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    };

}
