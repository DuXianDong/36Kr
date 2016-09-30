package com.du.a36kr.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.du.a36kr.R;
import com.du.a36kr.ui.activity.ControlActivity;
import com.du.a36kr.ui.activity.SearchActivit;
import com.du.a36kr.ui.fragment.child_fragment.NewsChildFragment;
import com.du.a36kr.utils.NetUtils;

/**
 * Created by dllo on 16/9/8.
 */
public class NewsFragment extends AbsBaseFragment implements View.OnClickListener {
    private ImageView titleMenuImg;
    private ControlActivity controlActivity;
    private TextView titleTv;
    private ImageView titleSearchImg;//搜索





    public static NewsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        controlActivity = (ControlActivity) context;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        titleMenuImg = byView(R.id.title_menu_img);
        titleTv = byView(R.id.title_tv);
        titleSearchImg = byView(R.id.title_search_img);


    }

    @Override
    protected void initData() {

        titleMenuImg.setOnClickListener(this);
        titleSearchImg.setOnClickListener(this);
        /**
         * 默认显示的界面
         */
        getChildFragmentManager().beginTransaction().replace(R.id.news_frame, NewsChildFragment.newInstance(NetUtils.NEWS_ALL)).commit();

    }
    /**
     * 对外提供替换站位布局的方法
     */
    public void changeFragment(Fragment fragment){
        getChildFragmentManager().beginTransaction().replace(R.id.news_frame,fragment).commit();
    }

    /**
     * 对外提供一个替换TextView的方法
     */
    public void changeTextView(String text){
        titleTv.setText(text);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_menu_img:
        controlActivity.onToControlActivity(1);
                break;
            case R.id.title_search_img:
                goTo(SearchActivit.class);
                break;
        }
    }
}
