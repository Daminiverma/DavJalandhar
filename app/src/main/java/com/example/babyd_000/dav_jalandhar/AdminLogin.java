package com.example.babyd_000.dav_jalandhar;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdminLogin extends Fragment implements View.OnClickListener {
    static Context ctx;
    SharedPreferences.Editor editor;
    Button log;
    EditText UsernameEt, PasswordEt;

    public AdminLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ctx = inflater.getContext();

        View view = inflater.inflate(R.layout.fragment_admin_login, container, false);
        log = (Button) view.findViewById(R.id.log);
        log.setOnClickListener(this);
        UsernameEt = (EditText) view.findViewById(R.id.userenter);
        PasswordEt = (EditText) view.findViewById(R.id.passenter);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.log) {
            String username = UsernameEt.getText().toString();
            String password = PasswordEt.getText().toString();
            BackgroundLogin background = new BackgroundLogin(ctx);
            background.execute(username,password);
            UsernameEt.setText("");
            PasswordEt.setText("");
        }
    }
}
