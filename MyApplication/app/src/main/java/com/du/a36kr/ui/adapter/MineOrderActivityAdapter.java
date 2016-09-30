package com.du.a36kr.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/28.
 */
public class MineOrderActivityAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    private List<String> title;

    public MineOrderActivityAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data = data;
        title = new ArrayList<>();
        title.add("全部");
        title.add("代付款");
        title.add("已付款");
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
