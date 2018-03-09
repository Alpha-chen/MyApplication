package com.example.click.websocket;

import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * Created by xupangen on 2018/3/7.
 */

public class WebSocketTest extends WebSocketClient {
    private String TAG = "WebSocketTest";


    private HashMap<String, MessageCallBack> callBacks = new HashMap<>();

    public void registerHandler(String key, MessageCallBack callBack) {
        if (callBacks.containsKey(key)) {
            return;
        }
        callBacks.put(key, callBack);
    }

    public void unRegisterHandler(String... keys) {
        if (keys.length == 0) {
            callBacks.clear();
            callBacks = new HashMap<>();
        }
        for (int i = 0; i < keys.length; i++) {
            if (callBacks.containsKey(keys[i])) {
                callBacks.remove(keys[i]);
            }
        }
    }

    public WebSocketTest(URI uri, Draft draft) throws URISyntaxException {
        super(uri, draft);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        Log.d(TAG, "onOpen->getHttpStatusMessage=" + serverHandshake.getHttpStatusMessage());
        Log.d(TAG, "onOpen->getHttpStatus=" + serverHandshake.getHttpStatus());
    }

    @Override
    public void onMessage(String s) {
        Log.d(TAG, "onMessage->onMessage=" + s);
        handleMessage(s);
    }


    @Override
    public void onClose(int i, String s, boolean b) {
        Log.d(TAG, "onClose->i=" + i);
        Log.d(TAG, "onClose->s=" + s);
        Log.d(TAG, "onClose->b=" + b);

    }

    @Override
    public void onError(Exception e) {
        Log.d(TAG, "onError->e=" + e.getMessage());
        e.printStackTrace();

    }

    private void handleMessage(String s) {
        for (String key : callBacks.keySet()) {
            callBacks.get(key).onMessage(s);
        }
    }
}
