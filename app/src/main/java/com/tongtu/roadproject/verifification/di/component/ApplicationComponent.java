package com.tongtu.roadproject.verifification.di.component;

import android.app.Application;
import android.content.Context;

import com.tongtu.roadproject.verifification.DetectApplication;
import com.tongtu.roadproject.verifification.data.DataManager;
import com.tongtu.roadproject.verifification.data.DbHelper;
import com.tongtu.roadproject.verifification.data.SharedPrefsHelper;
import com.tongtu.roadproject.verifification.di.ApplicationContext;
import com.tongtu.roadproject.verifification.di.module.AppModule;
import com.tongtu.roadproject.verifification.di.module.BusModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import rx.subjects.PublishSubject;


/**
 * 项目名称：RoadProjectVerification
 * 模块名称：com.tongtu.roadproject.verifification.di.component
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2017/7/27
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Singleton
@Component(modules = {AppModule.class})
public interface ApplicationComponent {

    void inject(DetectApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();



}
