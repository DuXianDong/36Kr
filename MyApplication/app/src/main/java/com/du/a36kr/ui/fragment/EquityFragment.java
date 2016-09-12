package com.du.a36kr.ui.fragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.du.a36kr.R;
import com.du.a36kr.ui.adapter.EquityPagerAdapter;
import com.du.a36kr.ui.fragment.equitychildfragment.AchievementFragment;
import com.du.a36kr.ui.fragment.equitychildfragment.AllFragment;
import com.du.a36kr.ui.fragment.equitychildfragment.ProceedFragment;
import com.du.a36kr.ui.fragment.equitychildfragment.SuccessFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 */
public class EquityFragment extends AbsBaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private EquityPagerAdapter adapter;
    private List<Fragment> data;
    @Override
    protected int setLayout() {
        return R.layout.fragment_equity;
    }

    @Override
    protected void initViews() {
        tabLayout = byView(R.id.equity_tab);
        viewPager = byView(R.id.equity_pager);

    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        data.add(new AllFragment());
        data.add(new AchievementFragment());
        data.add(new ProceedFragment());
        data.add(new SuccessFragment());
        adapter = new EquityPagerAdapter(getChildFragmentManager(),data);
        //字体颜色
        tabLayout.setTabTextColors(Color.BLACK,Color.BLUE);
        //Tab下滑线的颜色
        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
        viewPager.setAdapter(adapter);
        //tab和ViewPager联动
        tabLayout.setupWithViewPager(viewPager);


    }
}
