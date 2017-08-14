package com.tongtu.roadproject.verifification.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.tongtu.roadproject.verifification.di.ApplicationContext;
import com.tongtu.roadproject.verifification.di.DatabaseInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * 项目名称：RoadProjectVerification
 * 模块名称：com.tongtu.roadproject.verifification.di.module
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2017/7/23
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "roadprojectverification.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("roadprojectverification-prefs", Context.MODE_PRIVATE);
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }
}
