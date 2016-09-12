package com.du.a36kr.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class EquityPagerAdapter extends FragmentPagerAdapter {
    private List<String> title;
    private List<Fragment> data;

    public EquityPagerAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data = data;
        title = new ArrayList<>();
        title.add("全部");
        title.add("募资中");
        title.add("募资完成");
        title.add("融资成功");
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
