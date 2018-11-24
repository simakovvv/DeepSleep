package com.harman.ds;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class Mask extends Fragment  {


    Button relSeans;
    Button sleepTrack;
    MaskTrackSleepFragment maskT;
    MaskRelaxFragment maskR;
    FragmentTransaction tran;


    final static String TAG_1 = "FRAGMENT_1";
    final static String TAG_2 = "FRAGMENT_2";

    public Mask() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_mask, container, false);

        maskT = new MaskTrackSleepFragment();
        maskR = new MaskRelaxFragment();
        setMaskR();
        relSeans = (Button)rootView.findViewById(R.id.relax);
        sleepTrack = (Button)rootView.findViewById(R.id.sleep);
        sleepTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMaskT();
            }
        });
        relSeans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMaskR();
            }
        });
        return rootView;
    }

    private void setMaskR() {
        tran = getChildFragmentManager().beginTransaction();
        tran.replace(R.id.fragment, maskR);
        tran.commit();
    }
    private void setMaskT() {
        tran = getChildFragmentManager().beginTransaction();
        tran.replace(R.id.fragment, maskT);
        tran.commit();
    }

    public void onClick(View view) {
        Toast.makeText(getActivity(), "Вы нажали на кнопку",
                Toast.LENGTH_SHORT).show();
    }


}
