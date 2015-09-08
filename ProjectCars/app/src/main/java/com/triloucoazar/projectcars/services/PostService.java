package com.triloucoazar.projectcars.services;

import android.util.Log;

import com.triloucoazar.projectcars.application.CarsApplication;
import com.triloucoazar.projectcars.interfaces.CarsApi;
import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.responses.ResponseArray;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.Response;

public class PostService {

    @Inject
    CarsApi api;

    public PostService(CarsApplication applicationContext) {
        applicationContext.getApplicationComponent().inject(this);
    }

    public void fetchAllPosts() {
        api.fetchAllPosts().enqueue(new Callback<ResponseArray<Post>>() {
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
