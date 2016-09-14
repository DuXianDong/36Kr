package com.du.a36kr.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.du.a36kr.R;
import com.du.a36kr.model.bean.NewsBean;
import com.du.a36kr.ui.adapter.NewsAdapter;
import com.du.a36kr.ui.app.MyApp;
import com.du.a36kr.utils.NetUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by dllo on 16/9/8.
 */
public class NewsFragment extends AbsBaseFragment {
    private ImageView titleMenuImg;
    private NewsAdapter adapter;
    private List<NewsBean.DataBean.DatasBean> data;
    private ListView listview;
    //定义请求队列
    private RequestQueue queue;


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
        //初始化请求队列
        queue = Volley.newRequestQueue(MyApp.getContext());
        //请求数据
        StringRequest request = new StringRequest(NetUtils.NEWS_ALL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("NewsFragment", response);
                Gson gson = new Gson();
                NewsBean bean = gson.fromJson(response,NewsBean.class);
                data =  bean.getData().getData();
                adapter.setData(data);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);



        listview.setAdapter(adapter);


        titleMenuImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
