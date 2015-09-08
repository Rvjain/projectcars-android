package com.triloucoazar.projectcars.interfaces;

import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.responses.ResponseArray;
import com.triloucoazar.projectcars.responses.ResponseObject;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface CarsApi {

    @GET("/posts/list")
    Call<ResponseArray<Post>> fetchAllPosts();

    @POST("/posts/create")
    Call<ResponseObject<Post>> createUser(@Body Post post);
}