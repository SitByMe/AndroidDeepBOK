package com.example.zohar.androiddeepbok.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by lhZou on 2019/02/19.
 * desc:
 */
public class StartActivityUtils {

    /**
     * 跳转源生界面
     *
     * @param context 上下文
     * @param cls     泛型
     */
    public static void startActivity(Context context, Class<?> cls) {
        context.startActivity(new Intent(context, cls));
    }

    /**
     * 跳转源生界面
     *
     * @param context 上下文
     * @param cls     泛型
     * @param bundle  传递参数
     */
    public static void startActivity(Context context, Class<?> cls, Bundle bundle) {
        context.startActivity(new Intent(context, cls).putExtras(bundle));
    }

    /**
     * 跳转源生界面
     *
     * @param context     上下文
     * @param cls         泛型
     * @param requestCode 请求code
     */
    public static void startActivityForResult(Context context, Class<?> cls, int requestCode) {
        ((Activity) context).startActivityForResult(new Intent(context, cls), requestCode);
    }

    /**
     * 跳转源生界面
     *
     * @param context     上下文
     * @param cls         泛型
     * @param bundle      传递参数
     * @param requestCode 请求code
     */
    public static void startActivityForResult(Context context, Class<?> cls, Bundle bundle, int requestCode) {
        ((Activity) context).startActivityForResult(new Intent(context, cls).putExtras(bundle), requestCode);
    }
}
