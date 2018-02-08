package com.example.administrator.myapplication.retrofit;

import com.example.administrator.myapplication.node.weather.BodyNode;
import com.example.administrator.myapplication.node.weather.WeatherNode;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * @author xupangen on 2018/1/9.
 */

public interface HttpApi {
    public static String BASE_URL = "http://v.juhe.cn/weather/index";

    @GET
    Call<WeatherNode> getWeather(@Body BodyNode bodyNode);
}
