package com.example.administrator.myapplication.node.weather;

import java.io.Serializable;

/**
 * @author xupangen on 2018/1/9.
 */

public class FutureBean implements Serializable {
    /**
     * temperature : 28℃~36℃
     * weather : 晴转多云
     * weather_id : {"fa":"00","fb":"01"}
     * wind : 南风3-4级
     * week : 星期一
     * date : 20140804
     */

    private String temperature;
    private String weather;
    private WeatherIdBeanX weather_id;
    private String wind;
    private String week;
    private String date;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public WeatherIdBeanX getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(WeatherIdBeanX weather_id) {
        this.weather_id = weather_id;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
