package com.du.a36kr.ui.activity;

import android.widget.ListView;

import com.du.a36kr.R;
import com.du.a36kr.model.bean.StartupActivityBean;
import com.du.a36kr.ui.adapter.StartupActivityAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/23.
 * 创业公司 发现 Fragment 的创业公司的详情
 */
public class StartupActivity extends AbsBaseActivity{
    private ListView listView;
    private StartupActivityAdapter adapter;
    private List<StartupActivityBean> data;


    @Override
    protected int setLayout() {
        return R.layout.activity_startup;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.activity_startup_list_view);

    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add(new StartupActivityBean(R.mipmap.ic_launcher,"标题","类型","内容"));
        }
        adapter = new StartupActivityAdapter(data);
        listView.setAdapter(adapter);

    }
}
