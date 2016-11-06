package com.example.babyd_000.dav_jalandhar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pushbots.push.Pushbots;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Settings extends AppCompatActivity {
    SharedPreferences.Editor editor;

    TextView TVClass;
    TableLayout tab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TVClass = (TextView) findViewById(R.id.TVSclass);
        tab = (TableLayout) findViewById(R.id.ChangeRoll);

        String Class = pref.getString("Class", "Not Found");
        String Year = pref.getString("Year", " ");

        TVClass.setText(Class + Year);

        tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res = null;
                try {
                    res = new BackgroundCheck(Settings.this).execute().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                if (res.equals("no")) {
                    Toast.makeText(Settings.this, "Internet Connection is Not Available", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(Settings.this, Registration.class));
                    finish();
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Settings.this, HomeMainActivity.class));
        finish();
    }
}
