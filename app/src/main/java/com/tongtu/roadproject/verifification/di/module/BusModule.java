package com.tongtu.roadproject.verifification.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subjects.PublishSubject;

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
public class BusModule {
    public static final String PROVIDER_TOP_SUBJECT = "PROVIDER_TOP_SUBJECT";
    public static final String PROVIDER_APP_EXIT_SUBJECT = "PROVIDER_APP_EXIT_SUBJECT";
    public static final String PROVIDER_BOTTOM_SUBJECT = "PROVIDER_BOTTOM_SUBJECT";
    public static final String PROVIDER_USER_LOGIN_SUBJECT = "PROVIDER_USER_LOGIN_SUBJECT";

    @Provides
    @Singleton
    @Named(PROVIDER_TOP_SUBJECT)
    static PublishSubject<String> provideTopSubject() {
        return PublishSubject.create();
    }

    @Provides
    @Singleton
    @Named(PROVIDER_BOTTOM_SUBJECT)
    static PublishSubject<String> provideBottomSubject() {
        return PublishSubject.create();
    }

    @Provides
    @Singleton
    @Named(PROVIDER_USER_LOGIN_SUBJECT)
    static PublishSubject<String> provideUserLoginSubject() {
        return PublishSubject.create();
    }

    @Provides
    @Singleton
    @Named(PROVIDER_APP_EXIT_SUBJECT)
    static PublishSubject<String> provideAppExitSubject() {
        return PublishSubject.create();
    }
}
