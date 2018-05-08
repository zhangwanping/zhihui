package com.example.nene.movie20.utils;

import com.example.nene.movie20.Interface.GetVedioInterface;
import com.example.nene.movie20.models.Constant;
import com.example.nene.movie20.models.VideoInf;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sam- on 2018/5/3.
 */

public class GetHotVideoUtils {
    public static String Video;
    public static void getVideo() {
        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BaseUrl) // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        final GetVedioInterface getVedioInterface = retrofit.create(GetVedioInterface.class);

        //对 发送请求 进行封装
        final Call<VideoInf> call = getVedioInterface.getId("1", "1", "-click_num");

        //步骤6:发送网络请求(同步)
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<VideoInf> response = call.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
