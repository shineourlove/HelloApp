package com.anjile.shineourlove.myapplication.tools;

import android.util.Log;

import com.anjile.shineourlove.myapplication.api.MyApi;
import com.anjile.shineourlove.myapplication.entity.Retrofit2EntrtyTest1;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/9/11.
 */

public class Retrofit2Request {

    public static void onCall(String userName, String repo) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyApi myApi = retrofit.create(MyApi.class);
        Call<List<Retrofit2EntrtyTest1>> call = myApi.detailsGetCall("square", "retrofit");
        /*call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String res = response.body().string();
                    Log.i("retrofit2_test", "onResponse: " + res);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });*/
//        call.enqueue(new Callback<List<Retrofit2EntrtyTest1>>() {
//            @Override
//            public void onResponse(Call<List<Retrofit2EntrtyTest1>> call, Response<List<Retrofit2EntrtyTest1>> response) {
//                List<Retrofit2EntrtyTest1> entrtyTest1s = response.body();
//                Log.i("retrofit2_test", "onResponse: " + entrtyTest1s.get(0).getAvatar_url());
//            }
//
//            @Override
//            public void onFailure(Call<List<Retrofit2EntrtyTest1>> call, Throwable t) {
//
//            }
//        });

        myApi.login("square", "retrofit").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Retrofit2EntrtyTest1>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Retrofit2EntrtyTest1> value) {
                        Log.i("retrofit2_test", "onResponse: " + value.get(0).getAvatar_url());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("retrofit2_test", "onError: 请求错误");
                    }

                    @Override
                    public void onComplete() {
                        Log.i("retrofit2_test", "onComplete: 请求完成");
                    }
                });
    }
}
