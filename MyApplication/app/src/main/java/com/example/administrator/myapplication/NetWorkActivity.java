package com.example.administrator.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myapplication.retrofit.HttpApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author xupangen
 */
public class NetWorkActivity extends BaseActivity {

    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.request)
    Button request;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.request)
    public void onViewClicked() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HttpApi service = retrofit.create(HttpApi.class);

    }
}
