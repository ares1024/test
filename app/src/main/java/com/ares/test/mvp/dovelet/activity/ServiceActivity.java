package com.ares.test.mvp.dovelet.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ares.test.mvp.dovelet.R;
import com.ares.test.mvp.dovelet.base.BaseActivity;
import com.ares.test.mvp.dovelet.service.MyService;

public class ServiceActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = ServiceActivity.class.getSimpleName();

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBind myBind = (MyService.MyBind) service;
            myBind.service_connect_activity();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: " + name.toString());
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Button startBtn = (Button) findViewById(R.id.btn_start);
        Button stopBtn = (Button) findViewById(R.id.btn_stop);
        Button bindBtn = (Button) findViewById(R.id.btn_bind);
        Button unbindBtn = (Button) findViewById(R.id.btn_unbind);

        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        bindBtn.setOnClickListener(this);
        unbindBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int vid = v.getId();
        Intent serviceIntent = new Intent(this, MyService.class);
        if (vid == R.id.btn_start) {
            startService(serviceIntent);
        } else if (vid == R.id.btn_stop) {
            stopService(serviceIntent);
        } else if (vid == R.id.btn_bind) {
            //第三个参数:标志位
            //这里传入BIND_AUTO_CREATE表示在Activity和Service建立关联后自动创建Service
            bindService(serviceIntent, mConnection, BIND_AUTO_CREATE);
        } else if (vid == R.id.btn_unbind) {
            unbindService(mConnection);
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        super.onDestroy();
    }
}
