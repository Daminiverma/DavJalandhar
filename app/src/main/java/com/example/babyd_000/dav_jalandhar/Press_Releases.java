package com.example.babyd_000.dav_jalandhar;


import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
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
public class Press_Releases extends Fragment implements View.OnClickListener {
    SharedPreferences.Editor editor;
    Context ctx;
    TextView pr1, pr2, pr3, pr4, pr5, pr6;

    public Press_Releases() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_press__releases, container, false);
        ctx = inflater.getContext();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = pref.edit();

        pr1 = (TextView) view.findViewById(R.id.pr1);
        pr1.setOnClickListener(this);
        pr2 = (TextView) view.findViewById(R.id.pr2);
        pr2.setOnClickListener(this);
        pr3 = (TextView) view.findViewById(R.id.pr3);
        pr3.setOnClickListener(this);
        pr4 = (TextView) view.findViewById(R.id.pr4);
        pr4.setOnClickListener(this);
        pr5 = (TextView) view.findViewById(R.id.pr5);
        pr5.setOnClickListener(this);
        pr6 = (TextView) view.findViewById(R.id.pr6);
        pr6.setOnClickListener(this);

        String result = pref.getString("PressReleases", "nil");
        String ar[];
        ar = result.split("</b>>");
        ar = result.split("<br><br>");
        pr1.setText(ar[0]);
        pr2.setText(ar[1]);
        pr3.setText(ar[2]);
        pr4.setText(ar[3]);
        pr5.setText(ar[4]);
        pr6.setText(ar[5]);

        return view;
    }

    @Override
    public void onClick(View v) {
        String conres = "";
        try {
            conres = new BackgroundCheck(ctx).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (conres.contains("yes")) {
            String type = "Releases";
            editor.putString("Type", type);
            editor.commit();

            if (v.getId() == R.id.pr1) {

                editor.putString("Title", (String) pr1.getText());
                editor.commit();

            } else if (v.getId() == R.id.pr2) {
                editor.putString("Title", (String) pr2.getText());
                editor.commit();

            } else if (v.getId() == R.id.pr3) {
                editor.putString("Title", (String) pr3.getText());
                editor.commit();

            } else if (v.getId() == R.id.pr4) {
                editor.putString("Title", (String) pr4.getText());
                editor.commit();

            } else if (v.getId() == R.id.pr5) {
                editor.putString("Title", (String) pr5.getText());
                editor.commit();

            } else if (v.getId() == R.id.pr6) {
                editor.putString("Title", (String) pr6.getText());
                editor.commit();

            }
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Description fragment = new Description();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        else
        {
            Toast.makeText(ctx, "Internet Connection not Available", Toast.LENGTH_SHORT).show();
        }
    }
}
