package com.du.a36kr.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.du.a36kr.R;
import com.du.a36kr.ui.adapter.MainAdapter;
import com.du.a36kr.ui.fragment.DiscoveryFragment;
import com.du.a36kr.ui.fragment.EquityFragment;
import com.du.a36kr.ui.fragment.MessageFragment;
import com.du.a36kr.ui.fragment.MineFragment;
import com.du.a36kr.ui.fragment.NewsFragment;
import com.du.a36kr.ui.fragment.child_fragment.NewsChildFragment;
import com.du.a36kr.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AbsBaseActivity implements View.OnClickListener,ControlActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> fragments;
    private MainAdapter adapter;


    private NewsFragment newsFragment;
    //抽屉
    private DrawerLayout drawerLayout;
    private LinearLayout layout;
    private TextView allTv;//全部
    private TextView earlyTv;//早期
    private TextView rotateTv;//B轮后
    private TextView corporationTv;//大公司
    private TextView capitalTv;//资本
    private TextView depthTv;//深度
    private TextView researchTv;//研究

    @Override
    protected int setLayout() {
        newsFragment = NewsFragment.newInstance();
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {

        viewPager = byView(R.id.main_pager);
        tabLayout = byView(R.id.main_tab);
        drawerLayout = byView(R.id.Main_drawer_layout);
        layout = byView(R.id.linear_layout_drawer);
        /**
         * 抽屉
         */
        allTv = byView(R.id.drawer_all_tv);
        earlyTv = byView(R.id.drawer_early_tv);
        rotateTv = byView(R.id.drawer_rotate_tv);
        corporationTv = byView(R.id.drawer_corporation_tv);
        capitalTv = byView(R.id.drawer_capital_tv);
        depthTv = byView(R.id.drawer_depth_tv);
        researchTv = byView(R.id.drawer_research_tv);

    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(newsFragment);
        fragments.add(new EquityFragment());
        fragments.add(new DiscoveryFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MineFragment());
        //创建适配器绑定适配器
        adapter = new MainAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        //设在字体颜色
        tabLayout.setTabTextColors(Color.BLACK, Color.BLUE);
//        //设置下标
//        tabLayout.setSelectedTabIndicatorColor(Color.BLACK);

        //tablayout和Viewpager联动
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.news);
        tabLayout.getTabAt(1).setIcon(R.drawable.equity);
        tabLayout.getTabAt(2).setIcon(R.drawable.discovery);
        tabLayout.getTabAt(3).setIcon(R.drawable.message);
        tabLayout.getTabAt(4).setIcon(R.drawable.mine);
        /**
         * 抽屉里的TextView点击事件
         */
        allTv.setOnClickListener(this);
        earlyTv.setOnClickListener(this);
        rotateTv.setOnClickListener(this);
        corporationTv.setOnClickListener(this);
        capitalTv.setOnClickListener(this);
        depthTv.setOnClickListener(this);
        researchTv.setOnClickListener(this);
        //TabLayout的点击事件
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //选择的状态
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //判断tabLayout是否为0位置
                if (tab.getPosition() == 0){
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                }else {
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                }
            }
            //取消选择状态
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            //在次选择的状态
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.drawer_all_tv:
                newsFragment.changeFragment(NewsChildFragment.newInstance(NetUtils.NEWS_ALL));
                drawerLayout.closeDrawer(layout);//关闭抽屉
                break;
            case R.id.drawer_early_tv:
                newsFragment.changeFragment(NewsChildFragment.newInstance(NetUtils.NEWS_EARLY));
                newsFragment.changeTextView("早期项目");
                drawerLayout.closeDrawer(layout);
                break;
            case R.id.drawer_rotate_tv:
                newsFragment.changeFragment(NewsChildFragment.newInstance(NetUtils.NEWS_ROTATE));
                newsFragment.changeTextView("B轮后");
                drawerLayout.closeDrawer(layout);
                break;
            case R.id.drawer_corporation_tv:
                newsFragment.changeFragment(NewsChildFragment.newInstance(NetUtils.NEWS_COMPANY));
                newsFragment.changeTextView("大公司");
                drawerLayout.closeDrawer(layout);
                break;
            case R.id.drawer_capital_tv:
                newsFragment.changeFragment(NewsChildFragment.newInstance(NetUtils.NEWS_CAPITAL));
                newsFragment.changeTextView("资本");
                drawerLayout.closeDrawer(layout);
                break;
            case R.id.drawer_depth_tv:
                newsFragment.changeFragment(NewsChildFragment.newInstance(NetUtils.NewS_DEPTH));
                newsFragment.changeTextView("深度");
                drawerLayout.closeDrawer(layout);
                break;
            case R.id.drawer_research_tv:
                newsFragment.changeFragment(NewsChildFragment.newInstance(NetUtils.NEWS_RESEARCH));
                newsFragment.changeTextView("研究");
                drawerLayout.closeDrawer(layout);
                break;
        }

    }

    /**
     * 接口回调
     * 自定义的接口
     */

    @Override
    public void onToControlActivity(int position) {
        if (position == 1){
            drawerLayout.openDrawer(layout);

        }

    }
}
