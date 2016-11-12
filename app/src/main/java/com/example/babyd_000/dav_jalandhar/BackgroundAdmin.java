package com.example.babyd_000.dav_jalandhar;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by babyd_000 on 27-03-2016.
 */
public class BackgroundAdmin extends AsyncTask<String, Void, String> {
    Context context;

    BackgroundAdmin(Context ctx)           //Constructor
    {
        //context = ctx;                  //assign contex to local context
        this.context = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String res = params[0];
        if ((!res.equals("MSG")) && (!res.equals("updt"))) {
            try {
                String dte = params[1];
                String title = params[2];
                String desc = params[3];

                OkHttpClient client = new OkHttpClient();
                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("res", res)
                        .addFormDataPart("dte", dte)
                        .addFormDataPart("title", title)
                        .addFormDataPart("desc", desc)
                        .build();

                Request request = new Request.Builder()
                        .url("http://dav-college.netau.net/Insert.php")
                        .post(body)
                        .build();

                Response response = client.newCall(request).execute();
                String result = response.body().string();
                return result;

            } catch (MalformedURLException e) {
                return "No";
            } catch (IOException e) {
                return "No";
            }

        }
        if (res.equals("MSG")) {
            String msg = params[1];
            String alias = params[2];
            try {

                OkHttpClient client = new OkHttpClient();
                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("msg", msg)
                        .addFormDataPart("alias", alias)
                        .build();

                Request request = new Request.Builder()
                        .url("http://dav-college.netau.net/Notification.php")
                        .post(body)
                        .build();

                Response response = client.newCall(request).execute();
                String result = response.body().string();
                return result;

            } catch (MalformedURLException e) {
                return "No";
            } catch (IOException e) {
                return "No";
            }
        }
        if (res.equals("updt")) {
            String tab = params[1];
            String tit1 = params[2];
            String tit2 = params[3];
            String desc = params[4];
            try {

                OkHttpClient client = new OkHttpClient();
                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("tab", tab)
                        .addFormDataPart("tit1", tit1)
                        .addFormDataPart("tit2", tit2)
                        .addFormDataPart("desc", desc)
                        .build();

                Request request = new Request.Builder()
                        .url("http://dav-college.netau.net/Update.php")
                        .post(body)
                        .build();

                Response response = client.newCall(request).execute();
                String result = response.body().string();
                return result;

            } catch (MalformedURLException e) {
                return "No";
            } catch (IOException e) {
                return "No";
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
