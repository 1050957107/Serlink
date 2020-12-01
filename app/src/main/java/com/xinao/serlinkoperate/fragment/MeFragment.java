package com.xinao.serlinkoperate.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.activity.IdeaActivity;
import com.xinao.serlinkoperate.activity.SafeActivity;
import com.xinao.serlinkoperate.activity.headinfo.HeadInfoActivity;
import com.xinao.serlinkoperate.activity.problem.ProblemActivity;
import com.xinao.serlinkoperate.activity.set.SettingsActivity;
import com.xinao.serlinkoperate.activity.ToolActivity;
import com.xinao.serlinkoperate.base.BaseFragment;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.login_register.LoginActivity;
import com.xinao.serlinkoperate.util.IntentUtils;
import com.xinao.serlinkoperate.wedgit.NoDoubleClickListener;
import com.xinao.serlinkoperate.wedgit.PhonePopWindow;

import butterknife.BindView;
import razerdp.basepopup.BasePopupWindow;

public class MeFragment extends BaseFragment<Presenter> implements IBaseView {

    @BindView(R.id.login)
    TextView login;
    @BindView(R.id.group3)
    LinearLayout group3;
    @BindView(R.id.group2)
    LinearLayout group2;
    @BindView(R.id.item_img)
    ImageView itemImg;
    @BindView(R.id.item_iright)
    ImageView itemIright;
    @BindView(R.id.tool)
    RelativeLayout tool;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.item_text)
    TextView itemText;
    @BindView(R.id.safe)
    RelativeLayout safe;
    @BindView(R.id.phone)
    ImageView phone;
    @BindView(R.id.group1)
    RelativeLayout group1;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.img5)
    ImageView img5;
    @BindView(R.id.img6)
    ImageView img6;
    @BindView(R.id.head)
    ImageView head;
    @BindView(R.id.problem)
    RelativeLayout problem;
    @BindView(R.id.idea)
    RelativeLayout idea;
    @BindView(R.id.me_set)
    RelativeLayout meset;
    private PhonePopWindow mPhonePopWindow;

    public static MeFragment newInstance(Bundle bundle) {
        MeFragment fragment = new MeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void refreshData() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_me;
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
        initListener();
    }

    private void initListener() {
        if (null == mPhonePopWindow) {
            mPhonePopWindow = new PhonePopWindow(getActivity());
            mPhonePopWindow.setPopupGravity(Gravity.BOTTOM);
            mPhonePopWindow.setBackground(Color.TRANSPARENT);
            mPhonePopWindow.setPopupGravityMode(BasePopupWindow.GravityMode.ALIGN_TO_ANCHOR_SIDE);
        }
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPhonePopWindow != null && !mPhonePopWindow.isShowing()) {
                    mPhonePopWindow.showPopupWindow();
                    mPhonePopWindow.setPopupGravity(Gravity.BOTTOM);
                }
            }
        });
        login.setOnClickListener(doubleClickListener);
        tool.setOnClickListener(doubleClickListener);
        safe.setOnClickListener(doubleClickListener);
        problem.setOnClickListener(doubleClickListener);
        idea.setOnClickListener(doubleClickListener);
        meset.setOnClickListener(doubleClickListener);
        head.setOnClickListener(doubleClickListener);
    }
    private NoDoubleClickListener doubleClickListener=new NoDoubleClickListener() {
        @Override
        protected void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.login:
                    IntentUtils.getIntance().intent(getActivity(), LoginActivity.class, null);
                    break;
                case R.id.tool:
                    IntentUtils.getIntance().intent(getActivity(), ToolActivity.class, null);
                    break;
                case R.id.safe:
                    IntentUtils.getIntance().intent(getActivity(), SafeActivity.class, null);
                    break;
                case R.id.head:
                    IntentUtils.getIntance().intent(getActivity(), HeadInfoActivity.class, null);
                    break;
                case R.id.problem:
                    IntentUtils.getIntance().intent(getActivity(), ProblemActivity.class, null);
                    break;
                case R.id.idea:
                    IntentUtils.getIntance().intent(getActivity(), IdeaActivity.class, null);
                    break;
                case R.id.me_set:
                    IntentUtils.getIntance().intent(getActivity(), SettingsActivity.class, null);
                    break;
            }
        }
    } ;
    /**
     * 拨打电话（跳转到拨号界面，用户手动点击拨打）
     *
     * @param phoneNum 电话号码
     */
    public void callPhone(String phoneNum) {
        //android6版本获取动态权限
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.CALL_PHONE};
            //验证是否许可权限
            for (String str : permissions) {
                if (getActivity().checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                    return;
                }
            }
        }
        //如果需要手动拨号将Intent.ACTION_CALL改为Intent.ACTION_DIAL（跳转到拨号界面，用户手动点击拨打）
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }
}
