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
//            String type = params[0];
            Marquee_url = "http://dav-college.netau.net/MarqueeTitle.php";
            ReleasesTitle_url = "http://dav-college.netau.net/ReleasesTitle.php";
            NoticeTitle_url = "http://dav-college.netau.net/NoticeTitle.php";
            PlacementTitle_url = "http://dav-college.netau.net/PlacementTitle.php";
            WorkshopTitle_url = "http://dav-college.netau.net/WorkshopTitle.php";
            conn_url = "http://dav-college.netau.net/connchk.php";
            //if (type.equals("Conn")) {
            try {
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
            //} else if (type.equals("MarqueeTitle")) {
            if (conres.contains("yes")) {

                try {
                    URL url = new URL(Marquee_url);
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
                    editor.putString("Marquee", result);
                    editor.commit();

                    //return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                //} else if (type.equals("TitleReleases")) {
                try {
                    URL url = new URL(ReleasesTitle_url);
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
                    result = result.substring(1);
                    editor.putString("PressReleases", result);
                    editor.commit();
                    //return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                //} else if (type == "TitleNotice") {
                try {
                    URL url = new URL(NoticeTitle_url);
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
                    result = result.substring(1);
                    editor.putString("NoticeBoard", result);
                    editor.commit();
                    //return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //} else if (type == "TitlePlacement") {
                try {
                    URL url = new URL(PlacementTitle_url);
                    ///////////////////
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    ///////////////////
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String result = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {

                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    //////////////////
                    httpURLConnection.disconnect();
                    result = result.substring(1);
                    editor.putString("Placements", result);
                    editor.commit();
                    //return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //} else if (type.equals("TitleWorkshop")) {
                try {
                    URL url = new URL(WorkshopTitle_url);
                    ///////////////////
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    ///////////////////
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String result = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {

                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    //////////////////
                    httpURLConnection.disconnect();
                    result = result.substring(1);
                    editor.putString("Workshop", result);
                    editor.commit();
                    // return result;
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
            String chek = pref.getString("chk","false");
            if(chek.equals("true"))
            {
                ((Registration)context).finish();
                String fals = "false";
                editor.putString("chk",fals);
                editor.commit();
            }
            else
            {
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
