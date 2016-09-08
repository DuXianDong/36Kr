package com.du.a36kr.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 */
public class MainAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;
    private List<String> title;

    public MainAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        title = new ArrayList<>();
        title.add("新闻");
        title.add("股权投资");
        title.add("发现");
        title.add("消息");
        title.add("我的");
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
