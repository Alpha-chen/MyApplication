package com.example.click.websocket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.java_websocket.drafts.Draft_17;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity implements MessageCallBack {
    WebSocketTest webSocketTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            webSocketTest = new WebSocketTest(new URI("ws://192.168.1.222:8080/MySocket/websocket"), new Draft_17());
            webSocketTest.registerHandler(getLocalClassName(), this);
            webSocketTest.connect();
//            webSocketTest.send("我要给服务器发消息啊");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
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
            thread.run();
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
                Toast.makeText(isFinishing() ? getApplicationContext() : MainActivity.this, "服务器返回的数据->=" + message, Toast
                        .LENGTH_LONG).show();
            }
        });

    }

}
