package com.ares.test.mvp.dovelet.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.ares.test.mvp.dovelet.IMyAidlInterface;

public class MyService extends Service {
    public static final String TAG = MyService.class.getSimpleName();
    private IBinder mBinder = new MyBind();

    IMyAidlInterface.Stub mBinderAIDL = new IMyAidlInterface.Stub() {
        @Override
        public void sum(int a, int b) throws RemoteException {
            Log.d(TAG, "sum: " + (a + b));
        }
    };

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG,"onUnbind");
        return super.onUnbind(intent);
    }

    public class MyBind extends Binder {
        public void service_connect_activity(){
            Log.d(TAG,"service_connect_activity");
        }
    }
}
