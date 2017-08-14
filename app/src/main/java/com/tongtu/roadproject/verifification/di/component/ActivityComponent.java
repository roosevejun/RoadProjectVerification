package com.tongtu.roadproject.verifification.di.component;

import com.tongtu.roadproject.verifification.Appstart;
import com.tongtu.roadproject.verifification.di.PerActivity;
import com.tongtu.roadproject.verifification.di.module.ActivityModule;
import com.tongtu.roadproject.verifification.di.module.MvpModule;

import dagger.Component;

/**
 * Created by janisharali on 08/12/16.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    MvpComponent mvpComponent(MvpModule mvpModule);

    void inject(Appstart appstart);
}
