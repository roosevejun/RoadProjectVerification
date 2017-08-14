package com.tongtu.roadproject.verifification.di.interactor;

import com.tongtu.roadproject.verifification.data.model.User;

/**
 * 项目名称：RoadProjectVerification
 * 模块名称：com.tongtu.roadproject.verifification.di.interactor
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2017/7/27
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public interface LoginInteractor {
    interface LoginCallback {
        void onUsernameError(String error);

        void onPasswordError(String error);

        void onSuccess(User user) throws Exception;
    }

    void login(String username, String password, LoginCallback callback);

    void saveUser(User user);
}
