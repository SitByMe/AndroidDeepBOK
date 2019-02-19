package com.example.zohar.androiddeepbok.utils;

import android.util.Log;

/**
 * Created by lhZou on 2019/02/19.
 * 日志工具类
 */
public class LogUtils {
    private static String baseTag = "LogUtils ---> ";

    public static void v(String tag, String content) {
        Log.v(baseTag.concat(tag), content);
    }

    public static void i(String tag, String content) {
        Log.i(baseTag.concat(tag), content);
    }

    public static void e(String tag, String content) {
        Log.e(baseTag.concat(tag), content);
    }

    public static void d(String tag, String content) {
        Log.d(baseTag.concat(tag), content);
    }
}
