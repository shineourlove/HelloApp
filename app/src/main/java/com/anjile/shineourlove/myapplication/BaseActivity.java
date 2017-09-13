package com.anjile.shineourlove.myapplication;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/9/12.
 */

public abstract class BaseActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  //禁用横屏
        ButterKnife.bind(this);
        initBasic();
    }

    @Override
    public void onClick(View view) {
        viewClick(view);
    }

    public abstract void viewClick(View v);

    public abstract void initBasic();
}
