package com.example.akram.multiplefrag;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.akram.athkar.R;

/**
 * Created by Akram on 9/2/2016.
 */
public class MunuFragment extends Fragment {

    Fragment frag;
    android.support.v4.app.FragmentTransaction fragTransaction;

//constractor
    public MunuFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.menu_multi,container,false);

        frag=new AyatFragment();
        fragTransaction=getFragmentManager().beginTransaction().add(R.id.container,frag);
        fragTransaction.commit();

        Button btnAyat=(Button)view.findViewById(R.id.buttonAyat);

        Button btnDoaa=(Button)view.findViewById(R.id.buttonDoaa);



        btnAyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag=new AyatFragment();
                fragTransaction=getFragmentManager().beginTransaction().add(R.id.container,frag);
                fragTransaction.commit();


            }
        });
        btnDoaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag=new DoaaFragment();
                fragTransaction=getFragmentManager().beginTransaction().add(R.id.container,frag);
                fragTransaction.commit();

            }
        });


        return view;
    }
}

