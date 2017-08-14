package com.tongtu.roadproject.verifification.di.presenter.impl;

import com.tongtu.roadproject.verifification.data.model.User;
import com.tongtu.roadproject.verifification.di.interactor.LoginInteractor;
import com.tongtu.roadproject.verifification.di.presenter.LoginPresenter;
import com.tongtu.roadproject.verifification.di.view.LoginView;

/**
 * 项目名称：RoadProjectVerification
 * 模块名称：com.tongtu.roadproject.verifification.di.presenter.impl
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2017/7/27
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.LoginCallback {
    private final LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view, LoginInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void login(String username, String password) {
        if(view != null){
            view.showProgress();
        }
        interactor.login(username, password, this);
    }

    @Override
    public void onUsernameError(String error) {
        if(view != null){
            view.hideProgress();
            view.setUsernameError(error);
        }
    }

    @Override
    public void onPasswordError(String error) {
        if(view != null){
            view.hideProgress();
            view.setPasswordError(error);
        }
    }

    @Override
    public void onSuccess(User user)  {
//        interactor.saveUser(user);

        if(view != null){
            view.navigateToHome();
        }
    }
}
