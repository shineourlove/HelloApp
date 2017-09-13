package com.anjile.shineourlove.myapplication.fragment;

import android.os.Bundle;

import com.anjile.shineourlove.myapplication.entity.Constants;

public class FragmentThree extends BaseFragment {

    public static FragmentThree newInstance(String s){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS,s);
        FragmentThree fragment = new FragmentThree();
        fragment.setArguments(bundle);
        return fragment;
    }
}
