package com.example.babyd_000.dav_jalandhar;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by hp on 15-Apr-16.
 */
public class Notification extends Fragment {
    SharedPreferences.Editor editor;
    Context ctx;
    TextView notifications;
    public Notification() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notification_fragment, container, false);
        ctx = inflater.getContext();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = pref.edit();
        final RelativeLayout blackboard = (RelativeLayout) view.findViewById(R.id.blackboard);
        Picasso.with(ctx)
                .load(R.drawable.blackboard)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        blackboard.setBackgroundResource(R.drawable.blackboard);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        blackboard.setBackgroundResource(R.drawable.blackboard);
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        blackboard.setBackgroundResource(R.drawable.blackboard);
                    }
                });

        notifications = (TextView) view.findViewById(R.id.TVNoti);
        String nnn = pref.getString("notification", "No Notifications Yet...");
        notifications.setText(Html.fromHtml(nnn));
        return view;
    }


}