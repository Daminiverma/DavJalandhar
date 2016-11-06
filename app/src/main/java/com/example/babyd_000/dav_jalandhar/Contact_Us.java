package com.example.babyd_000.dav_jalandhar;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact_Us extends Fragment implements View.OnClickListener {
    SharedPreferences.Editor editor;
    Context ctx;
    ImageView iv;

    public Contact_Us() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact__us, container, false);
        ctx = inflater.getContext();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = pref.edit();
        iv = (ImageView) view.findViewById(R.id.imageMap);
        iv.setOnClickListener(this);

        view.findViewById(R.id.facebook).setOnClickListener(this);
        view.findViewById(R.id.twitter).setOnClickListener(this);
        view.findViewById(R.id.linkedin).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.facebook) {

            Uri uri = Uri.parse("https://www.facebook.com/DAV-College-Jalandhar-222013957878501");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else if (v.getId() == R.id.twitter) {
            Uri uri = Uri.parse("https://twitter.com/davjalandhar");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        } else if (v.getId() == R.id.linkedin) {
            Uri uri = Uri.parse("https://in.linkedin.com/in/dav-college-49883545");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else if (v.getId() == R.id.imageMap) {
            String res = null;
            try {
                res = new BackgroundCheck(ctx).execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (res.equals("no")) {
                Toast.makeText(ctx, "Internet Connection is Not Available", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(ctx, MapsActivity.class));
            }
        }
    }
}
