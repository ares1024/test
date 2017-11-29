package com.ares.test.mvp.dovelet.ProximitySensor;

import android.os.Bundle;
import android.util.Log;

import com.ares.test.mvp.dovelet.R;
import com.ares.test.mvp.dovelet.base.BaseActivity;
import com.ares.test.mvp.dovelet.utils.ActivityUtils;

public class ProximitySensorActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);

        ProximitySensorFragment sensorFragment = (ProximitySensorFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        Log.d("hdhd", "onCreate: sensorFragment " + sensorFragment);
        if (sensorFragment == null) {
            sensorFragment = ProximitySensorFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), sensorFragment, R.id.contentFrame);
            new ProximitySensorPresenter(this, sensorFragment);
        }
    }
}
