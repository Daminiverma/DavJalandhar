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
        login_url="http://dav-college.netau.net/login.php";
        conn_url = "http://dav-college.netau.net/connchk.php";
        publishProgress();
        synchronized (this) {

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
                    user_name = params[0];
                    String password = params[1];
                    URL url = new URL(login_url);
                    ///////////////////
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    ///////////////////
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                            +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    /////////////////
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line="";
                    while((line = bufferedReader.readLine())!= null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    //////////////////
                    httpURLConnection.disconnect();
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
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
        if (aVoid.equals("Internet Connection is not available..."))
        {
            Toast.makeText(context, ""+aVoid, Toast.LENGTH_SHORT).show();
        }
        else if (aVoid.contains("login success !!!!! Welcome user")) {
            context.startActivity(new Intent(context, Admin.class));
            Toast.makeText(context, "Welcome "+user_name, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Login Not Success", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
