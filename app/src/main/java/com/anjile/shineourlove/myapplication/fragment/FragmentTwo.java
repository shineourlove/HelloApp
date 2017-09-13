package com.anjile.shineourlove.myapplication.fragment;

import android.os.Bundle;

import com.anjile.shineourlove.myapplication.entity.Constants;

public class FragmentTwo extends BaseFragment {

    public static FragmentTwo newInstance(String s){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS,s);
        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(bundle);
        return fragment;
    }

}
