package com.triloucoazar.projectcars.interfaces;

import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.responses.ResponseArray;

import retrofit.Call;
import retrofit.http.GET;

public interface CarsApi {

    @GET("/posts/list")
    Call<ResponseArray<Post>> fetchAllPosts();
}