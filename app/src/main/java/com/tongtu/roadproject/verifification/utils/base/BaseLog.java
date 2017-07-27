package com.tongtu.roadproject.verifification.utils.base;

import android.util.Log;

import com.tongtu.roadproject.verifification.utils.KLog;

/**
 * 项目名称：RoadProjectVerification
 * 模块名称：com.tongtu.roadproject.verifification.utils.base
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2017/7/27
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public class BaseLog {
    private static final int MAX_LENGTH = 4000;

    public static void printDefault(int type, String tag, String msg) {

        int index = 0;
        int length = msg.length();
        int countOfSub = length / MAX_LENGTH;

        if (countOfSub > 0) {
            for (int i = 0; i < countOfSub; i++) {
                String sub = msg.substring(index, index + MAX_LENGTH);
                printSub(type, tag, sub);
                index += MAX_LENGTH;
            }
            printSub(type, tag, msg.substring(index, length));
        } else {
            printSub(type, tag, msg);
        }
    }

    private static void printSub(int type, String tag, String sub) {
        switch (type) {
            case KLog.V:
                Log.v(tag, sub);
                break;
            case KLog.D:
                Log.d(tag, sub);
                break;
            case KLog.I:
                Log.i(tag, sub);
                break;
            case KLog.W:
                Log.w(tag, sub);
                break;
            case KLog.E:
                Log.e(tag, sub);
                break;
            case KLog.A:
                Log.wtf(tag, sub);
                break;
        }
    }
}
