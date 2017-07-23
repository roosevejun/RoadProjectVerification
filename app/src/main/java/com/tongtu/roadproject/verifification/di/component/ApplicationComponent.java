package com.tongtu.roadproject.verifification.di.component;

import android.app.Application;
import android.content.Context;

import com.tongtu.roadproject.verifification.DemoApplication;
import com.tongtu.roadproject.verifification.data.DataManager;
import com.tongtu.roadproject.verifification.data.DbHelper;
import com.tongtu.roadproject.verifification.data.SharedPrefsHelper;
import com.tongtu.roadproject.verifification.di.ApplicationContext;
import com.tongtu.roadproject.verifification.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by janisharali on 08/12/16.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}
