package com.example.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.example.util.PriceUtils;
import com.example.widget.CircleView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2017/6/8.
 */

public class DActivity extends AppCompatActivity {

    private static final String TAG = "DActivity";
    @BindView(R.id.circleWaveImageView)
    CircleView circleWaveImageView;
    @BindView(R.id.et_edit_price)
    EditText etEditPrice;
    @BindView(R.id.et_edit_num)
    EditText etEditNum;
    @BindView(R.id.et_edit_num1)
    EditText etEditNum1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_d);
        ButterKnife.bind(this);

//        view = (CircleWaveImageView) findViewById(R.id.circleWaveImageView);
        PriceUtils.priceETSetting(etEditPrice);
        PriceUtils.numberETSetting(etEditNum);
        PriceUtils.numberETZeroSetting(etEditNum1);

        circleWaveImageView.start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        circleWaveImageView.stop();
        Log.i(TAG, "onDestroy()");
    }
}
