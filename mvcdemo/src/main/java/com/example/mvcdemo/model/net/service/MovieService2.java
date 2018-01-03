package com.example.mvcdemo.model.net.service;


import com.example.mvcdemo.common.Constant;
import com.example.mvcdemo.model.pojo.MovieInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */

public interface MovieService2 {
    @GET(Constant.POP_LIST+ Constant.API_KEY)//拼接在BASE_URL后面的路径
    Observable<MovieInfo> getMovieInfo();
}
