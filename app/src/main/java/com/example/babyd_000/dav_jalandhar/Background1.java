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
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

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

        String type = params[0];
        ReleasesDesc_url = "http://dav-college.netau.net/ReleasesDesc.php";
        NoticeDesc_url = "http://dav-college.netau.net/NoticeDesc.php";
        PlacementDesc_url="http://dav-college.netau.net/PlacementDesc.php";
        WorshopDesc_url = "http://dav-college.netau.net/WorkshopDesc.php";
        login_url="http://dav-college.netau.net/login.php";
        if (type.equals("Releases")) {
            try {
                String title = params[1];
                URL url = new URL(ReleasesDesc_url);
                ///////////////////
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                ///////////////////
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8");
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
        } else if (type.equals("Notice")) {

            try {
                String title = params[1];
                URL url = new URL(NoticeDesc_url);
                ///////////////////
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                ///////////////////
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8");
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
        else if (type.equals("Placements")) {
            try {
                String title = params[1];
                URL url = new URL(PlacementDesc_url);
                ///////////////////
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                ///////////////////
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8");
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
        else if (type.equals("Workshop")) {
            try {
                String title = params[1];
                URL url = new URL(WorshopDesc_url);
                ///////////////////
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                ///////////////////
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8");
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
        else if (type.equals("login")) {
            try {
                String user_name = params[1];
                String password = params[2];
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