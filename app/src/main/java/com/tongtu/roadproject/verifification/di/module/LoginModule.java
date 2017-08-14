package com.tongtu.roadproject.verifification.di.module;

import com.tongtu.roadproject.verifification.data.DataManager;
import com.tongtu.roadproject.verifification.di.interactor.LoginInteractor;
import com.tongtu.roadproject.verifification.di.interactor.impl.LoginInteractorImpl;
import com.tongtu.roadproject.verifification.di.presenter.LoginPresenter;
import com.tongtu.roadproject.verifification.di.presenter.impl.LoginPresenterImpl;
import com.tongtu.roadproject.verifification.di.view.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * 项目名称：RoadProjectVerification
 * 模块名称：com.tongtu.roadproject.verifification.data.model
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2017/7/27
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Module
public class LoginModule {
    private final LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

//    @Singleton
    @Provides
    public LoginView provideLoginView() {
        return view;
    }

//    @Singleton
    @Provides
    public LoginInteractor provideLoginInteractor() {
        return new LoginInteractorImpl();
    }

//    @Singleton
    @Provides
    public LoginPresenter provideLoginPresenter(LoginView loginView, LoginInteractor interactor) {
        return new LoginPresenterImpl(loginView, interactor);
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }
}
