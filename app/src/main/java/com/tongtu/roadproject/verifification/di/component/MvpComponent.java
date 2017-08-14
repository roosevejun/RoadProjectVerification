package com.tongtu.roadproject.verifification.di.component;

import com.tongtu.roadproject.verifification.activity.BaseActivity;
import com.tongtu.roadproject.verifification.di.module.MvpModule;

import javax.inject.Singleton;

import dagger.Subcomponent;

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
@Subcomponent(modules = {MvpModule.class})
public interface MvpComponent {
    void inject(BaseActivity activity);
}
