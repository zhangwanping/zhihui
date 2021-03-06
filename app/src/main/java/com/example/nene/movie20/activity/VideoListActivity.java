package com.example.nene.movie20.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nene.movie20.R;
import com.example.nene.movie20.adapter.VideoListAdapter;
import com.example.nene.movie20.data.DataServer;
import com.example.nene.movie20.data.Video;

import java.util.List;

public class VideoListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    VideoListAdapter videoListAdapter;
    private List<Video> data = DataServer.getVideoListData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.video_list_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(VideoListActivity.this,2));

        videoListAdapter = new VideoListAdapter(R.layout.content_video, data);
        recyclerView.setAdapter(videoListAdapter);
    }

}
