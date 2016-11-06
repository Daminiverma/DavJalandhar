package com.example.babyd_000.dav_jalandhar;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.pushbots.push.Pushbots;

import java.util.concurrent.ExecutionException;

public class HomeMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();

        String Class = pref.getString("Class", "null");
        if (Class.contains("null")) {
            startActivity(new Intent(HomeMainActivity.this, Registration.class));
        }
        if (Class.contains("null")) {
            HomeMainActivity.super.onBackPressed();
        }

        setContentView(R.layout.activity_main);
        Pushbots.sharedInstance().init(this);
        Pushbots.sharedInstance().setCustomHandler(customHandler.class);


        // Loading Home fragment on Create
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Home fragment = new Home();
        fragmentTransaction.replace(R.id.container, fragment, "Home");
        fragmentTransaction.commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            Fragment fragmentname = getSupportFragmentManager().findFragmentByTag("Home");
            if (fragmentname != null && fragmentname.isVisible()) {
                android.support.v7.app.AlertDialog.Builder alt = new android.support.v7.app.AlertDialog.Builder(this);
                //AlertDialog.Builder alt = new AlertDialog.Builder(this);
                alt.setTitle("Really exit?");
                alt.setMessage("Are you sure you want to Exit?");
                alt.setNegativeButton("No", null);
                alt.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HomeMainActivity.super.onBackPressed();
                    }
                }).create().show();
            } else {
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Home fragment = new Home();
                fragmentTransaction.replace(R.id.container, fragment, "Home");
                fragmentTransaction.commit();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(HomeMainActivity.this, Settings.class));
            finish();
            return true;
        } else if (id == R.id.Refresh) {
            Background background = new Background(this);
            background.execute();
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.home) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Home fragment = new Home();
            fragmentTransaction.replace(R.id.container, fragment, "Home");
            fragmentTransaction.commit();
        } else if (id == R.id.notification) {

            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Notification fragment = new Notification();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.notice) {

            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Notice_Board fragment = new Notice_Board();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.press) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Press_Releases fragment = new Press_Releases();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.addmissions) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Admissions fragment = new Admissions();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.departments) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Departments fragment = new Departments();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.facilities) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Facilities fragment = new Facilities();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.downloads) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Downloads fragment = new Downloads();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.result) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Univ_Results fragment = new Univ_Results();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.aboutDAV) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            About_Col fragment = new About_Col();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.contact) {

            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Contact_Us fragment = new Contact_Us();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.aboutApp) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            About_app fragment = new About_app();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.admin) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            AdminLogin fragment = new AdminLogin();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
