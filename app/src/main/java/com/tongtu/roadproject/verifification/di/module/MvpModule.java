package com.tongtu.roadproject.verifification.di.module;


import com.tongtu.roadproject.verifification.di.presenter.MVPPresenter;
import com.tongtu.roadproject.verifification.di.presenter.impl.MVPPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
@Module
public class MvpModule {
    @Provides
    @Singleton
    public MVPPresenter getMvpPresenter() {
        return new MVPPresenterImpl();
    }

}
