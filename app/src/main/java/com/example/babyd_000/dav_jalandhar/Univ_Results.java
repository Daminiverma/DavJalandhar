package com.example.babyd_000.dav_jalandhar;


import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Univ_Results extends Fragment implements View.OnClickListener{

    SharedPreferences.Editor editor;
    Context ctx;
    public Univ_Results() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_univ__results, container , false);
        ctx=inflater.getContext();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = pref.edit();

        //Initiaizing On Click Listeners
        view.findViewById(R.id.SemSys).setOnClickListener(this);
        view.findViewById(R.id.AnnualUG).setOnClickListener(this);
        view.findViewById(R.id.AnnualPG).setOnClickListener(this);
        view.findViewById(R.id.Diplomas).setOnClickListener(this);
        view.findViewById(R.id.SemUG).setOnClickListener(this);
        view.findViewById(R.id.SemPG).setOnClickListener(this);




        return view;
    }

    @Override
    public void onClick(View v) {
        String res = null;
        try {
            res = new BackgroundCheck(ctx).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (res.equals("no")) {
            Toast.makeText(ctx, "Internet Connection is Not Available", Toast.LENGTH_SHORT).show();
        } else {

            if (v.getId() == R.id.SemSys) {
                editor.putString("URL", "http://result.gndu.ac.in/results_exam/newsempg.asp");
                editor.commit();
            } else if (v.getId() == R.id.AnnualUG) {
                editor.putString("URL", "http://result.gndu.ac.in/results/annualug.asp");
                editor.commit();
            } else if (v.getId() == R.id.AnnualPG) {
                editor.putString("URL", "http://result.gndu.ac.in/results/annualpg.asp");
                editor.commit();
            } else if (v.getId() == R.id.Diplomas) {
                editor.putString("URL", "http://result.gndu.ac.in/results/diploma.asp");
                editor.commit();
            } else if (v.getId() == R.id.SemUG) {
                editor.putString("URL", "http://result.gndu.ac.in/results/semesterug.asp");
                editor.commit();
            } else if (v.getId() == R.id.SemPG) {
                editor.putString("URL", "http://result.gndu.ac.in/results/semesterpg.asp");
                editor.commit();
            }
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            MyWebView fragment = new MyWebView();
            fragmentTransaction.add(R.id.container, fragment);
            fragmentTransaction.commit();

        }
    }
}
