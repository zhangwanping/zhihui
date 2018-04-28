package com.example.nene.movie20.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.nene.movie20.R;
import com.example.nene.movie20.data.Review;

import java.util.List;

/**
 * Created by nene on 2018/4/18.
 */

public class VideoReviewAdapter extends BaseQuickAdapter<Review, BaseViewHolder> {
    public VideoReviewAdapter(int layoutResId, List<Review> data){
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Review item) {
        helper.setImageResource(R.id.img1, item.getMainReview().getImg());
        helper.setText(R.id.name1, item.getMainReview().getTitle());
        helper.setText(R.id.content1,item.getMainReview().getReview());
        helper.setImageResource(R.id.img2, item.getSubReview1().getImg());
        helper.setText(R.id.name2, item.getSubReview1().getTitle());
        helper.setText(R.id.content2,item.getSubReview1().getReview());
        helper.setImageResource(R.id.img3, item.getSubReview2().getImg());
        helper.setText(R.id.name3, item.getSubReview2().getTitle());
        helper.setText(R.id.content3,item.getSubReview2().getReview());
    }
}

