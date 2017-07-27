package com.tongtu.roadproject.verifification.service;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;

import com.tongtu.roadproject.verifification.data.model.AppApplicationMgr;
import com.tongtu.roadproject.verifification.utils.AppLogMessageMgr;

/**
 * 项目名称：RoadProjectVerification
 * 模块名称：com.tongtu.roadproject.verifification.service
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2017/7/27
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public class DownloadService extends Service {
    private long mTaskId;
    private DownloadManager mDownloadManager;
    private String filePath;

    public DownloadService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        AppLogMessageMgr.w("onStartCommand:" + intent.getStringExtra("fileurl"));
        String fileurl = intent.getStringExtra("fileurl");
        downloadFile(fileurl);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void downloadFile(String fileurl) {
        filePath = "/sdcard/Download/" + fileurl.substring(fileurl.lastIndexOf("/") + 1);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(fileurl));
        request.setDestinationInExternalPublicDir("/Download/", fileurl.substring(fileurl.lastIndexOf("/") + 1));
        mDownloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        mTaskId = mDownloadManager.enqueue(request);
        registerReceiver(mReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkDownloadStatus();
        }
    };

    private void checkDownloadStatus() {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(mTaskId);
        Cursor c = mDownloadManager.query(query);
        if (c.moveToFirst()) {
            int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
            switch (status) {
               /* case DownloadManager.STATUS_PAUSED:
                    break;
                case DownloadManager.STATUS_FAILED:
                    break;
                case DownloadManager.STATUS_PENDING:
                    break;
                case DownloadManager.STATUS_RUNNING:
                    break;*/
                case DownloadManager.STATUS_SUCCESSFUL:
                    AppApplicationMgr.installApk(this, filePath);
                    break;
            }
        }


    }
}
