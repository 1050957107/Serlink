package com.xinao.serlinkoperate.activity.problem.type;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @date：2020/11/28
 * @describe：
 * @author：DanDan
 */
public class ProblemTypeOneActivity extends BaseActivity<Presenter> implements IBaseView {
    @BindView(R.id.iv_code_back)
    ImageView ivCodeBack;
    @BindView(R.id.group1)
    LinearLayout group1;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.group2)
    TextView group2;
    @BindView(R.id.img2)
    ImageView img2;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_problem_type_one;
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


    @OnClick(R.id.iv_code_back)
    public void onViewClicked() {
        finish();
    }
}
