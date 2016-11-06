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
public class Notice_Board extends Fragment implements View.OnClickListener {
    SharedPreferences.Editor editor;
    static Context ctx;
    TextView nb1, nb2, nb3, nb4, nb5, nb6;


    public Notice_Board() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice__board, container, false);
        ctx = inflater.getContext();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = pref.edit();

        nb1 = (TextView) view.findViewById(R.id.nb1);
        nb1.setOnClickListener(this);
        nb2 = (TextView) view.findViewById(R.id.nb2);
        nb2.setOnClickListener(this);
        nb3 = (TextView) view.findViewById(R.id.nb3);
        nb3.setOnClickListener(this);
        nb4 = (TextView) view.findViewById(R.id.nb4);
        nb4.setOnClickListener(this);
        nb5 = (TextView) view.findViewById(R.id.nb5);
        nb5.setOnClickListener(this);
        nb6 = (TextView) view.findViewById(R.id.nb6);
        nb6.setOnClickListener(this);

        String result = pref.getString("NoticeBoard", "nil");
        String ar[];
        ar = result.split("</b>>");
        ar = result.split("<br><br>");
        nb1.setText(ar[0]);
        nb2.setText(ar[1]);
        nb3.setText(ar[2]);
        nb4.setText(ar[3]);
        nb5.setText(ar[4]);
        nb6.setText(ar[5]);

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
            String type = "Notice";
            editor.putString("Type", type);
            editor.commit();

            if (v.getId() == R.id.nb1) {

                editor.putString("Title", (String) nb1.getText());
                editor.commit();

            } else if (v.getId() == R.id.nb2) {
                editor.putString("Title", (String) nb2.getText());
                editor.commit();

            } else if (v.getId() == R.id.nb3) {
                editor.putString("Title", (String) nb3.getText());
                editor.commit();

            } else if (v.getId() == R.id.nb4) {
                editor.putString("Title", (String) nb4.getText());
                editor.commit();

            } else if (v.getId() == R.id.nb5) {
                editor.putString("Title", (String) nb5.getText());
                editor.commit();

            } else if (v.getId() == R.id.nb6) {
                editor.putString("Title", (String) nb6.getText());
                editor.commit();

            }

            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Description fragment = new Description();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(Notice_Board.ctx, "Internet Connection is not available...", Toast.LENGTH_SHORT).show();
        }
    }
}
