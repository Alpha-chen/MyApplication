package com.example.administrator.myapplication.node.weather;

import java.io.Serializable;

/**
 * @author xupangen on 2018/1/9.
 */

public class WeatherIdBeanX implements Serializable {
    /**
     * fa : 00
     * fb : 01
     */

    private String fa;
    private String fb;

    public String getFa() {
        return fa;
    }

    public void setFa(String fa) {
        this.fa = fa;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }
}
