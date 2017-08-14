package com.tongtu.roadproject.verifification.di.component;

import com.tongtu.roadproject.verifification.activity.LoginActivity;
import com.tongtu.roadproject.verifification.di.PerActivity;
import com.tongtu.roadproject.verifification.di.module.LoginModule;
import com.tongtu.roadproject.verifification.di.module.MvpModule;


import javax.inject.Singleton;

import dagger.Component;

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
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {LoginModule.class})
public interface LoginComponent {
    MvpComponent mvpComponent(MvpModule mvpModule);
    void inject(LoginActivity activity);

}
