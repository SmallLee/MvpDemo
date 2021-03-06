package com.example.mvcdemo.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.orhanobut.logger.Logger;

/**
 * Created by lixiaoniu on 2018/1/3.
 * Log工具类
 */

public class LogUtil {
    private static boolean mIsDebug = false;
    public static void initLog(Context context){
        Logger.init(context.getClass().getSimpleName());
        mIsDebug = context.getApplicationInfo() != null &&
                (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }

    public static void v(String msg,Object... obj){
        if (mIsDebug) {
            Logger.v(msg,obj);
        }
    }
    public static void w(String msg,Object... obj){
        if (mIsDebug) {
            Logger.w(msg,obj);
        }
    }
    public static void e(String msg,Object... obj){
        if (mIsDebug) {
            Logger.e(msg,obj);
        }
    }
    public static void d(String msg,Object... obj){
        if (mIsDebug) {
            Logger.d(msg,obj);
        }
    }
}
