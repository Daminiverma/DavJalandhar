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
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fac_Cafe extends Fragment implements View.OnClickListener {

    Context ctx;
    SharedPreferences.Editor editor;

    public Fac_Cafe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fac__cafe, container, false);
        ctx=inflater.getContext();
        TextView rm=(TextView) view.findViewById(R.id.cafelink);
        rm.setOnClickListener(this);
        //view.findViewById(R.id.cafelink).setOnClickListener(this);

        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(ctx);
        editor=pref.edit();
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cafelink) {
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
                editor.putString("URL", "http://www.davjalandhar.com/index.php/facilities/cafeteria");
                editor.commit();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyWebView fragment = new MyWebView();
                fragmentTransaction.add(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        }
    }
}