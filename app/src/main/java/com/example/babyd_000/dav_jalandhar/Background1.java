package com.example.babyd_000.dav_jalandhar;

import android.content.Context;
import android.os.AsyncTask;

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
 * Created by babyd_000 on 06-03-2016.
 */
public class Background1 extends AsyncTask<String, Void, String> {

    Context context;

    Background1(Context ctx)           //Constructor
    {
        //context = ctx;                  //assign contex to local context
        this.context = ctx;
    }

    String PlacementDesc_url;
    String ReleasesDesc_url;
    String NoticeDesc_url;
    String WorshopDesc_url;
    String login_url;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String result = "";
        String type = params[0];
        ReleasesDesc_url = "http://dav-college.netau.net/ReleasesDesc.php";
        NoticeDesc_url = "http://dav-college.netau.net/NoticeDesc.php";
        PlacementDesc_url = "http://dav-college.netau.net/PlacementDesc.php";
        WorshopDesc_url = "http://dav-college.netau.net/WorkshopDesc.php";
        login_url = "http://dav-college.netau.net/login.php";
        if (type.equals("Releases")) {
            try {
                String title = params[1];

                OkHttpClient client = new OkHttpClient();
                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("title", title)
                        .build();

                Request request = new Request.Builder()
                        .url(ReleasesDesc_url)
                        .post(body)
                        .build();

                Response response = client.newCall(request).execute();
                result = response.body().string();
                return result;

            } catch (MalformedURLException e) {
                return "No";
            } catch (IOException e) {
                return "No";
            }
        } else if (type.equals("Notice")) {

            try {
                String title = params[1];

                OkHttpClient client = new OkHttpClient();
                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("title", title)
                        .build();

                Request request = new Request.Builder()
                        .url(NoticeDesc_url)
                        .post(body)
                        .build();

                Response response = client.newCall(request).execute();
                result = response.body().string();
                return result;


            } catch (MalformedURLException e) {
                return "No";
            } catch (IOException e) {
                return "No";
            }
        } else if (type.equals("Placements")) {
            try {
                String title = params[1];

                OkHttpClient client = new OkHttpClient();
                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("title", title)
                        .build();

                Request request = new Request.Builder()
                        .url(PlacementDesc_url)
                        .post(body)
                        .build();

                Response response = client.newCall(request).execute();
                result = response.body().string();
                return result;


            } catch (MalformedURLException e) {
                return "No";
            } catch (IOException e) {
                return "No";
            }
        } else if (type.equals("Workshop")) {
            try {
                String title = params[1];

                OkHttpClient client = new OkHttpClient();
                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("title", title)
                        .build();

                Request request = new Request.Builder()
                        .url(WorshopDesc_url)
                        .post(body)
                        .build();

                Response response = client.newCall(request).execute();
                result = response.body().string();
                return result;


            } catch (MalformedURLException e) {
                return "No";
            } catch (IOException e) {
                return "No";
            }
        } else if (type.equals("login")) {
            try {
                String user_name = params[1];
                String password = params[2];
                MultipartBody body = new MultipartBody.Builder()
                        .addFormDataPart(user_name, password)
                        .build();


                OkHttpClient client = new OkHttpClient();
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
        }
        return null;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}