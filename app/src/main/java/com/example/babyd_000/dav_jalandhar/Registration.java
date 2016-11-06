package com.example.babyd_000.dav_jalandhar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    SharedPreferences.Editor editor;
    String Clas;
    String year;
    int flag=1;
    RadioButton R1;
    RadioButton R2;
    RadioButton R3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        year= "";
        String Class = pref.getString("Class", "null");
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        R1 = (RadioButton) findViewById(R.id.Iyear);
        R2 = (RadioButton) findViewById(R.id.IIyear);
        R3 = (RadioButton) findViewById(R.id.IIIyear);

        R1.setEnabled(false);
        R2.setEnabled(false);
        R3.setEnabled(false);
        R1.setVisibility(View.GONE);
        R2.setVisibility(View.GONE);
        R3.setVisibility(View.GONE);

        Spinner sclass = (Spinner) findViewById(R.id.spinner);
        sclass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Clas = parent.getSelectedItem().toString();
                if (Clas.startsWith("B")) {
                    flag =0;
                    R1.setVisibility(View.VISIBLE);
                    R1.setEnabled(true);
                    R2.setVisibility(View.VISIBLE);
                    R2.setEnabled(true);
                    R3.setVisibility(View.VISIBLE);
                    R3.setEnabled(true);
                }
                else if (Clas.startsWith("M")) {
                    flag=0;
                    R1.setVisibility(View.VISIBLE);
                    R1.setEnabled(true);
                    R2.setVisibility(View.VISIBLE);
                    R2.setEnabled(true);
                    R3.setVisibility(View.GONE);
                    R3.setEnabled(false);
                }
                else{
                    flag=1;
                    year = "";
                    R1.setEnabled(false);
                    R2.setEnabled(false);
                    R3.setEnabled(false);
                    R1.setVisibility(View.GONE);
                    R2.setVisibility(View.GONE);
                    R3.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        R1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=1;
                year = " I";
            }
        });
        R2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=1;
                year = " II";
            }
        });
        R3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=1;
                year = " III";
            }
        });


        final Button Register = (Button) findViewById(R.id.Register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag==1)
                {
                    editor.putString("Class", Clas);
                    editor.commit();
                    editor.putString("Year",year);
                    editor.commit();
                    BackgroundRegister backgroundRegister= new BackgroundRegister(Registration.this);
                    backgroundRegister.execute();
                    String tru = "true";
                    editor.putString("chk",tru);
                    editor.commit();
                }
                else
                {
                    Toast.makeText(Registration.this, "Please select your corrosponding year.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Registration.super.onBackPressed();
    }
}
