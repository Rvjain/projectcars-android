package com.triloucoazar.projectcars.models;

import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.triloucoazar.projectcars.interfaces.CarsApi;
import com.triloucoazar.projectcars.responses.ResponseArray;

import java.io.IOException;
import java.io.Serializable;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class Post implements Serializable {

    @SerializedName("car_plate")
    private String carPlate;

    @SerializedName("message")
    private String message;

    public void fetchAllPosts() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.10:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        CarsApi service = retrofit.create(CarsApi.class);

        Call<ResponseArray<Post>> call = service.fetchAllPosts();

        call.enqueue(new Callback<ResponseArray<Post>>() {
            @Override
            public void onResponse(Response<ResponseArray<Post>> response) {
                Log.i("Funciona", "");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("merda", "");
            }
        });
    }
}
