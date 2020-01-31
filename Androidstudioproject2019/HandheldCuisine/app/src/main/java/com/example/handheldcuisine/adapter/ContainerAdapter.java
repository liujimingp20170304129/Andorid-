package com.example.handheldcuisine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.handheldcuisine.R;

public class ContainerAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public  ContainerAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static  class ViewHolder {
        public ImageView imageView;
        public TextView textView,textViewTime,textViewContent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imgv);
            holder.textView = convertView.findViewById(R.id.tv_title1);
            holder.textViewTime = convertView.findViewById(R.id.tv_time);
            holder.textViewContent = convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        holder.textView.setText("这是标题");
        holder.textViewTime.setText("2019-10-29");
        holder.textViewContent.setText("这是内容");
        Glide.with(mContext).load("http://img.mp.itc.cn/upload/20170714/0d42a8b949a04eba84f375d800f2c11a_th.jpg").into(holder.imageView);
        return convertView;
    }
}
