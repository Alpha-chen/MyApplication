package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SocketActivity2 extends AppCompatActivity {

    @BindView(R.id.result)
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket2);
        ButterKnife.bind(this);

    }

    private Socket socket;

    /**
     * 建立服务端连接
     */
    public void conn(View v) {
        new Thread() {

            @Override
            public void run() {

                try {
                    socket = new Socket("192.168.1.222", 30000);
                    Log.e("JAVA", "建立连接：" + socket);
                    startReader(socket);

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void startReader(Socket socket) {
        while (true) {
            DataInputStream inputStream = null;
            try {
                inputStream = new DataInputStream(socket.getInputStream());

                final String finalA = inputStream.readUTF();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(finalA);

                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 发送消息
     */
    public void send(View v) {
        new Thread() {
            @Override
            public void run() {

                try {
                    // socket.getInputStream()
                    DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
                    writer.writeUTF("嘿嘿，你好啊，服务器.."); // 写一个UTF-8的信息

                    System.out.println("发送消息");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
