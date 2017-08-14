package com.tongtu.roadproject.verifification.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tongtu.roadproject.verifification.DetectApplication;
import com.tongtu.roadproject.verifification.di.component.ApplicationComponent;
import com.tongtu.roadproject.verifification.di.component.DaggerActivityComponent;
import com.tongtu.roadproject.verifification.di.component.DaggerLoginComponent;

/**
 * 项目名称：RoadProjectVerification
 * 模块名称：com.tongtu.roadproject.verifification.activity
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2017/7/27
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent((ApplicationComponent) DetectApplication.get(this).component());
    }

    protected abstract void setupComponent(ApplicationComponent applicationComponent);
}
