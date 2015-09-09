package com.triloucoazar.projectcars.interfaces;

import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.responses.ApiResponse;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface CarsApi {

    @GET("/posts/list")
    Call<ApiResponse<ArrayList<Post>>> fetchAllPosts();

    @POST("/posts/create")
    Call<ApiResponse<Post>> createUser(@Body Post post);
}