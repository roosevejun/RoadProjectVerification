package com.tongtu.roadproject.verifification.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.tongtu.roadproject.verifification.Appstart;
import com.tongtu.roadproject.verifification.R;
import com.tongtu.roadproject.verifification.utils.CircularAnim;
import com.tongtu.roadproject.verifification.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.activity
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/26-16:53
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */

public class LoginActivity extends Activity {

    RelativeLayout rl_user;
    @BindView(R.id.login)
    Button loginBtn;
    @BindView(R.id.login_progressBar)
    ProgressBar loginProgressBar;

    private CompositeSubscription mSubscriptions;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mSubscriptions = new CompositeSubscription();
        Subscription subscription = Appstart.getBusComponent().getUserLoginSubject().subscribe((message) -> {
            LogUtils.i(message);
        });

        getCompositeSubscription().add(subscription);
    }

    protected CompositeSubscription getCompositeSubscription() {
        return mSubscriptions;
    }


    @OnClick(R.id.login)
    public void userLoginOnClick(View view) {
        Appstart.getBusComponent().getUserLoginSubject().onNext("用户点击登录按钮");
        CircularAnim.hide(loginBtn)
                .endRadius(loginProgressBar.getHeight() / 2)
                .go(new CircularAnim.OnAnimationEndListener() {
                    @Override
                    public void onAnimationEnd() {
                        loginProgressBar.setVisibility(View.VISIBLE);
                        loginProgressBar.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                CircularAnim.fullActivity(LoginActivity.this, loginProgressBar)
                                        .go(new CircularAnim.OnAnimationEndListener() {
                                            @Override
                                            public void onAnimationEnd() {
                                                startActivity(new Intent(LoginActivity.this, LoginActivity.class));
                                                finish();
                                            }
                                        });
                            }
                        }, 2000);
                    }
                });
    }

    @OnClick(R.id.loginOut)
    public void exitApp(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("确定退出吗?");
        builder.setTitle("提示");
        builder.setPositiveButton("确认",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            dialog.dismiss();
                            Appstart.getBusComponent().getAppExitSubject().onNext("用户点击退出按钮");
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
//                            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
//                            homeIntent.addCategory(Intent.CATEGORY_HOME);
//                            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                            startActivity(homeIntent);
//                            System.exit(1);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
        builder.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSubscriptions.unsubscribe();
    }
}
