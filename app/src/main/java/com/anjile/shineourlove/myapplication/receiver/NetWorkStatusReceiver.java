package com.anjile.shineourlove.myapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.anjile.shineourlove.myapplication.tools.NetWorkStatus;

/**
 * Created by shineourlove on 2016/9/28.
 * 监听网络连接状态变化
 */
public class NetWorkStatusReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION))
        {
            if (!NetWorkStatus.isNetworkConnected(context))
            {
                Toast.makeText(context,"请检查网络连接状态！", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
