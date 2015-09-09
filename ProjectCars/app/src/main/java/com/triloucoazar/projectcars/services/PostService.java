package com.triloucoazar.projectcars.services;

import com.triloucoazar.projectcars.application.CarsApplication;
import com.triloucoazar.projectcars.interfaces.CarsApi;
import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.responses.ApiResponse;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit.Callback;

public class PostService {

    @Inject
    CarsApi api;

    public PostService(CarsApplication applicationContext) {
        applicationContext.getApplicationComponent().inject(this);
    }

    public void fetchAllPosts(Callback<ApiResponse<ArrayList<Post>>> callback) {
        api.fetchAllPosts().enqueue(callback);
    }

    public void createPost(String plate, String message, Callback<ApiResponse<Post>> callback) {
        api.createUser(new Post(plate, message)).enqueue(callback);
    }
}
