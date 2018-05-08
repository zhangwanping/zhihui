package com.example.nene.movie20.Interface;

import com.example.nene.movie20.models.VideoInf;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sam- on 2018/5/4.
 */

public interface GetVedioInterface {
    @GET("video/")
    Call<VideoInf> getId(@Query("page") String page,
                         @Query("page_size") String page_size,
                         @Query("order") String order);

}
