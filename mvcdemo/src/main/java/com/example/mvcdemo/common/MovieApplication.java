package com.example.mvcdemo.common;

import android.app.Application;

import com.example.mvcdemo.util.LogUtil;

/**
 * Created by lixiaoniu on 2018/1/3.
 */

public class MovieApplication  extends Application {
    private static MovieApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.initLog(this);
        mInstance = this;
    }
    public static MovieApplication getApplication() {
        return mInstance;
    }
}

/*
* Application中方法的执行顺序：
* 构造方法
* attachBaseContext
* onCreate
*
* */