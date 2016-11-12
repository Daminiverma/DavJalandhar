package com.example.babyd_000.dav_jalandhar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.widget.Toast;

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
 * Created by babyd_000 on 26-02-2016.
 */
public class Background extends AsyncTask<String, Void, String> {
    ProgressDialog progressDialog;
    Context context;
    SharedPreferences.Editor editor;
    SharedPreferences pref;

    Background(Context ctx)           //Constructor
    {
        //context = ctx;                  //assign contex to local context or
        this.context = ctx;
    }

    //  URL's
    String ReleasesTitle_url;
    String NoticeTitle_url;
    String PlacementTitle_url;
    String WorkshopTitle_url;
    String conn_url;
    String Marquee_url;

    @Override
    protected String doInBackground(String... params) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();

        publishProgress();
        synchronized (this) {
            String conres;
            String result;
            Marquee_url = "http://dav-college.netau.net/MarqueeTitle.php";
            ReleasesTitle_url = "http://dav-college.netau.net/ReleasesTitle.php";
            NoticeTitle_url = "http://dav-college.netau.net/NoticeTitle.php";
            PlacementTitle_url = "http://dav-college.netau.net/PlacementTitle.php";
            WorkshopTitle_url = "http://dav-college.netau.net/WorkshopTitle.php";
            conn_url = "http://dav-college.netau.net/connchk.php";

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

                    String result1 = "";
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(Marquee_url)
                            .build();

                    Response response = client.newCall(request).execute();
                    result1 = response.body().string();

                    editor.putString("Marquee", result1);
                    editor.commit();
                } catch (MalformedURLException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(ReleasesTitle_url)
                            .build();

                    Response response = client.newCall(request).execute();
                    result = response.body().string();
                    result = result.substring(1);

                    editor.putString("PressReleases", result);
                    editor.commit();
                    //return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(NoticeTitle_url)
                            .build();

                    Response response = client.newCall(request).execute();
                    result = response.body().string();
                    result = result.substring(1);

                    editor.putString("NoticeBoard", result);
                    editor.commit();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(PlacementTitle_url)
                            .build();

                    Response response = client.newCall(request).execute();
                    result = response.body().string();
                    result = result.substring(1);

                    editor.putString("Placements", result);
                    editor.commit();
                    //return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(WorkshopTitle_url)
                            .build();

                    Response response = client.newCall(request).execute();
                    result = response.body().string();
                    result = result.substring(1);

                    editor.putString("Workshop", result);
                    editor.commit();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                return "no";
            }
        }
        return "yes";
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Refreshing");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String aVoid) {
        progressDialog.hide();
        progressDialog.cancel();
        progressDialog.dismiss();
        if (aVoid.equals("no")) {
            Toast.makeText(context, "Internet Connection is not available...", Toast.LENGTH_SHORT).show();
        } else if (aVoid.equals("yes")) {
            context.startActivity(new Intent(context, HomeMainActivity.class));
            String chek = pref.getString("chk", "false");
            if (chek.equals("true")) {
                ((Registration) context).finish();
                String fals = "false";
                editor.putString("chk", fals);
                editor.commit();
            } else {
                ((HomeMainActivity) context).finish();
            }
            Toast.makeText(context, "Refreshed Successfully...", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
