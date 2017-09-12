package com.anjile.shineourlove.myapplication;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zhy.autolayout.AutoLayoutActivity;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/9/12.
 */

public abstract class BaseActivity extends AutoLayoutActivity implements View.OnClickListener{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  //禁用横屏
        EventBus.getDefault().register(this);
        initBasic();
    }

    @Override
    public void onClick(View view) {
        viewClick(view);
    }

    public abstract void viewClick(View v);

    public abstract void initBasic();
}
