package com.example.click.websocket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.java_websocket.drafts.Draft_17;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity implements MessageCallBack {
    WebSocketTest webSocketTest;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
//            webSocketTest = new WebSocketTest(new URI("ws://192.168.1.222:8080/MySocket/websocket"), new Draft_17());
            webSocketTest = new WebSocketTest(new URI("ws://192.168.1.222:7890"), new Draft_17());
            webSocketTest.registerHandler(getLocalClassName(), this);
            webSocketTest.connect();
//            webSocketTest.send("我要给服务器发消息啊");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        textView= findViewById(R.id.results);
        webSocketTest.send("text->=");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                count ++;
                webSocketTest.send("text->="+count);
            }
        };
        Thread thread = new Thread(runnable);
        try {
            Thread.sleep(1000);
//            thread.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onDestroy() {
        webSocketTest.unRegisterHandler(getLocalClassName());
        super.onDestroy();

    }

    int count = 0;
    @Override
    public void onMessage(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                Toast.makeText(isFinishing() ? getApplicationContext() : MainActivity.this, "服务器返回的数据->=" + message, Toast
//                        .LENGTH_LONG).show();
                textView.setText(message);
            }
        });

    }

    public void webSocket(View view){
        webSocketTest.send("客户端随便发一个吧:"+Math.random()*100);
    }
}
