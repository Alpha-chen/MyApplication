package com.example.administrator.myapplication.node;

import java.util.List;

/**
 * @author xupangen on 2018/1/8.
 */

public class TestNode {

    /**
     * result : true
     * data : [{"id":"0167da6ac35a49d4af35480c031f522c","userId":16,"readFlag":"1","readDate":"2018-01-08","type":"1","scNotify":{"createBy":"16","createDate":"2018-01-08 13:01:37","updateBy":"16","updateDate":"2018-01-08 13:01:37","id":"9ce0dfbe61e34665ba98534bbe935f69","title":"圈子验证消息","content":"{\"imgPath\":\"http://www.wtrade365.com:6080/scjr/userfiles/group/8-2.jpg?1515378931793\",\"time\":\"2018-01-08 13:01:37\",\"title\":\"金融荟\",\"content\":\"管理员同意加入圈子\"}","remarks":null,"status":"1"}}]
     */

    private boolean result;
    private List<DataBean> data;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }
}
