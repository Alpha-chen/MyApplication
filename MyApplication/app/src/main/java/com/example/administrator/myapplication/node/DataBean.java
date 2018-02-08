package com.example.administrator.myapplication.node;

/**
 * @author xupangen on 2018/1/8.
 */

public class DataBean {
    /**
     * id : 0167da6ac35a49d4af35480c031f522c
     * userId : 16
     * readFlag : 1
     * readDate : 2018-01-08
     * type : 1
     * scNotify : {"createBy":"16","createDate":"2018-01-08 13:01:37","updateBy":"16","updateDate":"2018-01-08 13:01:37","id":"9ce0dfbe61e34665ba98534bbe935f69","title":"圈子验证消息","content":"{\"imgPath\":\"http://www.wtrade365.com:6080/scjr/userfiles/group/8-2.jpg?1515378931793\",\"time\":\"2018-01-08 13:01:37\",\"title\":\"金融荟\",\"content\":\"管理员同意加入圈子\"}","remarks":null,"status":"1"}
     */

    private String id;
    private int userId;
    private String readFlag;
    private String readDate;
    private String type;
    private ScNotifyBean scNotify;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    public String getReadDate() {
        return readDate;
    }

    public void setReadDate(String readDate) {
        this.readDate = readDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ScNotifyBean getScNotify() {
        return scNotify;
    }

    public void setScNotify(ScNotifyBean scNotify) {
        this.scNotify = scNotify;
    }

}
