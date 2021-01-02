package com.jayr.activeusers.Repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserClient {
    public static String BASE_URL = "https://jsonplaceholder.typicode.com/" ;

    public static Retrofit retrofit;

    public static Retrofit getRetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    public static UserInterface getAllMyUsers (){
        UserInterface userInterface = getRetrofitClient().create(UserInterface.class);
        return userInterface;
    }
}
