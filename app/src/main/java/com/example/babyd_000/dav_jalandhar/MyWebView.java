package com.example.babyd_000.dav_jalandhar;


import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyWebView extends Fragment {
    SharedPreferences.Editor editor;
    Context ctx;
    WebView resweb;
    ProgressDialog progressDialog;

    public MyWebView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_web_view, container, false);
        ctx = inflater.getContext();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = pref.edit();

        resweb = (WebView)  view.findViewById(R.id.ResultsWeb);
        WebSettings webSettings = resweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);

        resweb.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressDialog = new ProgressDialog(ctx);
                progressDialog.setTitle("Loading, Please wait.");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressDialog.hide();
                progressDialog.cancel();
                progressDialog.dismiss();
            }
        });

        String url= pref.getString("URL","null");
        resweb.loadUrl(url);

        return view;
    }
}
