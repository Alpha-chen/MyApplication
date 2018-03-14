package com.example.administrator.myapplication.nettyActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.netty.NettyClientFilter;
import com.example.administrator.myapplication.netty.NettyClientHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettySocketActivity extends AppCompatActivity implements
        NettyClientHandler.CallBack {

    @BindView(R.id.result)
    TextView textView;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netty_socket);
        ButterKnife.bind(this);
        initNetty();
    }

    public static String host = "192.168.1.222";
    private static int port = 6789;


    public static EventLoopGroup eventExecutors = new NioEventLoopGroup();
    public static Bootstrap bootstrap = new Bootstrap();
    private static Channel channel;

    private void initNetty() {
        bootstrap.group(eventExecutors);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new NettyClientFilter(this));
        try {
            channel = bootstrap.connect(host, port).sync().channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String hello = "hello netty";
        channel.writeAndFlush(hello + "\r\n");
    }

    private String string;
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void serverMessage(String message) {
        stringBuilder.append(message);
        if (Thread.currentThread() != getMainLooper().getThread()){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText(stringBuilder.toString());
                    scrollView.fullScroll(View.FOCUS_DOWN);
                }
            });
        }
    }
}
