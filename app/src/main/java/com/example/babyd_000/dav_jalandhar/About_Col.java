package com.example.babyd_000.dav_jalandhar;


import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_Col extends Fragment implements View.OnClickListener {
    SharedPreferences.Editor editor;
    Context ctx;

    public About_Col() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about__col, container, false);
        ctx = inflater.getContext();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = pref.edit();

        view.findViewById(R.id.RMPrinciples).setOnClickListener(this);
        view.findViewById(R.id.RMPrinciples);
        view.findViewById(R.id.RMColgEmblm).setOnClickListener(this);
        view.findViewById(R.id.RMColgEmblm);
        view.findViewById(R.id.RMPrinciDesk).setOnClickListener(this);
        view.findViewById(R.id.RMPrinciDesk);

        return view;
    }

    @Override
    public void onClick(View v) {
        String res = null;
        if (v.getId() == R.id.RMPrinciples) {
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
                editor.putString("URL", "http://www.davjalandhar.com/index.php/aboutdav/principles-of-arya-samaj");
                editor.commit();
            }
        } else if (v.getId() == R.id.RMColgEmblm) {
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
                editor.putString("URL", "http://www.davjalandhar.com/index.php/aboutdav/collegeemblem");
                editor.commit();
            }
        } else if (v.getId() == R.id.RMPrinciDesk) {
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
                editor.putString("URL", "http://www.davjalandhar.com/index.php/aboutdav/principal-desk");
                editor.commit();
            }
        }
        if (!res.equals("no")) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            MyWebView fragment = new MyWebView();
            fragmentTransaction.add(R.id.container, fragment);
            fragmentTransaction.commit();
        }
    }
}
