package com.anjile.shineourlove.myapplication.utils;

import android.app.Activity;
import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;

import com.anjile.shineourlove.myapplication.receiver.NetWorkStatusReceiver;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by CP on 2016/9/25.
 * Activity管理类
 */
public class ApplicationManager extends Application {
    private List<Activity> mList = new LinkedList<>();   //创建一个List集合  存储Activity
    public static ApplicationManager applicationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("application", ">>>>>>>>>>>>>>>应用程序启动时调用");
        NetWorkStatusReceiver statusReceiver = new NetWorkStatusReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(statusReceiver, intentFilter);
    }

    public static ApplicationManager getInstance() {
        if (applicationManager == null) {
            applicationManager = new ApplicationManager();
        }
        return applicationManager;
    }

    /**
     * 添加Activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    /**
     * 关闭所有Activity
     */
    public void exitAllActivity() {
        try {
            for (Activity activity : mList) {
                if (activity != null) {
                    activity.finish();   //结束activity
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        } finally {
            System.exit(0);
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();   //杀进程
    }
}
