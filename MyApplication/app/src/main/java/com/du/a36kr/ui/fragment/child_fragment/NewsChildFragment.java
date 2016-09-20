package com.du.a36kr.ui.fragment.child_fragment;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.du.a36kr.R;
import com.du.a36kr.model.bean.NewsBean;
import com.du.a36kr.model.net.VolleyInstance;
import com.du.a36kr.model.net.VolleyResult;
import com.du.a36kr.ui.adapter.NewsChildAdapter;
import com.du.a36kr.ui.fragment.AbsBaseFragment;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by dllo on 16/9/19.
 */
public class NewsChildFragment extends AbsBaseFragment{
    private NewsChildAdapter adapter;
    private List<NewsBean.DataBean.DatasBean> data;
    private ListView listview;

    public static NewsChildFragment newInstance(String url) {
        
        Bundle args = new Bundle();
        args.putString("Url", url);
        NewsChildFragment fragment = new NewsChildFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    
    @Override
    protected int setLayout() {
        return R.layout.fragemnt_child_news;
    }

    @Override
    protected void initViews() {
        listview = byView(R.id.news_child_list_view);

    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        String string = bundle.getString("Url");

        adapter = new NewsChildAdapter(context);
        /**
         * 请求数据
         */
        VolleyInstance.getInstance().statRequest(string, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                //把请求下来的数据添加到实体类
                NewsBean bean = gson.fromJson(resultStr,NewsBean.class);
                data =  bean.getData().getData();
                adapter.setData(data);

            }

            @Override
            public void failure() {
                Toast.makeText(context, "网络请求失败", Toast.LENGTH_SHORT).show();

            }
        });

        listview.setAdapter(adapter);
    }
}
