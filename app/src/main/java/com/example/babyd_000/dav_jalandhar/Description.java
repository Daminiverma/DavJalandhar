package com.example.babyd_000.dav_jalandhar;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Description extends Fragment {
    static Context ctx;
    SharedPreferences.Editor editor;
    TextView tit, desc;

    public Description() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        // Inflate the layout for this fragment
        ctx = inflater.getContext();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        final RelativeLayout descpage = (RelativeLayout) view.findViewById(R.id.descpage);
        editor = pref.edit();
        tit = (TextView) view.findViewById(R.id.tit);
        desc = (TextView) view.findViewById(R.id.desc);


        //Press Releases
        String result = "", title, type;
        type = pref.getString("Type", "null");
        if (type == "Releases") {

            Picasso.with(ctx)
                    .load(R.drawable.newspaper)
                    .into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            descpage.setBackgroundResource(R.drawable.newspaper);
                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {
                            descpage.setBackgroundResource(R.drawable.newspaper);
                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {
                            descpage.setBackgroundResource(R.drawable.newspaper);
                        }
                    });

            tit.setTextColor(Color.parseColor("#000000"));
            desc.setTextColor(Color.parseColor("#000000"));
        } else if (type == "Notice") {
//            view.findViewById(R.id.descpage).setBackgroundResource(R.drawable.notice);

            Picasso.with(ctx)
                    .load(R.drawable.notice)
                    .into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            descpage.setBackgroundResource(R.drawable.notice);
                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {
                            descpage.setBackgroundResource(R.drawable.notice);
                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {
                            descpage.setBackgroundResource(R.drawable.notice);
                        }
                    });

            tit.setTextColor(Color.parseColor("#800000"));
            desc.setTextColor(Color.parseColor("#800000"));
        }
        title = pref.getString("Title", "null");
        title = title.replace("*  ", "");

        try {
            result = new Background1(ctx).execute(type, title).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        tit.setText(title);
        desc.setText(Html.fromHtml(result));
        return view;
    }

}
