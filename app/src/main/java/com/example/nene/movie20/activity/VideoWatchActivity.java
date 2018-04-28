package com.example.nene.movie20.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.nene.movie20.R;
import com.example.nene.movie20.adapter.VideoReviewAdapter;
import com.example.nene.movie20.data.DataServer;
import com.example.nene.movie20.data.Review;
import com.jaeger.library.StatusBarUtil;

import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by nene on 2018/4/16.
 */

public class VideoWatchActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Review> reviewData = DataServer.getReviewData();
    private VideoReviewAdapter movieReviewAdapter;
    private EditText et_watch_input;

    String url = "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4";
    String title = "TEST";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_movie);
        StatusBarUtil.setColor(VideoWatchActivity.this, Color.parseColor("#000000"));
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        et_watch_input = findViewById(R.id.input);
        recyclerView = findViewById(R.id.review_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        movieReviewAdapter = new VideoReviewAdapter(R.layout.review_list, reviewData);
        recyclerView.setAdapter(movieReviewAdapter);

//        KeyboardDismisser.useWith(this);
        iniVideo();
        initText();
        initComment();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                hideKeyboard(v.getWindowToken());
                v.clearFocus();
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private void hideKeyboard(IBinder windowToken) {
        if (windowToken != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
        return false;
    }




    private void initComment() {
        movieReviewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(VideoWatchActivity.this, VideoReviewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initText() {
        TextView title = findViewById(R.id.movie_title);
        TextView content = findViewById(R.id.movie_content);
        title.setText("小龙虾的养殖");
        content.setText("这样养大的小龙虾更好吃哦！");

    }

    private void iniVideo() {
        JZVideoPlayerStandard jzVideoPlayerStandard = findViewById(R.id.video_player);
        jzVideoPlayerStandard.setUp(url, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, title);
    }

    @Override
    public void onBackPressed() {
        if(JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }


}

