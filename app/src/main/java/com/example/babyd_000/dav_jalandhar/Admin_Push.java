package com.example.babyd_000.dav_jalandhar;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Admin_Push extends Fragment implements View.OnClickListener {
    static Context ctx;
    EditText msgbox;
    String masg;
    String Class;
    String temp;
    Spinner sclass;
    RadioButton RB1, RB2, RB3;
    int flag = 1;

    public Admin_Push() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.admin__push, container, false);
        ctx = inflater.getContext();
        msgbox = (EditText) view.findViewById(R.id.msg);
        sclass = (Spinner) view.findViewById(R.id.NotiClass);
        view.findViewById(R.id.rb1).setOnClickListener(this);
        RB1 = (RadioButton) view.findViewById(R.id.rb1);
        view.findViewById(R.id.rb2).setOnClickListener(this);
        RB2 = (RadioButton) view.findViewById(R.id.rb2);
        view.findViewById(R.id.rb3).setOnClickListener(this);
        RB3 = (RadioButton) view.findViewById(R.id.rb3);
        RB1.setEnabled(false);
        RB1.setVisibility(View.GONE);
        RB2.setEnabled(false);
        RB2.setVisibility(View.GONE);
        RB3.setEnabled(false);
        RB3.setVisibility(View.GONE);
        sclass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Class = parent.getSelectedItem().toString();
                if (Class.startsWith("B")) {
                    flag = 0;
                    RB1.setEnabled(true);
                    RB1.setVisibility(View.VISIBLE);
                    RB2.setEnabled(true);
                    RB2.setVisibility(View.VISIBLE);
                    RB3.setEnabled(true);
                    RB3.setVisibility(View.VISIBLE);
                } else if (Class.startsWith("M")) {
                    flag = 0;
                    RB1.setEnabled(true);
                    RB1.setVisibility(View.VISIBLE);
                    RB2.setEnabled(true);
                    RB2.setVisibility(View.VISIBLE);
                    RB3.setEnabled(false);
                    RB3.setVisibility(View.GONE);
                } else {
                    flag = 1;
                    if (Class.equals("All")) {
                        Class = "";
                    }
                    RB1.setEnabled(false);
                    RB1.setVisibility(View.GONE);
                    RB2.setEnabled(false);
                    RB2.setVisibility(View.GONE);
                    RB3.setEnabled(false);
                    RB3.setVisibility(View.GONE);
                }
                temp = Class;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String conres = "";
                masg = msgbox.getText().toString();
                if (flag != 1) {
                    Toast.makeText(ctx, "Please select your corrosponding year.", Toast.LENGTH_SHORT).show();
                } else {
                    if (masg.equals("") || masg.equals(null)) {
                        Toast.makeText(ctx, "Please enter the message.", Toast.LENGTH_SHORT).show();
                    } else {

                        try {
                            conres = new BackgroundCheck(ctx).execute().get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        if (conres.contains("yes")) {
                            String result = null;
                            try {
                                result = new BackgroundAdmin(ctx).execute("MSG", masg, Class).get();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                            if (result.contains(msgbox.getText().toString())) {
                                Toast.makeText(ctx, "" + masg + " sent successfully to " + Class, Toast.LENGTH_SHORT).show();
                                msgbox.setText("");
                            }
                        } else {
                            Toast.makeText(ctx, "Internet Connection not available", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rb1) {
            flag = 1;
            temp = Class + " I";
        } else if (v.getId() == R.id.rb2) {
            flag = 1;
            temp = Class + " II";
        } else if (v.getId() == R.id.rb3) {
            flag = 1;
            temp = Class + " III";
        }
        Class = temp;
        //Toast.makeText(ctx, temp, Toast.LENGTH_SHORT).show();
    }
}
