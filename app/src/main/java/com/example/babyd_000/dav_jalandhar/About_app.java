package com.example.babyd_000.dav_jalandhar;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_app extends Fragment {


    public About_app() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.about_app, container,false);
        FloatingActionButton fabcntct = (FloatingActionButton) view.findViewById(R.id.fabcntct);
        fabcntct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                String[] to={"deedam2417@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback about DAV App");
               // intent.putExtra(Intent.EXTRA_TEXT,"Type your Report or Feedback here...");
              //  intent.setType("message/rfc822");
                startActivity( Intent.createChooser(intent, "Send Email using.."));
            }
        });
        return view;
    }

}
