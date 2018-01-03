package com.example.mvcdemo.presenter.impl;

import com.example.mvcdemo.base.BasePresenter;
import com.example.mvcdemo.model.net.ResponseObserver;
import com.example.mvcdemo.model.net.RetrofitWrapper;
import com.example.mvcdemo.model.net.service.MovieService;
import com.example.mvcdemo.model.pojo.MovieInfo;
import com.example.mvcdemo.presenter.IMoviePresenter;
import com.example.mvcdemo.view.IMovieView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by lixiaoniu on 2018/1/3.
 */

public class MoviePresentImpl extends BasePresenter<IMovieView> implements IMoviePresenter {
    private IMovieView mMovieView;

    public MoviePresentImpl(IMovieView movieView) {
        super.attachView(movieView);
        this.mMovieView = movieView;
    }

    @Override
    public void getMovieInfo() {
        MovieService movieService = RetrofitWrapper.getInstence().create(MovieService.class);
        mCompositeSubscription.add(movieService.getMovieInfo()
                .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        getMvpView().showLoading();
                    }
                }).doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        getMvpView().hideLoading();
                    }
                })
        .subscribe(new ResponseObserver<MovieInfo>(){
            @Override
            public void onError(Throwable e) {
                getMvpView().showError(e);
            }

            @Override
            public void onSuccess(MovieInfo movieInfo) {
                getMvpView().setMovieInfo(movieInfo);
            }
        }));
    }

}
