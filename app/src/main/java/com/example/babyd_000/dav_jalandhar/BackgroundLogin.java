package com.example.babyd_000.dav_jalandhar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
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

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by hp on 01-May-16.
 */
public class BackgroundLogin extends AsyncTask<String, Void, String> {
    ProgressDialog progressDialog;
    Context context;
    String login_url;
    String conn_url;
    String user_name;


    BackgroundLogin(Context ctx)           //Constructor
    {
        this.context = ctx;
    }


    @Override
    protected String doInBackground(String... params) {
        String conres;
        login_url = "http://dav-college.netau.net/login.php";
        conn_url = "http://dav-college.netau.net/connchk.php";
        publishProgress();
        synchronized (this) {

            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(conn_url)
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
            if (conres.contains("yes")) {
                try {
                    user_name = params[0];
                    String password = params[1];
                    String result = "";
                    OkHttpClient client = new OkHttpClient();

                    RequestBody body = new MultipartBody.Builder()
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("user_name",user_name)
                            .addFormDataPart("password",password)
                            .build();

                    Request request = new Request.Builder()
                            .url(login_url)
                            .post(body)
                            .build();

                    Response response = client.newCall(request).execute();
                    result = response.body().string();

                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                return "Internet Connection is not available...";
            }
        }
        return "no";
    }


    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Logging in");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String aVoid) {
        progressDialog.hide();
        if (aVoid.equals("Internet Connection is not available...")) {
            Toast.makeText(context, "" + aVoid, Toast.LENGTH_SHORT).show();
        } else if (aVoid.contains("login success !!!!! Welcome user")) {
            context.startActivity(new Intent(context, Admin.class));
            Toast.makeText(context, "Welcome " + user_name, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Login Not Success", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
