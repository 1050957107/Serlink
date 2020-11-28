package com.xinao.serlinkoperate.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;
import com.xinao.serlinkoperate.R;
import com.xinao.serlinkoperate.base.BaseActivity;
import com.xinao.serlinkoperate.base.IBaseView;
import com.xinao.serlinkoperate.base.Presenter;
import com.xinao.serlinkoperate.bean.UserSqlBean;
import com.xinao.serlinkoperate.login_register.LoginActivity;
import com.xinao.serlinkoperate.util.IHelper;
import com.xinao.serlinkoperate.util.IKey;
import com.xinao.serlinkoperate.util.InfoPrefs;
import com.xinao.serlinkoperate.util.IntentUtils;
import com.xinao.serlinkoperate.util.LoggerUtils;

import org.litepal.LitePal;

public class SplashActivity extends BaseActivity<Presenter> implements IBaseView {
    private static final String TAG = SplashActivity.class.getName();

    private UserSqlBean userSqlBean;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initPresenter() {
        InfoPrefs.init(IKey.KEY_XA_SPLASH, SplashActivity.this);
        mPresenter = new Presenter(this);
        mPresenter.init();
    }

    @Override
    protected void destory() {

    }

    @Override
    public void init() {
        SQLiteDatabase db = LitePal.getDatabase();
        try {
            UserSqlBean userSQLInfo = new UserSqlBean();
            userSQLInfo.setLogin_status(IHelper.LOGIN_DEFAULT);
            int isUpdate = userSQLInfo.updateAll();
            LoggerUtils.e(TAG, "isUpdate:" + isUpdate);
            userSqlBean = LitePal.findFirst(UserSqlBean.class);
        } catch (Exception e) {
            LoggerUtils.e(TAG, "set userSql data is error:" + e.toString());
        }

        XGPushManager.registerPush(this, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object data, int flag) {
                //token在设备卸载重装的时候有可能会变
                LoggerUtils.e("TPush", "注册成功，设备token为：" + data);
            }

            @Override
            public void onFail(Object data, int errCode, String msg) {
                LoggerUtils.e("TPush", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
            }
        });

        //首次启动 Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT 为 0，再次点击图标启动时就不为零了
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            LoggerUtils.e(TAG, "finish");
            finish();
            return;
        }
        //说明进入首页
        if (InfoPrefs.hasKey(IKey.KEY_SPLASH_HOME)) {
            goToMainActivity();
        } else {
            IntentUtils.getIntance().intent(this, LoginActivity.class, null);
        }
    }

    /**
     * 跳转到主页面
     */
    private void goToMainActivity() {
        IntentUtils.getIntance().intent(SplashActivity.this, MainActivity.class, bundle);
        finish();
    }
}