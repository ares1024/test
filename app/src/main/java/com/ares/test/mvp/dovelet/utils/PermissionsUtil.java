package com.ares.test.mvp.dovelet.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */

public class PermissionsUtil {
    public static final int sRequestPermissionCode = 1;

    private static String[] sNeedPermission = {
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.CALL_PHONE};

    /**
     * 检测 需要的权限
     *
     * @param context 上下文
     * @return true 需要权限认证    false 不需要
     */
    public static boolean checkPermissions(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return false;
        }
        List<String> needPermissions = new LinkedList<>();
        for (String permission : PermissionsUtil.sNeedPermission) {
            if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                needPermissions.add(permission);
            }
        }
        if (needPermissions.size() > 0) {
            ActivityCompat.requestPermissions((Activity) context, needPermissions.toArray(new String[needPermissions
                    .size()]), PermissionsUtil.sRequestPermissionCode);
            return true;
        }
        return false;
    }

    /**
     * 检测权限 结果判断
     *
     * @param grantResults 检测结果
     * @return true全部通过   false 有权限没有通过
     */
    public static boolean requestPermissions(int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
}
