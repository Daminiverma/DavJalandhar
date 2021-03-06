package com.example.babyd_000.dav_jalandhar;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Admin_Insertion extends Fragment implements View.OnClickListener {

    RadioButton RBPR, RBNB, RBPN, RBW, RBM;
    EditText entertitle, enterdesc, dte;
    String res = null;
    static Context ctx;

    public Admin_Insertion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.admin__insertion, container, false);
        ctx=inflater.getContext();


        final RelativeLayout login2 = (RelativeLayout) view.findViewById(R.id.logininsert);

        Picasso.with(ctx)
                .load(R.drawable.login_red)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        login2.setBackgroundResource(R.drawable.login_red);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        login2.setBackgroundResource(R.drawable.login_red);
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        login2.setBackgroundResource(R.drawable.login_red);
                    }
                });

        view.findViewById(R.id.enterbtn).setOnClickListener(this);
        view.findViewById(R.id.RBPR).setOnClickListener(this);
        view.findViewById(R.id.RBNB).setOnClickListener(this);
        view.findViewById(R.id.RBPN).setOnClickListener(this);
        view.findViewById(R.id.RBW).setOnClickListener(this);
        view.findViewById(R.id.RBM).setOnClickListener(this);
        entertitle = (EditText) view.findViewById(R.id.entertitle);
        // entertitle.setOnClickListener(this);
        enterdesc = (EditText) view.findViewById(R.id.enterdesc);
        // enterdesc.setOnClickListener(this);
        dte = (EditText) view.findViewById(R.id.dte);
        //  dte.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.RBPR) {
            res = "releases";
        } else if (v.getId() == R.id.RBNB) {
            res = "notice";

        } else if (v.getId() == R.id.RBPN) {
            res = "placement";

        } else if (v.getId() == R.id.RBW) {
            res = "workshop";

        } else if (v.getId() == R.id.RBM) {
            res = "marquee";

        }
        if (v.getId() == R.id.enterbtn) {
            String result = null;
            String title = entertitle.getText().toString();
            String desc = enterdesc.getText().toString();
            String date = dte.getText().toString();
            try {
                result = new BackgroundAdmin(ctx).execute(res, date, title, desc).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            Toast.makeText(Admin_Insertion.ctx, "Insertion Successful", Toast.LENGTH_SHORT).show();
        }

    }
}
