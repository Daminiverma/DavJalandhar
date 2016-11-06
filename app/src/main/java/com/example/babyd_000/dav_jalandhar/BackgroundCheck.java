package com.example.babyd_000.dav_jalandhar;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by babyd_000 on 23-05-2016.
 */
public class BackgroundCheck extends AsyncTask<String, Void, String> {
    String conn_url;
    String conres;

    public BackgroundCheck(Context ctx) {
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            conn_url = "http://dav-college.netau.net/connchk.php";
            URL url = new URL(conn_url);
            ///////////////////
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            ///////////////////
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            String result = "";
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            //////////////////
            httpURLConnection.disconnect();
            conres = result;
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
