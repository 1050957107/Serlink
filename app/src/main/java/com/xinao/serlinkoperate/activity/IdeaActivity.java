package com.xinao.serlinkoperate.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.util.ToastUtil;
import com.xinao.serlinkoperate.wedgit.NoDoubleClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IdeaActivity extends BaseActivity<Presenter> implements IBaseView {


    @BindView(R.id.addimg)
    ImageView addimg;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.img4)
    ImageView img4;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.idea_feedback)
    EditText ideaFeedback;
    @BindView(R.id.idea_beedback_number)
    TextView ideaBeedbackNumber;
    @BindView(R.id.idea_problem_feedback)
    RelativeLayout ideaProblemFeedback;
    @BindView(R.id.dysfunction)
    Button dysfunction;
    @BindView(R.id.suggestion)
    RadioButton suggestion;
    @BindView(R.id.other_feedback)
    RadioButton otherFeedback;
    @BindView(R.id.group6)
    RelativeLayout group6;
    @BindView(R.id.group5)
    RelativeLayout group5;
    @BindView(R.id.iv_code_back)
    ImageView ivCodeBack;
    @BindView(R.id.cancle)
    TextView cancle;
    @BindView(R.id.group1)
    RelativeLayout group1;
    @BindView(R.id.group4)
    RelativeLayout group4;
    @BindView(R.id.group2)
    RelativeLayout group2;
    @BindView(R.id.group3)
    RelativeLayout group3;
    @BindView(R.id.tv)
    TextView tv;


    @Override
    protected int provideContentViewId() {
        return R.layout.activity_idea;
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
        ivCodeBack.setOnClickListener(doubleClickListener);
        cancle.setOnClickListener(doubleClickListener);
        ideaProblemFeedback.setOnClickListener(doubleClickListener);
        dysfunction.setOnClickListener(doubleClickListener);
        suggestion.setOnClickListener(doubleClickListener);
        otherFeedback.setOnClickListener(doubleClickListener);
        ideaFeedback.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int length = ideaFeedback.getText().toString().length();
                ideaBeedbackNumber.setText(length + "/500");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private NoDoubleClickListener doubleClickListener = new NoDoubleClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.iv_code_back:
                    finish();
                    break;
                case R.id.cancle:
                    finish();
                    break;
                case R.id.idea_problem_feedback:
                    openInputMethod(ideaFeedback);
                    break;
                case R.id.dysfunction:
                    ToastUtil.show(IdeaActivity.this, "dysfunction");
                    dysfunction.setBackgroundResource(R.drawable.ciclyle);
                    suggestion.setBackgroundResource(R.drawable.cicyle_white);
                    otherFeedback.setBackgroundResource(R.drawable.cicyle_white);
                    break;
                case R.id.suggestion:
                    ToastUtil.show(IdeaActivity.this, "suggestion");
                    dysfunction.setBackgroundResource(R.drawable.cicyle_white);
                    suggestion.setBackgroundResource(R.drawable.ciclyle);
                    otherFeedback.setBackgroundResource(R.drawable.cicyle_white);
                    break;
                case R.id.other_feedback:
                    ToastUtil.show(IdeaActivity.this, "other_feedback");
                    dysfunction.setBackgroundResource(R.drawable.cicyle_white);
                    suggestion.setBackgroundResource(R.drawable.cicyle_white);
                    otherFeedback.setBackgroundResource(R.drawable.ciclyle);
                    break;
            }
        }
    };
}