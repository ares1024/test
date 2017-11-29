package com.ares.test.mvp.dovelet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;

import com.ares.test.mvp.dovelet.R;
import com.ares.test.mvp.dovelet.base.BaseActivity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/27.
 */

public class TestAActivity extends BaseActivity {
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Handler mHandler2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_a);

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList list = null;
                list.add("1");
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,TestAActivity.class));
//                finish();
            }
        });
    }
}
