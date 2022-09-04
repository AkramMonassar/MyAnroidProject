package com.example.akram.multiplefrag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.akram.athkar.R;

/**
 * Created by Akram on 9/2/2016.
 */
public class DoaaFragment extends Fragment {
    public DoaaFragment(){}


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_multi_doaa,container,false);
         //View rootView=inflater.inflate(R.layout.fragment_multi_doaa,null);

        return rootView;
    }
}
