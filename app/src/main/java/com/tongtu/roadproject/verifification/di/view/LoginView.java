package com.tongtu.roadproject.verifification.di.view;

/**
 * 项目名称：RoadProjectVerification
 * 模块名称：com.tongtu.roadproject.verifification.di.view
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2017/7/27
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUsernameError(String error);
    void setPasswordError(String error);
    void navigateToHome();
}
