package com.example.nene.movie20.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nene.movie20.R;

/**
 * Created by nene on 2018/4/13.
 */

public class frag_exam extends Fragment{
    private static frag_exam instance = null;
    public static Fragment newInstance(){
        if (instance == null){
            instance = new frag_exam();
        }
        return instance;
    }
    public frag_exam(){

    }

}
