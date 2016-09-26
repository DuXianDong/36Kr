package com.du.a36kr.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.du.a36kr.R;
import com.du.a36kr.model.bean.RotateImageBean;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 */
public class RotateImageAdapter extends PagerAdapter{
    private Context context;
    private List<RotateImageBean> data;
    private LayoutInflater inflater;

    /**
     * 构造方法
     */
    public RotateImageAdapter(Context context, List<RotateImageBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);//不知道什么作用
    }
    //构造方法
    public RotateImageAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    //set方法
    public void setData(List<RotateImageBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        //为了让ViewPager到最后一页不会像翻书一样回到第一页
        //设置页数为int最大值,这样向下滑动用于都是下一页
        return data == null ? 0 :Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    //添加业卡
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //position是int最大值所以这里可能是几百甚至上千,因此取余避免数组越界
        int newPosition = position % data.size();
        View view = inflater.inflate(R.layout.item_rotate_image,container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_rotate_img);
//        imageView.setImageResource(data.get(newPosition).getImgId());
        RotateImageBean bean = data.get(newPosition);
        Glide.with(context).load(bean.getImgUrl()).into(imageView);
//        Picasso.with(context).load(bean.getImgUrl()).into(imageView);
        container.addView(view);
        return view;
    }
    //删除也卡
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
