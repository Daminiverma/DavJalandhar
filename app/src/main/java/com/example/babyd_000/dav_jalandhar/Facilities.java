package com.example.babyd_000.dav_jalandhar;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Facilities extends Fragment implements View.OnClickListener {


    public Facilities() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_facilities, container, false);
        view.findViewById(R.id.library).setOnClickListener(this);
        view.findViewById(R.id.cafetaria).setOnClickListener(this);
        view.findViewById(R.id.hospital).setOnClickListener(this);
        view.findViewById(R.id.hostel).setOnClickListener(this);
        view.findViewById(R.id.sports).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.library) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fac_Library fragment = new Fac_Library();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if (v.getId() == R.id.cafetaria) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fac_Cafe fragment = new Fac_Cafe();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if (v.getId() == R.id.hospital) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fac_Hospital fragment = new Fac_Hospital();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if (v.getId() == R.id.hostel) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fac_Hostel fragment = new Fac_Hostel();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if (v.getId() == R.id.sports) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fac_Sports fragment = new Fac_Sports();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }

    }
}