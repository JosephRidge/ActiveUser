package com.jayr.activeusers;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jayr.activeusers.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(37.3159, -81.1496);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Lean Graham").icon(bitmapDescriptorFromVector(this,R.drawable.user)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12), 3000, null);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId){

        Drawable vector = ContextCompat.getDrawable(context, vectorResId);
        vector.setBounds(0,0,vector.getIntrinsicWidth()/18,vector.getIntrinsicHeight()/18);
        Bitmap bitmap = Bitmap.createBitmap(vector.getMinimumWidth()/18,vector.getMinimumHeight()/18,Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        vector.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}