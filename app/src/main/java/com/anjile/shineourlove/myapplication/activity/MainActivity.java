package com.anjile.shineourlove.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anjile.shineourlove.myapplication.BaseActivity;
import com.anjile.shineourlove.myapplication.R;
import com.anjile.shineourlove.myapplication.tools.Retrofit2Request;
import com.anjile.shineourlove.myapplication.utils.ApplicationManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity {
    TextView txtHeadline;
    ImageView imgGlide1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationManager.getInstance().addActivity(this);
    }

    @Override
    public void initBasic() {
        setContentView(R.layout.activity_main);
        txtHeadline = findViewById(R.id.txt_main_headline);
        imgGlide1 = findViewById(R.id.img_main_glide_1);
        initTest();
    }

    private void initTest() {
        Retrofit2Request.onCall("", "");
        txtHeadline.setText("你好世界！");
        Glide.with(MainActivity.this)
                .load("https://i10.hoopchina.com.cn/hupuapp/bbs/344/25658344/thread_25658344_20170912113604_s_107719_h_518px_w_690px463470372.png")
                .transition(new DrawableTransitionOptions().crossFade(500))
                .apply(new RequestOptions().placeholder(R.drawable.test1))
                .into(imgGlide1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventTest1(String s) {
    }

    @Override
    public void viewClick(View v) {

    }


}
