package com.tongtu.roadproject.verifification;

import android.app.Application;
import android.content.Context;

import com.tongtu.roadproject.verifification.data.DataManager;
import com.tongtu.roadproject.verifification.di.component.ApplicationComponent;
import com.tongtu.roadproject.verifification.di.component.BusComponent;
import com.tongtu.roadproject.verifification.di.component.DaggerApplicationComponent;
import com.tongtu.roadproject.verifification.di.component.DaggerBusComponent;
import com.tongtu.roadproject.verifification.di.module.AppModule;

import javax.inject.Inject;

/**
 * Created by janisharali on 25/12/16.
 */

public class DetectApplication extends Application {

    protected ApplicationComponent applicationComponent;

    private static BusComponent sBusComponent;

    @Inject
    DataManager dataManager;

    public static DetectApplication get(Context context) {
        return (DetectApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();

    }

    private void setupGraph() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        sBusComponent = DaggerBusComponent.create();
        applicationComponent.inject(this);
    }

    public static BusComponent getBusComponent() {
        return sBusComponent;
    }

    public ApplicationComponent component() {
        return applicationComponent;
    }
}
