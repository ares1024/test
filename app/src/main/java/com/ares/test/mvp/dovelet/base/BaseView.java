package com.ares.test.mvp.dovelet.base;

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

}
