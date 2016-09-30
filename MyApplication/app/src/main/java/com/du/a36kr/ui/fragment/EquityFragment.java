package com.du.a36kr.ui.fragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.du.a36kr.R;
import com.du.a36kr.ui.activity.LoginActivity;
import com.du.a36kr.ui.activity.SearchActivit;
import com.du.a36kr.ui.adapter.EquityPagerAdapter;
import com.du.a36kr.ui.fragment.child_fragment.EquityChildFragment;
import com.du.a36kr.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 股权投资Fragment类
 */
public class EquityFragment extends AbsBaseFragment implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private EquityPagerAdapter adapter;
    private List<Fragment> data;
    private ImageView titleSearch;//搜索
    private ImageView titleGiftBox;//礼盒
    private AlertDialog alertDialog;//

    @Override
    protected int setLayout() {
        return R.layout.fragment_equity;
    }

    @Override
    protected void initViews() {
        tabLayout = byView(R.id.equity_tab);
        viewPager = byView(R.id.equity_pager);
        titleSearch = byView(R.id.item_equity_search);
        titleGiftBox = byView(R.id.item_equity_gift_box);

    }

    @Override
    protected void initData() {
        titleSearch.setOnClickListener(this);
        titleGiftBox.setOnClickListener(this);
        data = new ArrayList<>();
        //单利复用Fragment
        data.add(EquityChildFragment.newInstance(NetUtils.EQUITY_ALL));
        data.add(EquityChildFragment.newInstance(NetUtils.EQUITY_PROCEED));
        data.add(EquityChildFragment.newInstance(NetUtils.EQUITY_ACHIEVEMENT));
        data.add(EquityChildFragment.newInstance(NetUtils.EQUITY_SUCCESS));
        adapter = new EquityPagerAdapter(getChildFragmentManager(), data);
        //字体颜色
        tabLayout.setTabTextColors(Color.BLACK, Color.BLUE);
        //Tab下滑线的颜色
        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
        viewPager.setAdapter(adapter);
        //tab和ViewPager联动
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_equity_search:
                goTo(SearchActivit.class);
                break;
            case R.id.item_equity_gift_box:
                showViewDialog();
                break;
        }

    }

    private void showViewDialog() {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.item_equity_dialog,null);
        final Button dialogBtn = (Button) view.findViewById(R.id.item_equity_dialog_btn);
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(LoginActivity.class);
                alertDialog.dismiss();
            }
        });
        builder.setView(view);
        alertDialog = builder.create();//创建类create生成一个对话框
        alertDialog.show();//对话框调用show方法显示
    }
}
