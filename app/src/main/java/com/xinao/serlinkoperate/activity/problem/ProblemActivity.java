package com.xinao.serlinkoperate.activity.problem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.activity.problem.type.ProblemTypeOneActivity;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProblemActivity extends BaseActivity<Presenter> implements IBaseView {

    @BindView(R.id.iv_code_back)
    ImageView ivCodeBack;
    @BindView(R.id.group1)
    LinearLayout group1;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.problem_type_one)
    RelativeLayout problemTypeOne;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.group3)
    RelativeLayout group3;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.group4)
    RelativeLayout group4;
    @BindView(R.id.img4)
    ImageView img4;
    @BindView(R.id.group5)
    RelativeLayout group5;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_problem;
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

    }


    @OnClick({R.id.problem_type_one,R.id.iv_code_back})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.problem_type_one:
                startActivity(new Intent(this, ProblemTypeOneActivity.class));
                break;
            case R.id.iv_code_back:
                finish();
                break;
        }

    }

}