package com.example.nene.movie20.data;

/**
 * Created by nene on 2018/4/20.
 */

public class SubReview {
    private int img;
    private String title;
    private String review;
    public SubReview(int img, String title, String review){
        this.img = img;
        this.title = title;
        this.review = review;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

