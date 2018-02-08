package com.example.administrator.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.event.BaseEvent;

import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SocketActivity extends BaseActivity {
    Socket socket = null;
    String buffer = "";
    String geted1;

    @BindView(R.id.ed1)
    EditText ed1;
    @BindView(R.id.send)
    Button send;
    @BindView(R.id.txt1)
    TextView txt1;
    @BindView(R.id.sendLay)
    LinearLayout linearLayout;
    @Override
    public void onMessageEvent(BaseEvent event) {
        super.onMessageEvent(event);
        if ((0x11 + "").equals(event.getSendName())) {
            txt1.append("server:" + event.getObject().toString() + "\n");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sokcet);
        ButterKnife.bind(this);
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        linearLayout.measure(w,h);
        Log.d("SocketActivity","linearLayout->getWidth="+linearLayout.getWidth());
        Log.d("SocketActivity","linearLayout->="+linearLayout.getMeasuredWidth());
    }

    @OnClick(R.id.send)
    public void onViewClicked() {
        geted1 = ed1.getText().toString();
        txt1.append("client:" + geted1 + "\n");
        //启动线程 向服务器发送和接收信息
        new MyThread(geted1).start();
    }

    class MyThread extends Thread {

        public String txt1;

        public MyThread(String str) {
            txt1 = str;
        }

        @Override
        public void run() {
            //定义消息
            try {
                //连接服务器 并设置连接超时为5秒
                socket = new Socket();
                socket.connect(new InetSocketAddress("192.168.1.170", 30000), 5000);
                //获取输入输出流
                OutputStream ou = socket.getOutputStream();
                BufferedReader bff = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                //读取服务器发来信息
                String line = null;
                buffer = "";
                while ((line = bff.readLine()) != null) {
                    buffer = line + buffer;
                }

                //向服务器发送信息
                ou.write(("android 客户端" + geted1).getBytes("gbk"));
                ou.flush();
                //发送消息 修改UI线程中的组件
                BaseEvent event = new BaseEvent();
                event.setSendName(0x11 + "");
                event.setObject(buffer.toString());
                EventBus.getDefault().post(event);
//                myHandler.sendMessage(msg);
                //关闭各种输入输出流
                bff.close();
                ou.close();
                socket.close();
            } catch (SocketTimeoutException aa) {
                //连接超时 在UI界面显示消息
                //发送消息 修改UI线程中的组件
                BaseEvent event = new BaseEvent();
                event.setSendName(0x11 + "");
                event.setObject("服务器连接失败！请检查网络是否打开");
                EventBus.getDefault().post(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }
}
