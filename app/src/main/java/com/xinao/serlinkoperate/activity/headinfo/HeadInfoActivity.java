package com.xinao.serlinkoperate.activity.headinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.wedgit.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HeadInfoActivity extends BaseActivity<Presenter> implements IBaseView {


    @BindView(R.id.headinfo_name)
    RelativeLayout headinfoName;
    @BindView(R.id.iv_code_back)
    ImageView ivCodeBack;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.iv_arrow)
    ImageView ivArrow;
    @BindView(R.id.iv_arrow_one)
    ImageView ivArrowOne;
    @BindView(R.id.rl3)
    RelativeLayout rl3;
    @BindView(R.id.iv_arrow_two)
    ImageView ivArrowTwo;
    @BindView(R.id.rl4)
    RelativeLayout rl4;
    @BindView(R.id.line1)
    ImageView line1;
    @BindView(R.id.ll_l)
    LinearLayout llL;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.line2)
    ImageView line2;
    @BindView(R.id.line4)
    ImageView line4;
    @BindView(R.id.iv_arrow_three)
    ImageView ivArrowThree;
    @BindView(R.id.rl5)
    RelativeLayout rl5;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_head_info;
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
        headinfoName.setOnClickListener(doubleClickListener);
        ivCodeBack.setOnClickListener(doubleClickListener);

    }
    private NoDoubleClickListener doubleClickListener=new NoDoubleClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.headinfo_name:
                    startActivity(new Intent(HeadInfoActivity.this, ChangetNameActivity.class));
                    break;
                case R.id.iv_code_back:
                    finish();
                    break;
            }
        }
    };

}