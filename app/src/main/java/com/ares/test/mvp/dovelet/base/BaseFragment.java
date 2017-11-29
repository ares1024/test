package com.ares.test.mvp.dovelet.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ares.test.mvp.dovelet.utils.CheckNull;

/**
 * Fragment基类 一些重复性工作，和显示工具
 * @param <T> 关联对应的 presenter
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView<T> {

    protected T mPresenter;
    protected Context mContext;
    protected View mRootView;
    private boolean isFirstStart = true;

    @Override
    public void setPresenter(T presenter) {
        mPresenter = CheckNull.checkNotNull(presenter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBundleData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getCreateViewLayoutId(), container, false);
        findView(mRootView, savedInstanceState);
        initView(mRootView, savedInstanceState);
        initListener();
        return mRootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isFirstStart){
            loadServerData();
            isFirstStart = false;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public Context getActivityContext() {
        return mContext;
    }

    /**
     * 查找控件
     * @param viewId 控件Id
     * @param <VIEW> 泛型参数，你所查找的View类型
     * @return 返回控件对象，否则返回null
     */
    final public <VIEW extends View> VIEW autoFindViewById(@IdRes int viewId){
        return (VIEW) mRootView.findViewById(viewId);
    }
    /**
     * 此方法用于返回Fragment设置ContentView的布局文件资源ID
     *
     * @return 布局文件资源ID
     */
    @LayoutRes
    protected abstract int getCreateViewLayoutId();

    /**
     * 此方法用于初始化成员变量及获取Intent传递过来的数据
     * 注意：这个方法中不能调用所有的View，因为View还没有被初始化，要使用View在initView方法中调用
     */
    protected abstract void initBundleData();

    /**
     * 此方法用于初始化布局中所有的View，如果使用了View注入框架则不需要调用
     */
    protected abstract void findView(View inflateView, Bundle savedInstanceState);

    /**
     * 此方法用于设置View显示数据
     */
    protected abstract void initView(View inflateView, Bundle savedInstanceState);

    /**
     * 注册监听
     */
    protected abstract void initListener();

    /**
     * 此方法用于开始加载网络数据
     */
    protected abstract void loadServerData();

    /**
     * [简化Toast]
     *
     * @param msg 需要发送的信息
     */
    protected void showToast(final String msg) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        }
    }

    protected void showSnackBar(View view, String content) {
        Snackbar.make(view, content, Snackbar.LENGTH_SHORT).show();
    }

    protected void showSnackBarByCallBack(View view, String content, String action, View.OnClickListener onClickListener) {
        Snackbar.make(view, content, Snackbar.LENGTH_SHORT).setAction(action, onClickListener).
                show();
    }

    protected void showSnackBarAllExist(View view, String content, String action, View.OnClickListener onClickListener) {
        Snackbar.make(view, content, Snackbar.LENGTH_INDEFINITE).setAction(action, onClickListener).show();
    }
}
