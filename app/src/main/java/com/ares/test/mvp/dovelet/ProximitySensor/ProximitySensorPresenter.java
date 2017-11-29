package com.ares.test.mvp.dovelet.ProximitySensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.util.Log;

import com.ares.test.mvp.dovelet.utils.CheckNull;

/**
 * Created by Administrator on 2017/11/22.
 */

class ProximitySensorPresenter implements ProximitySensorContract.Presenter {
    public static final String TAG = ProximitySensorPresenter.class.getSimpleName();
    private ProximitySensorContract.View mPSView;
    private boolean mHasStarted;
    private SensorManager mSensorManager;
    private float distance = 0f;
    private SensorEventListener mSensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event != null && event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                // values[0]: Proximity sensor distance measured in centimeters
                distance = event.values[0];
                Log.v(TAG, "proximity sensor distance: " + distance);
                mPSView.showDistance(distance);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    ProximitySensorPresenter(Context context, @NonNull ProximitySensorContract.View view) {
        mSensorManager = (SensorManager) context.getApplicationContext().getSystemService(Context.SENSOR_SERVICE);
        mPSView = CheckNull.checkNotNull(view, "ProximitySensorContract view cannot be null!");
        mPSView.setPresenter(this);
        Log.d(TAG, "ProximitySensorPresenter: ");
    }

    @Override
    public void start() {
        Log.d(TAG, "start: is start");
        mHasStarted = false;
        registerListener();
    }

    @Override
    public void measuring() {
        registerListener();
    }

    @Override
    public void stop() {
        unregisterListener();
    }

    /**
     * Use this method to start listening of the sensor
     */
    private void registerListener() {
        if (mHasStarted) {
            return;
        }
        mHasStarted = true;
        Sensor proximitySensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY); // 获取距离传感器
        if (proximitySensor != null) { // 距离传感器存在时才执行
            mSensorManager.registerListener(mSensorEventListener, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL); // 注册事件监听
        }
    }

    /**
     * Use this method to stop listening of the sensor
     */
    private void unregisterListener() {
        if (!mHasStarted || mSensorManager == null) {
            return;
        }
        mHasStarted = false;
        mSensorManager.unregisterListener(mSensorEventListener);
    }

    private float getValue() {
        if (!mHasStarted) {
            Log.w(TAG, "proximity sensor has not start!");
        }
        return distance;
    }
}
