package com.tongtu.roadproject.verifification.di.component;

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
 * 创建时间:2017/7/23
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

@Singleton
@Component(modules = BusModule.class)
public interface BusComponent {
    @Named(BusModule.PROVIDER_TOP_SUBJECT)
    PublishSubject<String> getTopSubject();

    @Named(BusModule.PROVIDER_BOTTOM_SUBJECT)
    PublishSubject<String> getBottomSubject();

    @Named(BusModule.PROVIDER_USER_LOGIN_SUBJECT)
    PublishSubject<String> getUserLoginSubject();

    @Named(BusModule.PROVIDER_APP_EXIT_SUBJECT)
    PublishSubject<String> getAppExitSubject();
}
