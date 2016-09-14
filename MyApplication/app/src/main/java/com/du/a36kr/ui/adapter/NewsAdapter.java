package com.du.a36kr.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.du.a36kr.R;
import com.du.a36kr.model.bean.NewsBean;
import com.du.a36kr.utils.ScreenSizeUtils;
import com.squareup.picasso.Picasso;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 新闻界面的ListView的Adapter类
 */
public class NewsAdapter extends BaseAdapter {
    private List<NewsBean.DataBean.DatasBean> data;
    private Context context;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<NewsBean.DataBean.DatasBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
            //屏幕适配
            int height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
            //通过布局设置参数修改高度
            ViewGroup.LayoutParams params = convertView.getLayoutParams();
            params.height = height / 7;
            convertView.setLayoutParams(params);

            holder = new NewsViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (NewsViewHolder) convertView.getTag();
        }
        if (holder != null) {
            NewsBean.DataBean.DatasBean bean = data.get(position);
            holder.titleTv.setText(bean.getTitle());
            holder.positionTv.setText(bean.getColumnName());
            holder.authorTv.setText(bean.getUser().getName());
            //在实体类中获取时间
            Long time = bean.getPublishTime();
            //格式化时间
            SimpleDateFormat formats = new SimpleDateFormat(" HH:mm");
            Date dates = new Date(time);
            String formatTime = formats.format(dates);



            holder.timeTv.setText(formatTime);
            Picasso.with(context).load(bean.getFeatureImg()).into(holder.imageView);

        }
        return convertView;
    }

    class NewsViewHolder {
        private TextView titleTv, authorTv, timeTv, positionTv;
        private ImageView imageView;

        public NewsViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.news_item_img);
            titleTv = (TextView) view.findViewById(R.id.news_item_title_tv);
            authorTv = (TextView) view.findViewById(R.id.news_item_author_tv);
            timeTv = (TextView) view.findViewById(R.id.news_item_time_tv);
            positionTv = (TextView) view.findViewById(R.id.new_item_position_tv);

        }
    }
}
