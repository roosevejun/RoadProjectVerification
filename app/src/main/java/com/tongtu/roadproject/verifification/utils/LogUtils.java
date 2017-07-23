package com.tongtu.roadproject.verifification.utils;
import android.util.Log;
/**
 * 项目名称：RoadProjectVerification
 * 模块名称：com.tongtu.roadproject.verifification.utils
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2017/7/23
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public class LogUtils {
    private static final String TAG = "LOGUTIL";
    private static boolean LOG_ENABLE = true;
    private static boolean DETAIL_ENABLE = true;

    private static String buildMsg(String msg) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(msg);
        return buffer.toString();
    }

    /**
     * 设置是否显示Log
     * @param enable true-显示 false-不显示
     */
    public static void setLogEnable(boolean enable) {
        LOG_ENABLE = enable;
    }


    /**
     * verbose log
     * @param msg log msg
     */
    public static void v(String msg) {
        if (LOG_ENABLE) {
            Log.v(TAG, buildMsg(msg));
        }
    }

    /**
     * verbose log
     * @param tag tag
     * @param msg log msg
     */
    public static void v(String tag, String msg) {
        if (LOG_ENABLE) {
            Log.v(tag, buildMsg(msg));
        }
    }

    /**
     * debug log
     * @param msg log msg
     */
    public static void d(String msg) {
        if (LOG_ENABLE) {
            Log.d(TAG, buildMsg(msg));
        }
    }

    /**
     * debug log
     * @param tag tag
     * @param msg log msg
     */
    public static void d(String tag, String msg) {
        if (LOG_ENABLE) {
            Log.d(tag, buildMsg(msg));
        }
    }

    /**
     * info log
     * @param msg log msg
     */
    public static void i(String msg) {
        if (LOG_ENABLE) {
            Log.i(TAG, buildMsg(msg));
        }
    }

    /**
     * info log
     * @param tag tag
     * @param msg log msg
     */
    public static void i(String tag, String msg) {
        if (LOG_ENABLE) {
            Log.i(tag, buildMsg(msg));
        }
    }

    /**
     * warning log
     * @param msg log msg
     */
    public static void w(String msg) {
        if (LOG_ENABLE) {
            Log.w(TAG, buildMsg(msg));
        }
    }

    /**
     * warning log
     * @param msg log msg
     * @param e exception
     */
    public static void w(String msg, Exception e) {
        if (LOG_ENABLE) {
            Log.w(TAG, buildMsg(msg), e);
        }
    }

    /**
     * warning log
     * @param tag tag
     * @param msg log msg
     */
    public static void w(String tag, String msg) {
        if (LOG_ENABLE) {
            Log.w(tag, buildMsg(msg));
        }
    }

    /**
     * warning log
     * @param tag tag
     * @param msg log msg
     * @param e exception
     */
    public static void w(String tag, String msg, Exception e) {
        if (LOG_ENABLE) {
            Log.w(tag, buildMsg(msg), e);
        }
    }

    /**
     * error log
     * @param msg log msg
     */
    public static void e(String msg) {
        if (LOG_ENABLE) {
            Log.e(TAG, buildMsg(msg));
        }
    }

    /**
     * error log
     * @param msg log msg
     * @param e exception
     */
    public static void e(String msg, Exception e) {
        if (LOG_ENABLE) {
            Log.e(TAG, buildMsg(msg), e);
        }
    }

    /**
     * error log
     * @param tag tag
     * @param msg msg
     */
    public static void e(String tag, String msg) {
        if (LOG_ENABLE) {
            Log.e(tag, buildMsg(msg));
        }
    }

    /**
     * error log
     * @param tag tag
     * @param msg log msg
     * @param e exception
     */
    public static void e(String tag, String msg, Exception e) {
        if (LOG_ENABLE) {
            Log.e(tag, buildMsg(msg), e);
        }
    }
}
