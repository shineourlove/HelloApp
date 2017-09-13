package com.anjile.shineourlove.myapplication.fragment;

import android.os.Bundle;

import com.anjile.shineourlove.myapplication.entity.Constants;


public class FragmentOne extends BaseFragment {
    public static FragmentOne newInstance(String s){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS,s);
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(bundle);
        return fragment;
    }
}
