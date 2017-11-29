package com.ares.test.mvp.dovelet.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Administrator on 2017/10/11.
 */

public class BaseActivity extends AppCompatActivity {
    final static String TAG = "hdhd";
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: " + this.getLocalClassName() + "  " + this.getTaskId());
        this.mContext = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: " + this.getLocalClassName() + "  " + this.getTaskId());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: " + this.getLocalClassName() + "  " + this.getTaskId());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: " + this.getLocalClassName() + "  " + this.getTaskId());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + this.getLocalClassName() + "  " + this.getTaskId());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: " + this.getLocalClassName() + "  " + this.getTaskId());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent: " + this.getLocalClassName() + "  " + this.getTaskId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + this.getLocalClassName() + "  " + this.getTaskId());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: " + this.getLocalClassName() + "  " + this.getTaskId());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: " + this.getLocalClassName() + "  " + this.getTaskId());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: " + this.getLocalClassName() + "  " + this.getTaskId());
    }

    protected void showKKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    protected void hideKeyboard(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (v != null && inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}
