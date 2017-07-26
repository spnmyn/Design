package com.example.administrator.design.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.design.R;

import java.util.List;

/**
 * Created on 2017/7/24
 * Author 郑少鹏
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<String> data;

    /*
    * 构造方法
    * */
    public MyAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    /**
     * 获取item布局
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.item_tv_show.setText(data.get(position));
    }

    /**
     * 获取数据的条数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // 声明控件
        TextView item_tv_show;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_tv_show = itemView.findViewById(R.id.item_tv_show);
        }
    }
}
