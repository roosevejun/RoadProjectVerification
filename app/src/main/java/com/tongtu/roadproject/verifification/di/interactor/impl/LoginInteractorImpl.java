package com.tongtu.roadproject.verifification.di.interactor.impl;

import android.os.Handler;

import com.tongtu.roadproject.verifification.data.DataManager;
import com.tongtu.roadproject.verifification.data.model.User;
import com.tongtu.roadproject.verifification.di.interactor.LoginInteractor;

import javax.inject.Inject;

/**
 * 项目名称：RoadProjectVerification
 * 模块名称：com.tongtu.roadproject.verifification.di.interactor.impl
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2017/7/27
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public class LoginInteractorImpl implements LoginInteractor {
//    @Inject
//    DataManager mDataManager;

    public LoginInteractorImpl()
    {
//        this.mDataManager = mDataManager;
    }
    @Override
    public void login(String username, String password, LoginCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(username.isEmpty()){
                    callback.onUsernameError("用户名不能为空");
                    return;
                }

                if(password.isEmpty()){
                    callback.onPasswordError("密码不能为空");
                    return;
                }

                try {
                    callback.onSuccess(new User(username, password));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 3000);
    }

    @Override
    public void saveUser(User user) {
//        try {
//            mDataManager.createUser(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
