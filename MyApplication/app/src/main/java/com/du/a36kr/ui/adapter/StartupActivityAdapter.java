package com.du.a36kr.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.du.a36kr.R;
import com.du.a36kr.model.bean.StartupActivityBean;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 * 创业公司的适配器
 */
public class StartupActivityAdapter extends BaseAdapter {
    private List<StartupActivityBean> data;

    public StartupActivityAdapter(List<StartupActivityBean> data) {
        this.data = data;
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
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity_startup,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        StartupActivityBean bean = data.get(position);
        holder.titleTv.setText(bean.getTitle());
        holder.typeTv.setText(bean.getType());
        holder.contentTv.setText(bean.getContent());
//        Picasso.with(parent.getContext()).load().into(holder.imageView);
        return convertView;
    }
    class ViewHolder {
        private ImageView imageView;
        private TextView titleTv;
        private TextView typeTv;
        private TextView contentTv;
        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.item_activity_startup_iv);
            titleTv = (TextView) view.findViewById(R.id.item_activity_startup_title_tv);
            typeTv = (TextView) view.findViewById(R.id.item_activity_startup_type_tv);
            contentTv = (TextView) view.findViewById(R.id.item_activity_startup_content_tv);
        }
    }

}
