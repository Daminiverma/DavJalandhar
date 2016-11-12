package com.example.babyd_000.dav_jalandhar;


import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements View.OnClickListener {
    SharedPreferences.Editor editor;
    String mar1, mar2;
    static Context ctx;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ctx = inflater.getContext();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        view.findViewById(R.id.releases).setOnClickListener(this);
        view.findViewById(R.id.notice).setOnClickListener(this);
        view.findViewById(R.id.placement).setOnClickListener(this);
        view.findViewById(R.id.workshop).setOnClickListener(this);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = pref.edit();


        //MARQUEE...........................
        TextView marquee1 = (TextView) view.findViewById(R.id.marquee1);
        TextView marquee2 = (TextView) view.findViewById(R.id.marquee2);
        marquee1.setOnClickListener(this);
        marquee2.setOnClickListener(this);
        String tempresultmarquee = pref.getString("Marquee", "Please Refresh..<br>.<br>.<br>.<br>");
        String resultmarquee[] = tempresultmarquee.split("<br>");


        marquee1.setText(resultmarquee[0]);
        marquee2.setText(resultmarquee[2]);
        mar1 = resultmarquee[1];
        mar2 = resultmarquee[3];

        //PRESS RELEASES....................
        TextView releases = (TextView) view.findViewById(R.id.releases);
        String resultreleases = pref.getString("PressReleases", "nil");
        String text = "<b><u><h3><font color='#ffffff'>P</font><font color='#000000'>RESS &nbsp;</font><font color='#ffffff'>RELEASES</font></h3></u></b>";
        releases.setText(Html.fromHtml(text + resultreleases));

        //E Notice Board..................
        TextView notice = (TextView) view.findViewById(R.id.notice);
        String resultnotice = pref.getString("NoticeBoard", "nil");
        String text1 = "<b><u><h3><font color='#000000'>N</font><font color='#b30000'>OTICE &nbsp;</font><font color='#000000'>BOARD</font></h3></u></b>";
        notice.setText(Html.fromHtml(text1 + resultnotice));

        //Placements........................
        TextView placement = (TextView) view.findViewById(R.id.placement);
        String resultplacement = pref.getString("Placements", "nil");
        String text2 = "<b><u><h3><font color='#000000'>P</font><font color='#b30000'>LACEMENT &nbsp;</font><font color='#000000'>NOTICE</font></h3></u></b>";
        placement.setText(Html.fromHtml(text2 + resultplacement));


        //Workshop..........................
        TextView workshop = (TextView) view.findViewById(R.id.workshop);
        String resultworkshop = pref.getString("Workshop", "nil");
        String text3 = "<b><u><h3><font color='#FFFFFF'>W</font><font color='#000000'>ORKSHOPS</font></h3></u></b>";
        workshop.setText(Html.fromHtml(text3 + resultworkshop));


        //Footer
        TextView footerleft = (TextView) view.findViewById(R.id.footerleft);
        TextView footerright = (TextView) view.findViewById(R.id.footerright);
        footerleft.setText(Html.fromHtml("<h3><u><font color='#b30000'>ANTI </font><font color='#cccccc'>RAGGING POLICY</font></u></h3>Ragging is Conspicuous by its Absence-both in the Hostels and in the Campus of DAV College, Jalandhar. Stringent Punishment in the Form of huge fine and even Expulsion from the College act as deterrents to ragging."));
        footerright.setText(Html.fromHtml("<h3><u><font color='#b30000'>ADMINISTRATIVE </font><font color='#cccccc'>WING</font></u></h3>Principal - &nbsp; Dr. B.B. Sharma<br>Vice Principal - &nbsp; Prof. Vijay Gupta<br>Vice Principal - &nbsp; Prof. V.K. Sareen<br>Registrar - &nbsp; Prof. A.K. Bhardwaj<br>Dy. Registrar - &nbsp; Dr. Kiranjeet Randhawa<br>"));

        return view;
    }

    @Override
    public void onClick(View v) {
        String res = null;
        if (v.getId() == R.id.marquee1) {
            try {
                res = new BackgroundCheck(ctx).execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (res.equals("no")) {
                Toast.makeText(ctx, "Internet Connection is Required to view the Page.", Toast.LENGTH_SHORT).show();
            } else {
                Uri uri = Uri.parse(mar1);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        } else if (v.getId() == R.id.marquee2) {
            try {
                res = new BackgroundCheck(ctx).execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (res.equals("no")) {
                Toast.makeText(ctx, "Internet Connection is Required to view the Page.", Toast.LENGTH_SHORT).show();
            } else {
                Uri uri = Uri.parse(mar2);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        } else if (v.getId() == R.id.releases) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Press_Releases fragment = new Press_Releases();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        } else if (v.getId() == R.id.notice) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Notice_Board fragment = new Notice_Board();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        } else if (v.getId() == R.id.placement) {
            try {
                res = new BackgroundCheck(ctx).execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (res.equals("no")) {
                Toast.makeText(ctx, "Internet Connection is Required to view the Page.", Toast.LENGTH_SHORT).show();
            } else {
                editor.putString("URL", "http://www.davjalandhar.com");
                editor.commit();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyWebView fragment = new MyWebView();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        } else if (v.getId() == R.id.workshop) {
            try {
                res = new BackgroundCheck(ctx).execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (res.equals("no")) {
                Toast.makeText(ctx, "Internet Connection is Required to view the Page.", Toast.LENGTH_SHORT).show();
            } else {
                editor.putString("URL", "http://www.davjalandhar.com/index.php/campus-watch/conferencesseminarsworkshops");
                editor.commit();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MyWebView fragment = new MyWebView();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        }
    }
}