package com.example.administrator.myapplication.event;

/**
 * 事件的基础类
 *
 * @author xupangen on 2018/1/9.
 */

public class BaseEvent {

    /**
     * 发送者
     */
    public String sendName = "";
    /**
     * 接收者
     */
    public String receiveName = "";
    /**
     * 发送的事件对象
     */
    public Object object;

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String   toString() {
        return "BaseEvent{" +
                "sendName='" + sendName + '\'' +
                ", receiveName='" + receiveName + '\'' +
                ", object=" + object +
                '}';
    }
}
