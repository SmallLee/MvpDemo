package com.example.mvcdemo.model.net;

import com.example.mvcdemo.common.Constant;
import com.example.mvcdemo.model.net.interceptor.CacheInterceptor;
import com.example.mvcdemo.model.net.interceptor.LogginInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */

public class RetrofitWrapper {
    private Retrofit mRetrofit;
    private RetrofitWrapper() {
        //创建OkhttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(Constant.DEFAULT_TIME_OUT, TimeUnit.SECONDS);
//        //添加公共参数拦截器，此处不需要，所以注释掉
//        BasicParamsInterceptor basicParamsInterceptor = new BasicParamsInterceptor.Builder()
//                .addParam("","")
//                .build();
        //添加日志拦截器
        builder.addInterceptor(new LogginInterceptor())
                //添加缓存拦截器
        .addInterceptor(new CacheInterceptor());

    //======================================配置Retrofit
        mRetrofit = new Retrofit.Builder().client(builder.build()).
                baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    public static RetrofitWrapper getInstence() {
        return RetrofitHolder.instance;
    }
    //静态内部类实现单例
    private static class RetrofitHolder{
        private static RetrofitWrapper instance = new RetrofitWrapper();
    }
    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }
}
