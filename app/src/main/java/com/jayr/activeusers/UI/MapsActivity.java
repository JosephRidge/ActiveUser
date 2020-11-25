package com.jayr.activeusers.UI;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jayr.activeusers.Adapters.UserAdapter;
import com.jayr.activeusers.Models.Users;
import com.jayr.activeusers.R;
import com.jayr.activeusers.Repository.UserClient;
import com.jayr.activeusers.Repository.UserInterface;
import com.jayr.activeusers.ViewModel.LocationViewModel;
import com.jayr.activeusers.ViewModel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Double Latitude;
    Double Longitude;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
       LocationViewModel locationViewModel = ViewModelProviders.of(this).get(LocationViewModel.class);
        locationViewModel.getUserLocations().observe(this, new Observer<List<Users>>() {
            @Override
            public void onChanged(@Nullable List<Users> usersList) {

            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
 /*
    What configs that come with the inital map
   LatLng sydney = new LatLng(37.3159, -81.1496);
        mMap.addMarker(new MarkerOptions().
                position(sydney)
                .title("Lean Graham")
                .icon(bitmapDescriptorFromVector(this,R.drawable.user)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12), 3000, null);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
*/
        getUserLocations(mMap);

    }
            /*   FUNCTIONS   */
    public BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId){

        Drawable vector = ContextCompat.getDrawable(context, vectorResId);
        vector.setBounds(0,0,vector.getIntrinsicWidth()/18,vector.getIntrinsicHeight()/18);
        Bitmap bitmap = Bitmap.createBitmap(vector.getMinimumWidth()/18,vector.getMinimumHeight()/18,Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        vector.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    public  void getUserLocations(GoogleMap googleMap){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserInterface userInterface = retrofit.create(UserInterface.class);//json placeolder api
        Call<List<Users>> call = userInterface.getAllUsers();
        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Code: "+response.code(),Toast.LENGTH_SHORT).show();

                }
                List<Users> users1 = response.body();
                for( Users users :users1){
                    Latitude = Double.parseDouble(users.getAddress().getLocation().getLat());
                    Longitude = Double.parseDouble(users.getAddress().getLocation().getLng());
                    userName = users.getName() ;
                    setUserMarker(googleMap,Latitude,Longitude,userName);

                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void setUserMarker(GoogleMap googleMap, Double lat,Double lng,String userName){
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng userLoc = new LatLng(-lat, -lng);
        mMap.addMarker(new MarkerOptions().
                position(userLoc)
                .title(userName)
                .icon(bitmapDescriptorFromVector(this,R.drawable.user)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(userLoc));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userLoc, 12), 3000, null);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }
}