package com.example.mvcdemo.view.adapter;

import android.content.Context;

import com.example.mvcdemo.R;
import com.example.mvcdemo.base.BasicAdapter;
import com.example.mvcdemo.base.BasicViewHolder;
import com.example.mvcdemo.common.Constant;
import com.example.mvcdemo.model.pojo.MovieBean;
import com.example.mvcdemo.util.LogUtil;

import java.util.List;

/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */

public class MovieAdapter extends BasicAdapter<MovieBean> {
    public MovieAdapter(Context context, List<MovieBean> movieBeanList, int itemLayoutId) {
        super(context, movieBeanList, itemLayoutId);
    }

    @Override
    protected void convert(BasicViewHolder viewHolder, MovieBean item) {
        LogUtil.e(Constant.IMAGE_URL+item.poster_path);
        viewHolder.setImageUri(R.id.iv_movie_item, Constant.IMAGE_URL+item.poster_path);
    }
}
