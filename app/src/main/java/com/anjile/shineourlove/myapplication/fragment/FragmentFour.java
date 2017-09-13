package com.anjile.shineourlove.myapplication.fragment;

import android.os.Bundle;

import com.anjile.shineourlove.myapplication.entity.Constants;


public class FragmentFour extends BaseFragment {

    public static FragmentFour newInstance(String s){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS,s);
        FragmentFour fragment = new FragmentFour();
        fragment.setArguments(bundle);
        return fragment;
    }

}
