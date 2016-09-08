package com.du.a36kr.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.du.a36kr.R;
import com.du.a36kr.ui.adapter.MainAdapter;
import com.du.a36kr.ui.fragment.DiscoveryFragment;
import com.du.a36kr.ui.fragment.EquityFragment;
import com.du.a36kr.ui.fragment.MessageFragment;
import com.du.a36kr.ui.fragment.MineFragment;
import com.du.a36kr.ui.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AbsBaseActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> fragments;
    private MainAdapter adapter;



    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        viewPager = byView(R.id.main_pager);
        tabLayout = byView(R.id.main_tab);

    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new NewsFragment());
        fragments.add(new EquityFragment());
        fragments.add(new DiscoveryFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MineFragment());
        //创建适配器绑定适配器
        adapter = new MainAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        //设在字体颜色
        tabLayout.setTabTextColors(Color.BLACK,Color.BLUE);
        //设置下标
        tabLayout.setSelectedTabIndicatorColor(Color.BLACK);

        //tablayout和Viewpager联动
        tabLayout.setupWithViewPager(viewPager);



        tabLayout.getTabAt(0).setIcon(R.drawable.news);
        tabLayout.getTabAt(1).setIcon(R.drawable.equity);
        tabLayout.getTabAt(2).setIcon(R.drawable.discovery);
        tabLayout.getTabAt(3).setIcon(R.drawable.message);
        tabLayout.getTabAt(4).setIcon(R.drawable.mine);

    }
}
