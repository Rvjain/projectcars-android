package com.triloucoazar.projectcars.services;

import com.triloucoazar.projectcars.application.CarsApplication;
import com.triloucoazar.projectcars.responses.ApiCallback;
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

    public void fetchAllPosts(ApiCallback<ArrayList<Post>> callback) {
        api.fetchAllPosts().enqueue(callback);
    }

    public void createPost(Post post, Callback<ApiResponse<Post>> callback) {
        api.createUser(post).enqueue(callback);
    }
}