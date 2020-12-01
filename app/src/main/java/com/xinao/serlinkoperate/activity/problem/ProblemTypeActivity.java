package com.xinao.serlinkoperate.activity.problem;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.util.IKey;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @date：2020/11/28
 * @describe：
 * @author：DanDan
 */
public class ProblemTypeActivity extends BaseActivity<Presenter> implements IBaseView {

    @BindView(R.id.iv_code_back)
    ImageView ivCodeBack;
    @BindView(R.id.problem_title)
    TextView problemTitle;
    @BindView(R.id.problem_context)
    TextView problemContext;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_problem_type_one;
    }

    @Override
    protected void initPresenter() {
        if (bundle != null) {
            bundle = getIntent().getExtras();
            String problem_title = bundle.getString(IKey.PROBLEM_TITLE);
            String problem_context = bundle.getString(IKey.PROBLEM_CONTEXT);
            problemTitle.setText(problem_title);
            problemContext.setText(problem_context);
        }
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
