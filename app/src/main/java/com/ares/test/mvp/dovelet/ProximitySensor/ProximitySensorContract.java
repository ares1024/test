package com.ares.test.mvp.dovelet.ProximitySensor;

import com.ares.test.mvp.dovelet.base.BasePresenter;
import com.ares.test.mvp.dovelet.base.BaseView;

/**
 * Created by Administrator on 2017/11/22.
 */

public class ProximitySensorContract {
    interface Presenter extends BasePresenter {
        void measuring();
        void stop();
    }

    interface View extends BaseView<Presenter> {
        void showDistance(float distance);
    }
}
