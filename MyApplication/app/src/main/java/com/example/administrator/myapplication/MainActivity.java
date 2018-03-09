package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 入口
 *
 * @author xupangen
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_socket)
    Button button;
    @BindView(R.id.btn_network)
    Button button2;
    @BindView(R.id.recycleView)
    Button recycleView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_socket, R.id.btn_network, R.id.recycleView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_socket:
                startActivity(new Intent(MainActivity.this, SocketActivity2.class));
                break;
            case R.id.btn_network:
                break;
            case R.id.recycleView:
                startActivity(new Intent(MainActivity.this, RecycleViewActivity.class));

                break;
            default:
                break;
        }
    }
}
