package com.example.nene.movie20.data;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by nene on 2018/4/16.
 */

public class MySection extends SectionEntity<Video> {
    private boolean isMore;
    public MySection(boolean isHeader, String header, boolean isMore) {
        super(isHeader, header);
        this.isMore = isMore;
    }
    public MySection(Video t){
        super(t);
    }
    public boolean isMore(){
        return isMore;
    }
    public void setMore(boolean mroe){
        isMore = mroe;
    }
}
