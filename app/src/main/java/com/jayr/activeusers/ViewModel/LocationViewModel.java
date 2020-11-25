package com.jayr.activeusers.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jayr.activeusers.Models.Users;
import com.jayr.activeusers.Repository.UserInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocationViewModel extends ViewModel {

    private MutableLiveData<List<Users>> locationList;

    public LiveData<List<Users>> getUserLocations(){
        if(locationList == null){
            locationList = new MutableLiveData<List<Users>>();
            loadUsers();
        }

        return locationList;
    }

    public void loadUsers(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserInterface userInterface = retrofit.create(UserInterface.class);//json placeolder api
        Call<List<Users>> call = userInterface.getAllUsers();

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                locationList.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
            }
        });

    }


}
