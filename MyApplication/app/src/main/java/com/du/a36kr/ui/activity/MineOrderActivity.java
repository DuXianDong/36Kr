package com.du.a36kr.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.du.a36kr.R;
import com.du.a36kr.ui.adapter.MineOrderActivityAdapter;
import com.du.a36kr.ui.fragment.child_fragment.MineChildFragment;

import java.util.ArrayList;
import java.util.List;

public class MineOrderActivity extends AbsBaseActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> data;
    private MineOrderActivityAdapter adapter;
    private ImageView titleIv;


    @Override
    protected int setLayout() {
        return R.layout.activity_mine_order;

    }

    @Override
    protected void initViews() {
        tabLayout = byView(R.id.activity_mine_tab);
        viewPager = byView(R.id.activity_mine_pager);
        titleIv = byView(R.id.item_mine_title_iv);

    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        data.add(MineChildFragment.newInstance());
        data.add(MineChildFragment.newInstance());
        data.add(MineChildFragment.newInstance());
        adapter = new MineOrderActivityAdapter(getSupportFragmentManager(),data);
        viewPager.setAdapter(adapter);
        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
        tabLayout.setTabTextColors(Color.BLACK,Color.BLUE);
        tabLayout.setupWithViewPager(viewPager);
        titleIv.setOnClickListener(this );

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
