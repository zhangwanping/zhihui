package com.example.nene.movie20.data;

/**
 * Created by nene on 2018/4/20.
 */

public class Review {
    MainReview mainReview;
    SubReview subReview1;
    SubReview subReview2;

    public Review(MainReview mainReview, SubReview subReview1, SubReview subReview2){
        this.mainReview = mainReview;
        this.subReview1 = subReview1;
        this.subReview2 = subReview2;
    }

    public MainReview getMainReview() {
        return mainReview;
    }

    public void setMainReview(MainReview mainReview) {
        this.mainReview = mainReview;
    }

    public SubReview getSubReview1() {
        return subReview1;
    }

    public void setSubReview1(SubReview subReview1) {
        this.subReview1 = subReview1;
    }

    public SubReview getSubReview2() {
        return subReview2;
    }

    public void setSubReview2(SubReview subReview2) {
        this.subReview2 = subReview2;
    }
}
