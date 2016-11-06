package com.example.babyd_000.dav_jalandhar;


import android.app.DownloadManager;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Downloads extends Fragment implements View.OnClickListener{
    SharedPreferences.Editor editor;
    Context ctx;
    public Downloads() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_downloads, container, false);
        ctx=inflater.getContext();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = pref.edit();

        //Initializing on Clicks
        view.findViewById(R.id.Calendar).setOnClickListener(this);
        view.findViewById(R.id.Prospectus).setOnClickListener(this);
        view.findViewById(R.id.Syllabus).setOnClickListener(this);
        view.findViewById(R.id.Admission1).setOnClickListener(this);
        view.findViewById(R.id.Admission2).setOnClickListener(this);
        view.findViewById(R.id.Admission3).setOnClickListener(this);
        view.findViewById(R.id.Hostel1).setOnClickListener(this);
        view.findViewById(R.id.Hostel2).setOnClickListener(this);
        view.findViewById(R.id.Hostel3).setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.Calendar)
        {
            Uri uri = Uri.parse("https://dl.dropboxusercontent.com/s/vp05te9z6nbitzf/Calender2014-15.jpg?dl=0"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.Prospectus)
        {
            Uri uri = Uri.parse("http://178.33.61.6/putstorage/DownloadFileHash/5CC38F5F3A5A4A5QQWE3242059EWQS/DAV%20Jalandhar%20Prospectus%202015-16.pdf");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.Admission1)
        {
            Uri uri = Uri.parse("https://dl.dropboxusercontent.com/s/518tm2g0clj3b68/adm-2014-15-1%20%281%29.jpg?dl=0");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.Admission2)
        {
            Uri uri = Uri.parse("https://dl.dropboxusercontent.com/s/708lzu77e8vf65m/adm-2014-15-2.jpg?dl=0");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.Admission3)
        {
            Uri uri = Uri.parse("https://dl.dropboxusercontent.com/s/g3qbukj6mdt771w/adm-2014-15-3.jpg?dl=0");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.Hostel1)
        {

            Uri uri = Uri.parse("https://dl.dropboxusercontent.com/s/tidleq6f49n5n10/hostel01.jpg?dl=0");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.Hostel2)
        {

            Uri uri = Uri.parse("https://dl.dropboxusercontent.com/s/nvwe1pvv7ojxszt/hostel02.jpg?dl=0");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.Hostel3)
        {

            Uri uri = Uri.parse("https://dl.dropboxusercontent.com/s/0vy17q2finikhia/hostel03.jpg?dl=0");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId()==R.id.Syllabus)
        {
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
                editor.putString("URL", "http://gndu.ac.in/syllabi.asp");
                editor.commit();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyWebView fragment = new MyWebView();
                fragmentTransaction.add(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        }

    }
}
