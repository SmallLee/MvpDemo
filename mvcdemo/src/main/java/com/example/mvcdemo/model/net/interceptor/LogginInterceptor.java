package com.example.mvcdemo.model.net.interceptor;

import com.example.mvcdemo.util.LogUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lixiaoniu on 2018/1/3.
 */

public class LogginInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();
        LogUtil.d(String.format("Sending Request %s on %s%n%s",request.url(),chain.connection(), request.headers()));
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        LogUtil.d(String.format("Receive Response from %s in %.1f%n%s",
                response.request().url(),(t2 - t1)/1e6d,response.headers()));
        return response;
    }
}
