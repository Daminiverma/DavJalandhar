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
                //Toast.makeText(context,"date:"+dte+"title:"+title+"desc:"+desc  , Toast.LENGTH_SHORT).show();
                URL url = new URL("http://dav-college.netau.net/Insert.php");
                ///////////////////
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                ///////////////////
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("res", "UTF-8") + "=" + URLEncoder.encode(res, "UTF-8") + "&" +
                        URLEncoder.encode("dte", "UTF-8") + "=" + URLEncoder.encode(dte, "UTF-8") + "&" +
                        URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8") + "&" +
                        URLEncoder.encode("desc", "UTF-8") + "=" + URLEncoder.encode(desc, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                /////////////////
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
                return result;
            } catch (MalformedURLException e) {
                return "No";
                //e.printStackTrace();
            } catch (IOException e) {
                return "No";
                //e.printStackTrace();
            }

        }
        if (res.equals("MSG")) {
            String msg = params[1];
            String alias= params[2];
            try {
                URL url = new URL("http://dav-college.netau.net/Notification.php");
                ///////////////////
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                ///////////////////
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("msg", "UTF-8") + "=" + URLEncoder.encode(msg, "UTF-8") + "&" +
                        URLEncoder.encode("alias", "UTF-8") + "=" + URLEncoder.encode(alias, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                /////////////////
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
                return result;
            } catch (MalformedURLException e) {
                return "No";
                //e.printStackTrace();
            } catch (IOException e) {
                return "No";
                //e.printStackTrace();
            }
        }
        if (res.equals("updt")) {
            String tab = params[1];
            String tit1 = params[2];
            String tit2 = params[3];
            String desc = params[4];
            try {
                URL url = new URL("http://dav-college.netau.net/Update.php");
                ///////////////////
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                ///////////////////
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("tab", "UTF-8") + "=" + URLEncoder.encode(tab, "UTF-8") + "&" +
                        URLEncoder.encode("tit1", "UTF-8") + "=" + URLEncoder.encode(tit1, "UTF-8") + "&" +
                        URLEncoder.encode("tit2", "UTF-8") + "=" + URLEncoder.encode(tit2, "UTF-8") + "&" +
                        URLEncoder.encode("desc", "UTF-8") + "=" + URLEncoder.encode(desc, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                /////////////////
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
                return result;
            } catch (MalformedURLException e) {
                return "No";
                //e.printStackTrace();
            } catch (IOException e) {
                return "No";
                //e.printStackTrace();
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
