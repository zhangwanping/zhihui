package com.example.nene.movie20.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.nene.movie20.R;
import com.example.nene.movie20.data.Video;

import java.util.List;

/**
 * Created by nene on 2018/4/28.
 */

public class VideoListAdapter extends BaseQuickAdapter<Video, BaseViewHolder> {

    public VideoListAdapter(int layoutResId, @Nullable List<Video> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Video item) {
//        helper.setImageResource(R.id.movie_header,R.drawable.video);
        helper.setImageResource(R.id.movie_cover, item.getImg());
        helper.setText(R.id.construction, item.getName());
        helper.setImageResource(R.id.eye, R.drawable.eye);
        helper.setText(R.id.number, item.getNumber());

    }
}
