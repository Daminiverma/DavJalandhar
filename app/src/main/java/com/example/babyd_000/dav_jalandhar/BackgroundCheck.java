package com.example.babyd_000.dav_jalandhar;

import android.app.DownloadManager;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by babyd_000 on 23-05-2016.
 */
public class BackgroundCheck extends AsyncTask<String, Void, String> {
    String conres;

    public BackgroundCheck(Context ctx) {
    }

    @Override
    protected String doInBackground(String... params) {
        try {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://dav-college.netau.net/connchk.php")
                    .build();

            Response response = client.newCall(request).execute();
            conres = response.body().string();


        } catch (MalformedURLException e) {
            conres = "no";
            // e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            conres = "no";
            //e.printStackTrace();
        } catch (IOException e) {
            conres = "no";
            //e.printStackTrace();
        }
        return conres;
    }
}
