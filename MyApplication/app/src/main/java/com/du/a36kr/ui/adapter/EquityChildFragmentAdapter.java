package com.du.a36kr.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.du.a36kr.R;
import com.du.a36kr.model.bean.EquityChildFragmentBean;
import com.du.a36kr.utils.ScreenSizeUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.du.a36kr.R.id;
import static com.du.a36kr.R.layout;

/**
 * Created by dllo on 16/9/14.
 * Equity 的子Fragment的适配器
 */
public class EquityChildFragmentAdapter extends BaseAdapter {
    private List<EquityChildFragmentBean.DataBean.DatasBean> datasBeen;
    private Context context;

    //context的构造方法
    public EquityChildFragmentAdapter(Context context) {
        this.context = context;
    }

    public void setDatasBeen(List<EquityChildFragmentBean.DataBean.DatasBean> datasBeen) {
        this.datasBeen = datasBeen;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datasBeen != null ? datasBeen.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datasBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EquityChildViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout.item_equity, parent, false);
            //屏幕适配(获取屏幕的高度)
//            int height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
//            //通过布局设置宽高
//            ViewGroup.LayoutParams params = convertView.getLayoutParams();
//            //重新设置高度
//            params.height = height * 2  ;


            //初始化缓存类
            holder = new EquityChildViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (EquityChildViewHolder) convertView.getTag();
        }
        if (holder != null) {
            //在实体类中获取数据
            EquityChildFragmentBean.DataBean.DatasBean bean = datasBeen.get(position);
            Log.d("xxx", "bean:" + bean.getCompany_name());
            holder.titleTv.setText(bean.getCompany_name());
            holder.contentTv.setText(bean.getCompany_brief());
            holder.founderTv.setText(bean.getCf_advantage().get(0).getAdname());
            holder.dataTv.setText(bean.getCf_advantage().get(1).getAdname());
            holder.nextTitleTv.setText(bean.getCf_advantage().get(0).getAdcontent());
            holder.nextContentTv.setText(bean.getCf_advantage().get(1).getAdcontent());
            holder.companyTv.setText(bean.getLead_name());
            holder.statusTv.setText(bean.getFundStatus().getDesc());
            int num = (int) (bean.getRate() * 100);//把长整形变为整形
            holder.fundraisingTv.setText(num + "%");
            holder.seekbar.setProgress(num);//设置seekbar进度条的位置
            Log.d("EquityChildFragmentAdap", bean.getFundStatus().getDesc());
            //毕加索图片解析
            Picasso.with(context).load(bean.getFile_list_img()).resize(ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.WIDTH), ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT) / 4).into(holder.bigIv);
            Picasso.with(context).load(bean.getCompany_logo()).resize(ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.WIDTH) / 7, ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT) / 7).into(holder.smallIv);
            //判断替换
            /*************************************///还没解决遗留问题
            String str = bean.getFundStatus().getDesc();
            if (str.equals("募资中")){
                    holder.purchaseTv.setText("认购");
                    holder.purchaseTv.setBackgroundColor(Color.parseColor("#f96c30"));

            }
            if (num > 100){
                Drawable draw = context.getResources().getDrawable(R.drawable.seekbar_color);
                draw.setBounds(holder.seekbar.getProgressDrawable().getBounds());
                holder.seekbar.setProgressDrawable(draw);
            }else if (num <= 100){
                Drawable draw = context.getResources().getDrawable(R.drawable.seekbar_define_color_style);
                draw.setBounds(holder.seekbar.getProgressDrawable().getBounds());
                holder.seekbar.setProgressDrawable(draw);
            }

        }

        return convertView;
    }

    class EquityChildViewHolder implements View.OnClickListener {
        private ImageView smallIv, bigIv;
        //leadTv领投方 founderTv创始人 dataTv孵化器 companyTv公司, StatusTv状态  fundraisingTv已募资的多少
        private TextView titleTv, contentTv, leadTv, founderTv, dataTv, companyTv, statusTv, fundraisingTv;
        private TextView nextTitleTv, nextContentTv;
        private TextView concernTv;//关注
        private TextView purchaseTv;//去看看认购
        private SeekBar seekbar;

        public EquityChildViewHolder(View view) {
            smallIv = (ImageView) view.findViewById(id.equity_item_small_img);
            bigIv = (ImageView) view.findViewById(id.equity_item_big_img);
            titleTv = (TextView) view.findViewById(id.equity_item_title_tv);
            contentTv = (TextView) view.findViewById(id.equity_item_content_tv);
            leadTv = (TextView) view.findViewById(id.equity_item_lead_tv);
            founderTv = (TextView) view.findViewById(id.equity_item_founder_tv);
            dataTv = (TextView) view.findViewById(id.equity_item_data_tv);
            companyTv = (TextView) view.findViewById(id.equity_item_company_tv);
            statusTv = (TextView) view.findViewById(id.equity_item_status_tv);
            fundraisingTv = (TextView) view.findViewById(id.equity_item_fundraising_tv);
            //adContent
            nextTitleTv = (TextView) view.findViewById(id.equity_item_next_title_tv);
            //adcontent
            nextContentTv = (TextView) view.findViewById(id.equity_item_next_content);

            seekbar = (SeekBar) view.findViewById(id.equity_item_seekbar);
            concernTv = (TextView) view.findViewById(id.equity_item_concern_tv);
            purchaseTv = (TextView) view.findViewById(id.equity_item_purchase_Tv);
            /**
             * 点击事件
             */
            concernTv.setOnClickListener(this);
            purchaseTv.setOnClickListener(this);

        }

        private boolean is = true;

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case id.equity_item_concern_tv:
                    if (is == true) {
                        concernTv.setText("已关注");
                        is = false;
                    } else if (is == false) {

                        concernTv.setText("关注");
                        is = true;
                    }
                    break;
                case id.equity_item_purchase_Tv:
                    break;
            }
        }
    }

}
