package com.example.administrator.myapplication.node.weather;

import java.io.Serializable;

/**
 * @author xupangen on 2018/1/9.
 */

public class BodyNode implements Serializable {

    /**
     * 城市名或城市ID，如："苏州"，需要utf8 urlencode
     */
    private String cityname;
    /**
     * 返回数据格式：json或xml,默认json
     */
    private String dtype;
    /**
     * 你申请的key
     *
     */
    private String key;
    /**
     * 未来7天预报(future)两种返回格式，1或2，默认1
     */
    private int format;

}
