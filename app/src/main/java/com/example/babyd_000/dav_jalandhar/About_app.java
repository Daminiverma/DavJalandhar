package com.example.babyd_000.dav_jalandhar;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.sax.RootElement;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;


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
        Context ctx;
        View view = inflater.inflate(R.layout.about_app, container,false);
        final RelativeLayout imageView = (RelativeLayout) view.findViewById(R.id.about);
        ctx = view.getContext();

        Picasso.with(ctx)
                .load(R.drawable.about)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        imageView.setBackgroundResource(R.drawable.about);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        imageView.setBackgroundResource(R.drawable.about);
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        imageView.setBackgroundResource(R.drawable.about);
                    }
                });

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
