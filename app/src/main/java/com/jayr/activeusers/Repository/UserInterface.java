package com.jayr.activeusers.Repository;

import com.jayr.activeusers.Models.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserInterface {

    @GET("users")
    Call<List<Users>> getAllUsers();

}
