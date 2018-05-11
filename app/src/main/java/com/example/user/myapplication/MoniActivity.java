package com.example.user.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.util.MoniUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created  on 2017/12/27.
 * author  CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */

public class MoniActivity extends Activity {
    private OkHttpClient client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moni);
        client = new OkHttpClient();


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    getOkhttp();

//                    getOkhttp1(7);
                }
            }
        });
    }

    public void getOkhttp() {
        new Thread(networkTask).start();
    }

    private String tag;

    public void getOkhttp1(int i) {
        tag = i + "";
        new Thread(networkRequestTask).start();
    }

    Runnable networkRequestTask = new Runnable() {

        @Override
        public void run() {
            RequestBody body = new FormBody.Builder()
                    .add("pid", tag).build();
            Request request = new Request.Builder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("X-FORWARD-FOR", MoniUtil.getRandomIp())
//                    .addHeader("HTTP_X_FORWARD_FOR", MoniUtil.getRandomIp())
                    .url("http://119.23.249.95:8080/oceano/api/piaos")
                    .post(body)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                    Log.e("-----", Thread.currentThread().getName() + "结果  " + e.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    Log.e("-----", Thread.currentThread().getName() + "结果  " + response.body().string());
                }
            });


        }
    };
    /**
     * 网络操作相关的子线程
     */
    Runnable networkTask = new Runnable() {

        @Override
        public void run() {
            Request request = new Request.Builder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("X-FORWARD-FOR", MoniUtil.getRandomIp())
//                    .addHeader("HTTP_X_FORWARD_FOR", MoniUtil.getRandomIp())
                    .url("http://event.oceano.com.cn/20171210a3/mobile/")
                    .get()
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                    Log.e("-----", Thread.currentThread().getName() + "结果  " + e.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    getOkhttp1(6);
                    getOkhttp1(7);
                    Log.e("-----", Thread.currentThread().getName() + "结果  " + response.body().string());
                }
            });
        }
    };
}
