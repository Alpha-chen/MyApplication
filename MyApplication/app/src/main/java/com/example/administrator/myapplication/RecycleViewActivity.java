package com.example.administrator.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.administrator.myapplication.adapter.RecycleAdapter;
import com.example.administrator.myapplication.node.RecyclerViewBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author xupangen
 */
public class RecycleViewActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.insert)
    Button insert;
    RecycleAdapter recycleAdapter;
    List<RecyclerViewBean> recycleViewBeans;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        ButterKnife.bind(this);
        init();
    }
    @OnClick({R.id.insert})
    public void onClick(){
        swipeRefreshLayout.setRefreshing(true);
        onRefresh();
    }
    private void init() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setColorSchemeColors(Color.BLACK,Color.BLUE,Color.CYAN,Color.DKGRAY,Color.GREEN);
        recycleViewBeans = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            RecyclerViewBean recycleViewBean = new RecyclerViewBean();
            recycleViewBean.setText(i + "");
            recycleViewBeans.add(recycleViewBean);
        }
        recycleAdapter = new RecycleAdapter(this, recycleViewBeans);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setSmoothScrollbarEnabled(true);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(recycleAdapter);
        swipeRefreshLayout.setRefreshing(false);
    }

    private  void delay(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(0 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    int j  = 1000;
    @Override
    public void onRefresh() {
        j++;
        RecyclerViewBean bean = new RecyclerViewBean();
        bean.setText(j+"");
        recycleViewBeans.add(0,bean);
        recycleAdapter.notifyItemInserted(10);
//        recycleAdapter.notifyItemChanged(0,null);
//        recycleAdapter.notifyDataSetChanged();
        Log.d("Tag",recycleViewBeans.size()+"");
        swipeRefreshLayout.setRefreshing(false);
        recycleView.smoothScrollToPosition(0);
    }
}
