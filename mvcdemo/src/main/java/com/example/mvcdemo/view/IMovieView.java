package com.example.mvcdemo.view;

import com.example.mvcdemo.base.MvpView;
import com.example.mvcdemo.model.pojo.MovieInfo;

/**
 * Created by lixiaoniu on 2018/1/2.
 *
 */

public interface IMovieView extends MvpView {
    void showLoading();
    void hideLoading();
    void showError(Throwable e);
    void setMovieInfo(MovieInfo movieInfo);
}
