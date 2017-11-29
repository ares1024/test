package com.ares.test.mvp.dovelet.ProximitySensor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ares.test.mvp.dovelet.R;
import com.ares.test.mvp.dovelet.base.BaseFragment;


/**
 * Created by Administrator on 2017/11/22.
 */
public class ProximitySensorFragment extends BaseFragment<ProximitySensorContract.Presenter> implements ProximitySensorContract.View {
    public static final String TAG = ProximitySensorFragment.class.getSimpleName();

    private Button startBtn;
    private Button stopBtn;
    private TextView distanceText;

    public static ProximitySensorFragment newInstance() {
        ProximitySensorFragment fragment = new ProximitySensorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getCreateViewLayoutId() {
        return R.layout.fragment_proximity_sensor;
    }

    @Override
    protected void initBundleData() {
        if (getArguments() != null) {

        }
    }

    @Override
    protected void findView(View inflateView, Bundle savedInstanceState) {
        startBtn = autoFindViewById(R.id.btn_ps_start);
        stopBtn = autoFindViewById(R.id.btn_ps_stop);
        distanceText = autoFindViewById(R.id.text_ps_distance);
    }

    @Override
    protected void initView(View inflateView, Bundle savedInstanceState) {
        distanceText.setText("0");
    }

    @Override
    protected void initListener() {
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.measuring();
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.stop();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.stop();
    }

    @Override
    protected void loadServerData() {
//        mPresenter.measuring();
    }

    @Override
    public void showDistance(float distance) {
        distanceText.setText(distance + "");
    }
}
