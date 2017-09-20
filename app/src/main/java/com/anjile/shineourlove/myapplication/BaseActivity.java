package com.anjile.shineourlove.myapplication;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.HashSet;
import java.util.Set;

import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;


/**
 * Created by Administrator on 2017/9/12.
 */

public abstract class BaseActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  //禁用横屏
        ButterKnife.bind(this);
        JPushInterface.setDebugMode(true);//正式版的时候设置false，关闭调试
        JPushInterface.init(this);
        //建议添加tag标签，发送消息的之后就可以指定tag标签来发送了
        Set<String> set = new HashSet<>();
        set.add("MyApplication");//名字任意，可多添加几个
        JPushInterface.setTags(this, set, null);//设置标签
        initBasic();
    }

    @Override
    public void onClick(View view) {
        viewClick(view);
    }

    public abstract void viewClick(View v);

    public abstract void initBasic();
}
