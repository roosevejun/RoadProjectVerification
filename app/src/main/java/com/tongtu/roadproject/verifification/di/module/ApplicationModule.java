package com.tongtu.roadproject.verifification.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.tongtu.roadproject.verifification.di.ApplicationContext;
import com.tongtu.roadproject.verifification.di.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by janisharali on 25/12/16.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
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
}
