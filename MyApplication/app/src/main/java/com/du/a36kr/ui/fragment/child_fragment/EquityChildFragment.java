package com.du.a36kr.ui.fragment.child_fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.du.a36kr.R;
import com.du.a36kr.model.bean.EquityChildFragmentBean;
import com.du.a36kr.model.net.VolleyInstance;
import com.du.a36kr.model.net.VolleyResult;
import com.du.a36kr.ui.adapter.EquityChildFragmentAdapter;
import com.du.a36kr.ui.fragment.AbsBaseFragment;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by dllo on 16/9/9.
 * EquityFragment 的子Fragment
 */
public class EquityChildFragment extends AbsBaseFragment  {
    private ListView listview;
    private List<EquityChildFragmentBean.DataBean.DatasBean> datasBeen;
    private EquityChildFragmentAdapter adapter;


    @Override
    protected int setLayout() {
        return R.layout.fragment_child_equity;
    }

    //单利的方法 直接写newInstance 下面的方法都会出来
    public static EquityChildFragment newInstance(String url) {

        Bundle args = new Bundle();

        args.putString("Url", url);
        EquityChildFragment fragment = new EquityChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initViews() {
        listview = byView(R.id.equity_child_list_View);

    }

    @Override
    protected void initData() {
        //在bundle中获取数据
        Bundle bundle = getArguments();
        String string = bundle.getString("Url");

        adapter = new EquityChildFragmentAdapter(context);
        //网络请求
        VolleyInstance.getInstance().statRequest(string, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Log.d("nnnn", resultStr);
                Gson gson = new Gson();
                EquityChildFragmentBean bean = gson.fromJson(resultStr, EquityChildFragmentBean.class);
                datasBeen = bean.getData().getData();
                adapter.setDatasBeen(datasBeen);
                listview.setAdapter(adapter);

            }

            @Override
            public void failure() {
                Toast.makeText(context, "数据请求失败", Toast.LENGTH_SHORT).show();

            }
        });


    }



}
