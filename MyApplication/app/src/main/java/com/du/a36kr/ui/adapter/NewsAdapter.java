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

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 新闻界面的ListView的Adapter类
 */
public class NewsAdapter extends BaseAdapter {
    private List<NewsBean> data;
    private Context context;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<NewsBean> data) {
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
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
            holder = new NewsViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (NewsViewHolder) convertView.getTag();
        }
        NewsBean bean = data.get(position);
        holder.imageView.setImageResource(bean.getImg());
        holder.titleTv.setText(bean.getTitleTv());
        holder.authorTv.setText(bean.getAuthorTv());
        holder.timeTv.setText(bean.getTimeTv());
        holder.positionTv.setText(bean.getPositionTv());
        return convertView;
    }
    class NewsViewHolder{
        private TextView titleTv,authorTv,timeTv,positionTv;
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
