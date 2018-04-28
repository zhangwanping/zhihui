package com.example.nene.movie20.data;

import com.example.nene.movie20.R;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nene on 2018/4/16.
 */

public class DataServer {
    private DataServer(){
    }

    public static List<Review> getReviewData() {
        List<Review> list = new ArrayList<>();
        list.add(new Review(new MainReview(R.drawable.admin,"小龙虾","小龙虾天下无敌！"), new SubReview(R.drawable.eye,"大闸蟹","瞎说！大闸蟹才是！"),
                new SubReview(R.drawable.forum,"田螺","不可能比得上田螺！")));
        list.add(new Review(new MainReview(R.drawable.admin,"小龙虾","小龙虾天下无敌！"), new SubReview(R.drawable.eye,"大闸蟹","瞎说！大闸蟹才是！"),
                new SubReview(R.drawable.forum,"田螺","不可能比得上田螺！")));

        return list;
    }

    public static List<Video> getVideoListData(){
        List<Video> list = new ArrayList<>();
        list.add(new Video(R.drawable.m2,"小龙虾的养殖","666"));
        list.add(new Video(R.drawable.m2,"螃蟹的养殖","6666"));
        list.add(new Video(R.drawable.m1,"菱角的养殖","66666"));
        list.add(new Video(R.drawable.m2,"水稻的养殖","666666"));
        return list;
    }


    public static List<MySection> getVideoData(){
        List<MySection> list = new ArrayList<>();
        list.add(new MySection(true,"最新视频",true));
        list.add(new MySection(new Video(R.drawable.m1, "1","11")));
        list.add(new MySection(new Video(R.drawable.m1, "2","22")));
        list.add(new MySection(new Video(R.drawable.m2, "3","33")));
        list.add(new MySection(new Video(R.drawable.m2, "4","44")));
        list.add(new MySection(true,"最热视频",true));
        list.add(new MySection(new Video(R.drawable.m2, "5","12")));
        list.add(new MySection(new Video(R.drawable.m1, "6","13")));
        list.add(new MySection(new Video(R.drawable.m1, "7","14")));
        list.add(new MySection(new Video(R.drawable.m2, "8","15")));

        return list;
    }
}