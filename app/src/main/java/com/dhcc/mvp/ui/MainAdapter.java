package com.dhcc.mvp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Lituo on 2017/4/8 0008. 01:00 .
 * Mail：tony1994_vip@163.com
 */

public class MainAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragments;

    public MainAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
