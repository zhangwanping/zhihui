package com.example.nene.movie20.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.nene.movie20.R;
import com.example.nene.movie20.activity.VideoSearchActivity;
import com.example.nene.movie20.activity.VideoWatchActivity;
import com.example.nene.movie20.adapter.VideoSectionAdapter;
import com.example.nene.movie20.data.DataServer;
import com.example.nene.movie20.data.MySection;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by nene on 2018/4/13.
 */

public class frag_movie extends Fragment{
    private static frag_movie instance = null;
    private RecyclerView recyclerView;
    private ViewPager viewPager;
    private List<MySection> mData;

    public static Fragment newInstance() {
        if (instance == null){
            instance = new frag_movie();
        }
        return instance;
    }
    public frag_movie(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_movie, container, false);

        SearchView searchView = view.findViewById(R.id.movie_search);

        recyclerView = view.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mData = DataServer.getVideoData();

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VideoSearchActivity.class);
                Log.v(TAG, "search");
                startActivity(intent);
            }
        });

        final VideoSectionAdapter movieSectionAdapter = new VideoSectionAdapter(R.layout.content_video, R.layout.def_movie_section_head, mData);

        movieSectionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), VideoWatchActivity.class);
                startActivity(intent);

//                MySection section = mData.get(position);
//                if (section.isHeader)
//                    Toast.makeText(getActivity(), section.header, Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(getActivity(), section.t.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        movieSectionAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(), "More", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(movieSectionAdapter);

        return view;
    }
}
