package com.example.paofen.commt;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import com.lykj.aextreme.afinal.common.BaseApplication;

/**
 * Created by Administrator on 2016/11/25 0025.
 */

public class MyApplication extends BaseApplication {
    private static MyApplication app;
    public static MyApplication getApp() {
        return app;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
//        MobSDK.init(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
    }

    /**
     * 获取Application的Context
     **/
    public static Context getAppContext() {
        if (app == null)
            return null;
        return app.getApplicationContext();
    }



}
