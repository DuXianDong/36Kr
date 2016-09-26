package com.du.a36kr.ui.fragment;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.du.a36kr.R;
import com.du.a36kr.model.bean.RotateImageBean;
import com.du.a36kr.ui.activity.AcademyActivity;
import com.du.a36kr.ui.activity.NeaTermActivity;
import com.du.a36kr.ui.activity.ProjectActivity;
import com.du.a36kr.ui.activity.Search_Investors_Activity;
import com.du.a36kr.ui.activity.StartupActivity;
import com.du.a36kr.ui.adapter.RotateImageAdapter;
import com.du.a36kr.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 发现界面的Fragment
 */
public class DiscoveryFragment extends AbsBaseFragment implements View.OnClickListener {
    private static final int TIME = 3000;
    private ViewPager viewPager;
    private LinearLayout layout;
    private List<RotateImageBean> data;
    private RotateImageAdapter adapter;//轮播图的
    private Handler handler;
    private boolean isRotate = false;
    private Runnable rotateRunnable;
    private LinearLayout startup;//创业公司
    private LinearLayout academy;//36氪研究院
    private LinearLayout buyerNotice;//近期活动
    private RelativeLayout discovery;//发现好项目
    private RelativeLayout search_investors;//寻找投资人
    private LinearLayout entrepreneurs;//我是创业者

    @Override
    protected int setLayout() {
        return R.layout.fragment_discovery;
    }

    @Override
    protected void initViews() {
        viewPager = byView(R.id.discovery_rotate_pager);
        layout = byView(R.id.discovery_rotate_layout);
        startup = byView(R.id.discovery_startup_layout);
        academy = byView(R.id.discovery_academy_layout);
        buyerNotice = byView(R.id.discovery_buyer_notice_layout);
        discovery = byView(R.id.discovery_project);
        search_investors = byView(R.id.discovery_search_investors);

    }

    @Override
    protected void initData() {
        startup.setOnClickListener(this);
        academy.setOnClickListener(this);
        buyerNotice.setOnClickListener(this);
        discovery.setOnClickListener(this);
        search_investors.setOnClickListener(this);

        buildData();
        adapter = new RotateImageAdapter(context, data);
        viewPager.setAdapter(adapter);
        //ViewPager的页数为int最大值,设置当前页多一些,可以上来就向前滑动
        //为了保证第一页始中为数据的第0条 取余要为0,因此设置数据集合大小的倍数
        viewPager.setCurrentItem(data.size() * 100);

        //开始轮播
        handler = new Handler();
        startRotate();
        //添加轮播小点
        addPoints();
        //随着轮播改变小点
        changePoints();


    }

    /**
     * 随着轮播改变小点
     */
    private void changePoints() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate) {
                    //把所有小点设置为白色
                    for (int i = 0; i < data.size(); i++) {
                        ImageView pointIV = (ImageView) layout.getChildAt(i);
                        pointIV.setImageResource(R.mipmap.news_icon_point);

                    }
                    //设置当前位置小点为灰色
                    ImageView iv = (ImageView) layout.getChildAt(position % data.size());
                    iv.setImageResource(R.mipmap.lunpo);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 添加轮播小点
     */
    private void addPoints() {
        //有多少张图加载多少个小点
        for (int i = 0; i < data.size(); i++) {
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

    @Override
    public void onResume() {
        super.onResume();
        isRotate = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isRotate = false;
    }

    /**
     * 构造数据
     */
    private void buildData() {
        data = new ArrayList<>();
        data.add(new RotateImageBean(NetUtils.ROTATE_IMAGE_FUTURE));
        data.add(new RotateImageBean(NetUtils.ROTATE_IMAGE_ANISEED));
        data.add(new RotateImageBean(NetUtils.ROTATE_IMAGE_FUSION));
        data.add(new RotateImageBean(NetUtils.ROTATE_IMAGE_MECHANIC));
    }

    /**
     * 创业公司,
     * 36氪研究院,
     * 近期活动
     * 发现好项目
     * 寻找投资人
     * 我是创业者
     * 我是专业的投资人
     * 的点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.discovery_startup_layout:
                goTo(StartupActivity.class);
                break;
            case R.id.discovery_academy_layout:
                goTo(AcademyActivity.class);
                break;
            case R.id.discovery_buyer_notice_layout:
                goTo(NeaTermActivity.class);
                break;
            case R.id.discovery_project:
                goTo(ProjectActivity.class);
                break;
            case R.id.discovery_search_investors:
                goTo(Search_Investors_Activity.class);
                break;
        }
    }


}
