package com.xinao.serlinkoperate.activity.problem;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.util.IKey;
import com.xinao.serlinkoperate.util.IntentUtils;
import com.xinao.serlinkoperate.wedgit.NoDoubleClickListener;

import butterknife.BindView;

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
    @BindView(R.id.problem_type_two)
    RelativeLayout problemTypeTwo;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.problem_type_three)
    RelativeLayout problemTypeThree;
    @BindView(R.id.img4)
    ImageView img4;
    @BindView(R.id.problem_type_four)
    RelativeLayout problemTypeFour;

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
        problemTypeOne.setOnClickListener(doubleClickListener);
        problemTypeTwo.setOnClickListener(doubleClickListener);
        problemTypeThree.setOnClickListener(doubleClickListener);
        problemTypeFour.setOnClickListener(doubleClickListener);
        ivCodeBack.setOnClickListener(doubleClickListener);
    }
    private NoDoubleClickListener doubleClickListener=new NoDoubleClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            switch (v.getId()) {
                case R.id.problem_type_one:
                    bundle.putString(IKey.PROBLEM_TITLE, "值守站每次巡检时如何进行？");
                    bundle.putString(IKey.PROBLEM_CONTEXT,"值守站巡检时使用APP 打开对应电站点击右上角按钮，进入巡检");
                    IntentUtils.getIntance().intent(ProblemActivity.this, ProblemTypeActivity.class, bundle);
                    break;
                case R.id.problem_type_two:
                    bundle.putString(IKey.PROBLEM_TITLE, "巡检计划无法编辑？");
                    bundle.putString(IKey.PROBLEM_CONTEXT,"巡检计划编辑时要首先选择执行团队才可以编辑该团队巡检计划");
                    IntentUtils.getIntance().intent(ProblemActivity.this, ProblemTypeActivity.class, bundle);
                    break;
                case R.id.problem_type_three:
                    bundle.putString(IKey.PROBLEM_TITLE, "值班设置无法生成值班表？");
                    bundle.putString(IKey.PROBLEM_CONTEXT,"排班设置需要针对没个值守站排班，所以没有值守站的团队无法值班");
                    IntentUtils.getIntance().intent(ProblemActivity.this, ProblemTypeActivity.class, bundle);
                    break;
                case R.id.problem_type_four:
                    bundle.putString(IKey.PROBLEM_TITLE, " 遥测越限告警信息频繁？");
                    bundle.putString(IKey.PROBLEM_CONTEXT,"频繁遥测越限：\n" +
                            "\n" +
                            "1、遥测越限报警代表设备故障或运行方式不合理，\n" +
                            "\n" +
                            "需检查设备或改变运行方式，防止发生事故；\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "2、限制设置不合理，配合实际运行状态，设置合理限值，保证遥测越限报警时可采取相应干预。");
                    IntentUtils.getIntance().intent(ProblemActivity.this, ProblemTypeActivity.class, bundle);
                    break;
                case R.id.iv_code_back:
                    finish();
                    break;
            }
        }
    };
}