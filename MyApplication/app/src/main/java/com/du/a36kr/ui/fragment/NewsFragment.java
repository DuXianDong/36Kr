package com.du.a36kr.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.du.a36kr.R;
import com.du.a36kr.model.bean.NewsBean;
import com.du.a36kr.ui.adapter.NewsAdapter;
import com.du.a36kr.ui.app.MyApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 */
public class NewsFragment extends AbsBaseFragment {
    private ImageView titleMenuImg;
    private NewsAdapter adapter;
    private List<NewsBean> data;
    private ListView listview;

    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        titleMenuImg = byView(R.id.title_menu_img);
        listview = byView(R.id.news_list_view);

    }

    @Override
    protected void initData() {

        adapter = new NewsAdapter(MyApp.getContext());
        data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add(new NewsBean("标题","作者","时间","深度",R.mipmap.ic_launcher));

        }
        adapter.setData(data);
        listview.setAdapter(adapter);


        titleMenuImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
