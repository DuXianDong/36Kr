package com.du.a36kr.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.du.a36kr.R;
import com.du.a36kr.model.bean.NewsActivityBean;
import com.du.a36kr.model.net.VolleyInstance;
import com.du.a36kr.model.net.VolleyResult;
import com.du.a36kr.utils.ScreenSizeUtils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 新闻界面的详情
 */

public class NewsActivity extends AbsBaseActivity implements View.OnClickListener {
    private TextView nameTv;//作者
    private TextView introductionTv;//简介
    private TextView titleTv;//标题
    private TextView timeTv;//时间
    private ImageView imgIv;//作者头像
    private WebView webView;
    private ImageView returnIv;//退出
    private ImageView messageIv;//消息评论
    private ImageView favoriteIv;//收藏
    private ImageView shareIv;//分享
    private ImageView moreIv;//跟多功能
    private ScrollView scrollView;
    private LinearLayout menu;
    private GestureDetector gestureDetector;

    @Override
    protected int setLayout() {
        return R.layout.activity_news;
    }

    @Override
    protected void initViews() {
        nameTv = byView(R.id.activity_news_name_tv);
        introductionTv = byView(R.id.activity_news_introduction_tv);
        titleTv = byView(R.id.activity_news_title_tv);
        timeTv = byView(R.id.activity_news_time_tv);
        imgIv = byView(R.id.activity_news_img);
        webView = byView(R.id.activity_news_web);
        returnIv = byView(R.id.activity_news_return_iv);
        messageIv = byView(R.id.activity_news_message_iv);
        favoriteIv = byView(R.id.activity_news_favorite_iv);
        shareIv = byView(R.id.activity_news_share_iv);
        moreIv = byView(R.id.activity_news_more_iv);
        scrollView = byView(R.id.activity_news_scrollview);
        menu = byView(R.id.activity_news_menu);

    }

    @Override
    protected void initData() {
        gestureDetector();//手势监听
        returnIv.setOnClickListener(this);
        messageIv.setOnClickListener(this);
        favoriteIv.setOnClickListener(this);
        shareIv.setOnClickListener(this);
        moreIv.setOnClickListener(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String strUrl = bundle.getString("url");
        Log.d("ccc", strUrl);
        /**
         * 解析数据
         */
        VolleyInstance.getInstance().statRequest(strUrl, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Log.d("ccc", resultStr);
                Gson gson = new Gson();//gson解析
                NewsActivityBean bean = gson.fromJson(resultStr, NewsActivityBean.class);
                Picasso.with(NewsActivity.this).load(bean.getData().getUser().getAvatar()).resize(ScreenSizeUtils.getScreenSize(NewsActivity.this, ScreenSizeUtils.ScreenState.WIDTH) / 8, ScreenSizeUtils.getScreenSize(NewsActivity.this, ScreenSizeUtils.ScreenState.HEIGHT) / 12).into(imgIv);
                nameTv.setText(bean.getData().getUser().getName());
                titleTv.setText(bean.getData().getTitle());
                //格式化时间
                Long time = bean.getData().getPublishTime();
                SimpleDateFormat formats = new SimpleDateFormat(" HH:mm");
                Date dates = new Date(time);
                String formatTime = formats.format(dates);
                timeTv.setText(formatTime);
                //格式转换
                String str = bean.getData().getContent();
                //把HTML格式转换成textView的格式
                webView.loadData(str, "text/html; charset=UTF-8", null);
            }

            @Override
            public void failure() {

            }
        });

    }

    /**
     * 手势监听
     */
    private void gestureDetector() {
        Log.d("zzz", "走了吗");
        gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                Log.d("zzz", "ddd");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.d("zzz", "滑动时");
                if (distanceY > 10){
                    menu.setVisibility(View.GONE);
//                    finish();
                    return true;
                }else if (distanceY < 5){
                    menu.setVisibility(View.VISIBLE);
                }else {
                    menu.setVisibility(View.VISIBLE);
                }

                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return false;
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        gestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    private boolean isClick = false;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_news_return_iv:
                finish();
                break;
            case R.id.activity_news_message_iv:
                break;
            case R.id.activity_news_favorite_iv:
                //改变图片的状态
                if (!isClick){
                    favoriteIv.setImageResource(R.mipmap.news_toolbar_icon_favorite);
                    isClick =true;
                }else if (isClick){
                    favoriteIv.setImageResource(R.mipmap.news_toolbar_icon_favorite_blue);
                    isClick = false;
                }
                break;
            case R.id.activity_news_share_iv:
                break;
            case R.id.activity_news_more_iv:
                break;
        }

    }
}
