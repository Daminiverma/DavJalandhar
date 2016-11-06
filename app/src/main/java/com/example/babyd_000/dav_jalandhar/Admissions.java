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
public class Admissions extends Fragment implements View.OnClickListener{


    public Admissions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admissions, container, false);
        view.findViewById(R.id.AdSrSec).setOnClickListener(this);
        view.findViewById(R.id.AdUG).setOnClickListener(this);
        view.findViewById(R.id.AdPG).setOnClickListener(this);
        view.findViewById(R.id.AdCourses).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.AdSrSec)
        {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Ad_Sr_Sec fragment = new Ad_Sr_Sec();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        else if (v.getId()==R.id.AdUG)
        {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Ad_UG fragment = new Ad_UG();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        else if (v.getId()==R.id.AdPG)
        {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Ad_PG fragment = new Ad_PG();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        else if (v.getId()==R.id.AdCourses)
        {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Ad_Co_Pro fragment = new Ad_Co_Pro();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
    }
}
