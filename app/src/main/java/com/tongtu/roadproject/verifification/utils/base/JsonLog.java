package com.tongtu.roadproject.verifification.utils.base;

import android.util.Log;

import com.tongtu.roadproject.verifification.utils.KLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
public class JsonLog {
    public static void printJson(String tag, String msg, String headString) {

        String message;

        try {
            if (msg.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(KLog.JSON_INDENT);
            } else if (msg.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(KLog.JSON_INDENT);
            } else {
                message = msg;
            }
        } catch (JSONException e) {
            message = msg;
        }

        KLogUtil.printLine(tag, true);
        message = headString + KLog.LINE_SEPARATOR + message;
        String[] lines = message.split(KLog.LINE_SEPARATOR);
        for (String line : lines) {
            Log.d(tag, "║ " + line);
        }
        KLogUtil.printLine(tag, false);
    }
}
