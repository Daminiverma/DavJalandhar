package com.example.babyd_000.dav_jalandhar;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ImageView back, earth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        back = (ImageView) findViewById(R.id.mapback);
        earth = (ImageView) findViewById(R.id.earth);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        earth.setOnClickListener((View.OnClickListener) this);
    }

    public Void earth(View view) {
        if (mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
            earth.setImageResource(R.drawable.earthnon);
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            Toast.makeText(MapsActivity.this, "Changing to Satellite View", Toast.LENGTH_SHORT).show();
        } else {
            earth.setImageResource(R.drawable.earth);
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            Toast.makeText(MapsActivity.this, "Changing to Normal View", Toast.LENGTH_SHORT).show();
        }
        return null;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng DAVCollegeJalandhar = new LatLng(31.349623, 75.557781);
        mMap.addMarker(new MarkerOptions().position(DAVCollegeJalandhar).title("DAV College, Jalandhar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(DAVCollegeJalandhar));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16.0f));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }
}
