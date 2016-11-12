package com.example.babyd_000.dav_jalandhar;


import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
public class Facilities extends Fragment implements View.OnClickListener {
    Context ctx;


    public Facilities() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_facilities, container, false);
        ctx = inflater.getContext();
        final RelativeLayout imageViewbck = (RelativeLayout) view.findViewById(R.id.bckimg);
        ImageView imageViewl = (ImageView) view.findViewById(R.id.library);
        imageViewl.setOnClickListener(this);
        ImageView imageViewc = (ImageView) view.findViewById(R.id.cafetaria);
        imageViewc.setOnClickListener(this);
        ImageView imageViewhosp = (ImageView) view.findViewById(R.id.hospital);
        imageViewhosp.setOnClickListener(this);
        ImageView imageViewhos = (ImageView) view.findViewById(R.id.hostel);
        imageViewhos.setOnClickListener(this);
        ImageView imageViews = (ImageView) view.findViewById(R.id.sports);
        imageViews.setOnClickListener(this);

        Picasso.with(ctx)
                .load(R.drawable.bubbles)
                .placeholder(R.drawable.bubbles)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        imageViewbck.setBackgroundResource(R.drawable.bubbles);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        imageViewbck.setBackgroundResource(R.drawable.bubbles);
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        imageViewbck.setBackgroundResource(R.drawable.bubbles);
                    }
                });

        Picasso.with(ctx)
                .load(R.drawable.library)
                .placeholder(R.drawable.library)
                .resize(200,200)
                .into(imageViewl);
        Picasso.with(ctx)
                .load(R.drawable.cafetaria)
                .placeholder(R.drawable.cafetaria)
                .resize(200,200)
                .centerCrop()
                .into(imageViewc);
        Picasso.with(ctx)
                .load(R.drawable.hospital)
                .placeholder(R.drawable.hospital)
                .error(R.drawable.hospital)
                .resize(200,200)
                .into(imageViewhosp);
        Picasso.with(ctx)
                .load(R.drawable.hostel)
                .placeholder(R.drawable.hostel)
                .error(R.drawable.hostel)
                .resize(200,200)
                .into(imageViewhos);
        Picasso.with(ctx)
                .load(R.drawable.sports)
                .placeholder(R.drawable.sports)
                .error(R.drawable.sports)
                .resize(200,200)
                .into(imageViews);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.library) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fac_Library fragment = new Fac_Library();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if (v.getId() == R.id.cafetaria) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fac_Cafe fragment = new Fac_Cafe();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if (v.getId() == R.id.hospital) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fac_Hospital fragment = new Fac_Hospital();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if (v.getId() == R.id.hostel) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fac_Hostel fragment = new Fac_Hostel();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if (v.getId() == R.id.sports) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fac_Sports fragment = new Fac_Sports();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }

    }
}