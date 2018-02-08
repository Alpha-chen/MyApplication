package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.node.RecyclerViewBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author xupangen on 2018/1/31.
 */

public class RecycleAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context mContext;
    private List<RecyclerViewBean> recyclerViewBeans;

    public RecycleAdapter(Context mContext, List<RecyclerViewBean> recyclerViewBeans) {
        this.mContext = mContext;
        this.recyclerViewBeans = recyclerViewBeans;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycleview_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(recyclerViewBeans.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return null != recyclerViewBeans && !recyclerViewBeans.isEmpty() ? recyclerViewBeans.size() : 0;
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.textView3)
    public TextView textView;
    public MyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}