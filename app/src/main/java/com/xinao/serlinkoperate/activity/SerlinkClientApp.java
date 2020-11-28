package com.xinao.serlinkoperate.activity;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.StrictMode;

import androidx.multidex.MultiDex;

import org.litepal.LitePal;


public class SerlinkClientApp extends Application {
    private static Context context;
    private static SerlinkClientApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
        context = getApplicationContext();
        instance = this;
        //android 7.0系统解决拍照的问题android.os.FileUriExposedException:file:///storage/emulated/0/...
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        //在XGPushManager.registerPush前，开启Debug日志数据（注意：上线时请设置为false）
//        XGPushConfig.enableDebug(this,true);

    }

    /**
     * 将字体设置为系统默认大小
     */
    @Override
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context getContext() {
        return context;
    }

    public static SerlinkClientApp getInstance() {
        return instance;
    }

}
