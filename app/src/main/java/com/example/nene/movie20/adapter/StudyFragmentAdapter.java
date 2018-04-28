package com.example.nene.movie20.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nene on 2018/4/13.
 */

public class StudyFragmentAdapter extends FragmentPagerAdapter{
    private final List<Fragment> mFragment = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    public StudyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    public void addFragment(Fragment fragment, String fragmentTitle){
        mFragment.add(fragment);
        mFragmentTitles.add(fragmentTitle);
    }
    public CharSequence getPageTitle(int position){
        return mFragmentTitles.get(position);
    }

}
