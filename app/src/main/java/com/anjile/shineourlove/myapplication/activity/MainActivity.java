package com.anjile.shineourlove.myapplication.activity;

import android.os.Bundle;
import android.view.View;

import com.anjile.shineourlove.myapplication.BaseActivity;
import com.anjile.shineourlove.myapplication.R;
import com.anjile.shineourlove.myapplication.tools.Retrofit2Request;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBasic();
    }

    public void initBasic() {
        Retrofit2Request.onCall("", "");
    }

    @Override
    public void viewClick(View v) {

    }
}
