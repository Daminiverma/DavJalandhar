package com.example.babyd_000.dav_jalandhar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        notifications = (TextView) view.findViewById(R.id.TVNoti);
        String nnn = pref.getString("notification", "No Notifications Yet...");
        notifications.setText(Html.fromHtml(nnn));
        return view;
    }


}