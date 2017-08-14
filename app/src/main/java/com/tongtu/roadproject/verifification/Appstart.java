package com.tongtu.roadproject.verifification;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tongtu.roadproject.verifification.activity.BaseActivity;
import com.tongtu.roadproject.verifification.activity.LoginActivity;
import com.tongtu.roadproject.verifification.data.DataManager;
import com.tongtu.roadproject.verifification.di.component.ActivityComponent;
import com.tongtu.roadproject.verifification.di.component.ApplicationComponent;
import com.tongtu.roadproject.verifification.di.component.DaggerActivityComponent;
import com.tongtu.roadproject.verifification.di.module.ActivityModule;
import com.tongtu.roadproject.verifification.utils.CircularAnim;
import com.tongtu.roadproject.verifification.utils.LogUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


public class Appstart extends BaseActivity {
    @Inject
    DataManager mDataManager;
    @Inject
    CompositeSubscription mSubscriptions;
    @BindView(R.id.sys_name)
    TextView sysName;


    private ActivityComponent appStartComponent;


    public ActivityComponent getAppStartComponent() {
        if (appStartComponent == null) {
            appStartComponent = DaggerActivityComponent.builder()
                    .applicationComponent(DetectApplication.get(this).component()).activityModule(new ActivityModule(this))
                    .build();
        }
        return appStartComponent;
    }

    protected CompositeSubscription getCompositeSubscription() {
        return mSubscriptions;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CircularAnim.init(700, 500, R.color.colorPrimary);
        setContentView(R.layout.activity_appstart);
        ButterKnife.bind(this);
    }

    @Override
    protected void setupComponent(ApplicationComponent applicationComponent) {
        getAppStartComponent().inject(this);

        Subscription subscription = DetectApplication.getBusComponent().getAppExitSubject().subscribe((message) -> {
            LogUtils.i(message);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        });

        getCompositeSubscription().add(subscription);
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //判断用户是否登陆
        if (mDataManager.getuserLogin()) {

        } else {
            sysName.postDelayed(new Runnable() {
                @Override
                public void run() {
                    CircularAnim.fullActivity(Appstart.this, sysName)
                            .go(new CircularAnim.OnAnimationEndListener() {
                                @Override
                                public void onAnimationEnd() {
                                    startActivity(new Intent(Appstart.this, LoginActivity.class));
                                    finish();
                                }
                            });
                }
            }, 1000);
        }
    }


}