package com.tongtu.roadproject.verifification.data;

import android.content.Context;
import android.content.res.Resources;

import com.tongtu.roadproject.verifification.data.model.User;
import com.tongtu.roadproject.verifification.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by janisharali on 25/12/16.
 */

@Singleton
public class DataManager {

    private Context mContext;
    private DbHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mSharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public void userLogin(Boolean isLogin) {
        mSharedPrefsHelper.put(SharedPrefsHelper.USER_LOGIN_ACCESS, isLogin.booleanValue());
    }

    public Boolean getuserLogin() {
        return mSharedPrefsHelper.get(SharedPrefsHelper.USER_LOGIN_ACCESS, false);
    }

    public String getAccessToken() {
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        return mDbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getUser(userId);
    }
}
