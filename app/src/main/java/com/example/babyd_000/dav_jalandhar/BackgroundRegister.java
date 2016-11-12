package com.example.babyd_000.dav_jalandhar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.pushbots.push.Pushbots;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hp on 08-May-16.
 */
public class BackgroundRegister extends AsyncTask<String,Void,String> {
    ProgressDialog progressDialog;
    Context context;
    SharedPreferences.Editor editor;
    SharedPreferences pref;
    BackgroundRegister(Context ctx)
    {
        this.context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();

        String conres;
        publishProgress();
        synchronized (this)
        {
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://dav-college.netau.net/connchk.php")
                        .build();

                Response response = client.newCall(request).execute();
                conres = response.body().string();

            } catch (MalformedURLException e) {
                conres = "no";
            } catch (UnsupportedEncodingException e) {
                conres = "no";
            } catch (IOException e) {
                conres = "no";
            }
        }
        return conres;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Registering your Device");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String aVoid) {
        progressDialog.hide();
        progressDialog.cancel();
        progressDialog.dismiss();
        if (aVoid.contains("yes"))
        {
            String Clas = pref.getString("Class","Not Selected");
            String Yr = pref.getString("Year","");
            Pushbots.sharedInstance().setAlias(Clas+Yr);
            editor.putString("ref","0");
            editor.commit();
            Background background = new Background(context);
            background.execute();
        }
        else
        {
            editor.putString("Class", "null");
            editor.commit();
            Toast.makeText(context, "Ineternet Connection is not available...", Toast.LENGTH_SHORT).show();
            Toast.makeText(context, "Please Try Again, with proper Internet Connection.", Toast.LENGTH_SHORT).show();
        }
    }
}
