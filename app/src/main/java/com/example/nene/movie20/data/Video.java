package com.example.nene.movie20.data;

/**
 * Created by nene on 2018/4/16.
 */

public class Video {
    private int img;
    private String name;
    private String number;

    public Video(int img, String name, String number){
        this.img = img;
        this.name = name;
        this.number = number;
    }

    public int getImg(){
        return img;
    }
    public void setImg(){
        this.img = img;
    }

    public String getName(){
        return name;
    }
    public void SetName(String name){
        this.name = name;
    }

    public String getNumber(){
        return number;
    }
    public void setNumber(){
        this.number = number;
    }
}
