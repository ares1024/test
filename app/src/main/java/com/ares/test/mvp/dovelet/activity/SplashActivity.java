package com.ares.test.mvp.dovelet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ares.test.mvp.dovelet.ProximitySensor.ProximitySensorActivity;
import com.ares.test.mvp.dovelet.R;
import com.ares.test.mvp.dovelet.base.BaseActivity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/11.
 */

public class SplashActivity extends BaseActivity {
    final static String TAG = SplashActivity.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        if(!PermissionsUtil.checkPermissions(mContext)){
//
//        }

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
//                    getMainLooper().getThread().sleep(1000 * 100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Log.d(TAG, "onClick: 1111111");
                startActivity(new Intent(mContext, TestAActivity.class));
            }
        });

        findViewById(R.id.btn_service_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, ServiceActivity.class));
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList list = null;
                list.add("1");
            }
        });

        findViewById(R.id.start_ps_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, ProximitySensorActivity.class));
            }
        });
    }

    private void statr() {

    }
}
