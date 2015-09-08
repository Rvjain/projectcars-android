package com.triloucoazar.projectcars.services;

import com.triloucoazar.projectcars.application.CarsApplication;
import com.triloucoazar.projectcars.interfaces.CarsApi;
import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.responses.ResponseArray;
import com.triloucoazar.projectcars.responses.ResponseObject;

import javax.inject.Inject;

import retrofit.Callback;

public class PostService {

    @Inject
    CarsApi api;

    public PostService(CarsApplication applicationContext) {
        applicationContext.getApplicationComponent().inject(this);
    }

    public void fetchAllPosts(Callback<ResponseArray<Post>> callback) {
        api.fetchAllPosts().enqueue(callback);
    }

    public void createPost(String plate, String message, Callback<ResponseObject<Post>> callback) {
        api.createUser(new Post(plate, message)).enqueue(callback);
    }
}
