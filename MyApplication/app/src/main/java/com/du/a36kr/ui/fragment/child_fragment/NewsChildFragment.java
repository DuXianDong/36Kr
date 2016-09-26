package com.du.a36kr.ui.fragment.child_fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.du.a36kr.R;
import com.du.a36kr.model.bean.NewsBean;
import com.du.a36kr.model.bean.RotateImageBean;
import com.du.a36kr.model.net.VolleyInstance;
import com.du.a36kr.model.net.VolleyResult;
import com.du.a36kr.ui.adapter.NewsChildAdapter;
import com.du.a36kr.ui.adapter.RotateImageAdapter;
import com.du.a36kr.ui.fragment.AbsBaseFragment;
import com.du.a36kr.utils.NetUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/19.
 */
public class NewsChildFragment extends AbsBaseFragment {
    private static final int TIME = 3000;//线程时间
    private ViewPager viewPager;//轮播图的ViewPager
    private LinearLayout layout;//小圆点
    private List<RotateImageBean> rotateBean;//轮播图的实体类
    private RotateImageAdapter rotateImageAdapter;//轮播图的适配器
    private Handler handler;
    private boolean isRotate = false;
    private Runnable rotateRunnable;//线程
    private NewsChildAdapter adapter;//listVIew的适配器
    private List<NewsBean.DataBean.DatasBean> data;//ListView的实体类
    private ListView listview;

    /**
     * Fragment的单利模式
     */
    public static NewsChildFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("Url", url);
        NewsChildFragment fragment = new NewsChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 绑定布局的方法
     */
    @Override
    protected int setLayout() {
        return R.layout.fragemnt_child_news;
    }

    /**
     * 初始化组件的方法
     */
    @Override
    protected void initViews() {
        listview = byView(R.id.news_child_list_view);

    }

    /**
     * 写逻辑代码的方法
     */
    @Override
    protected void initData() {
        Bundle bundle = getArguments();//从单利中获取传回来的数据
        String string = bundle.getString("Url");//在bundle中取出数据

        adapter = new NewsChildAdapter(context);
        /**
         * 请求网络数据
         */
        VolleyInstance.getInstance().statRequest(string, new VolleyResult() {
            /**
             * 网络请求成功
             */
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                //把请求下来的数据添加到实体类
                NewsBean bean = gson.fromJson(resultStr, NewsBean.class);
                data = bean.getData().getData();
                adapter.setData(data);

            }

            /**
             * 网络请求失败
             */
            @Override
            public void failure() {
                Toast.makeText(context, "网络请求失败", Toast.LENGTH_SHORT).show();

            }
        });

        listview.setAdapter(adapter);//把ListView的适配器放入ListView中
        /**
         * 判断网址是否相同,相同就加载轮播图
         */
        if (string.equals(NetUtils.NEWS_ALL)) {
            headRotateImageView();//加载头布局

        }

    }


    /**
     * 加载投布局
     */
    private void headRotateImageView() {
        /**
         * 加载Viewpager的行布局
         */
        View headView = LayoutInflater.from(context).inflate(R.layout.item_viewpager, null);
        viewPager = (ViewPager) headView.findViewById(R.id.item_rotate_pager);//初始化ViewPager组件
        layout = (LinearLayout) headView.findViewById(R.id.item_pager_linear);//初始化LinearLayout(小圆点的位置)

        buildDatas();//构造数据
        rotateImageAdapter = new RotateImageAdapter(context, rotateBean);//初始化轮播图的适配器
        viewPager.setAdapter(rotateImageAdapter);//把适配器放入ViewPager
        // ViewPager的页数为int最大值,设置当前页多一些,可以上来就向前滑动
        // 为了保证第一页始终为数据的第0条 取余要为0,因此设置数据集合大小的倍数
        viewPager.setCurrentItem(rotateBean.size() * 100);

        handler = new Handler();//初始化handler
        startRotate();//开始轮播
        addPoints();//添加轮播小点
        changePoints();//随着轮播改变小点
        listview.addHeaderView(headView);
    }

    /**
     * 随着轮播改变小点
     */
    private void changePoints() {
        //Viewpager的点击事件
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate) {
                    for (int i = 0; i < rotateBean.size(); i++) {

                        ImageView pointIv = (ImageView) layout.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.news_icon_point);
                    }
                    //设置当前位置小点为灰色
                    ImageView iv = (ImageView) layout.getChildAt(position % rotateBean.size());
                    iv.setImageResource(R.mipmap.lunpo);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 添加轮播切换小点
     */
    private void addPoints() {
        for (int i = 0; i < rotateBean.size(); i++) {
            ImageView pointIv = new ImageView(context);
            pointIv.setPadding(5, 5, 5, 5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
            pointIv.setLayoutParams(params);

            //设置第0页小点的为灰色
            if (i == 0) {
                pointIv.setImageResource(R.mipmap.lunpo);
            } else {
                pointIv.setImageResource(R.mipmap.news_icon_point);
            }
            layout.addView(pointIv);

        }

    }


    /**
     * 开始轮播
     */
    private void startRotate() {
        rotateRunnable = new Runnable() {
            @Override
            public void run() {
                int nowIndex = viewPager.getCurrentItem();
                viewPager.setCurrentItem(++nowIndex);
                if (isRotate) {
                    handler.postDelayed(rotateRunnable, TIME);
                }
            }
        };
        handler.postDelayed(rotateRunnable, TIME);
    }

    /**
     * 生命周期
     */
    @Override
    public void onResume() {
        super.onResume();
        isRotate = true;
    }

    /**
     * 生命周期
     */
    @Override
    public void onPause() {
        super.onPause();
        isRotate = false;
    }

    /**
     * 构造数据
     */
    private void buildDatas() {
        rotateBean = new ArrayList<>();
        rotateBean.add(new RotateImageBean(NetUtils.ROTATE_IMAGE_FUTURE));
        rotateBean.add(new RotateImageBean(NetUtils.ROTATE_IMAGE_ANISEED));
        rotateBean.add(new RotateImageBean(NetUtils.ROTATE_IMAGE_FUSION));
        rotateBean.add(new RotateImageBean(NetUtils.ROTATE_IMAGE_MECHANIC));


    }
}
