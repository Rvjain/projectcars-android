package com.triloucoazar.projectcars.services;

import com.facebook.Profile;
import com.triloucoazar.projectcars.application.CarsApplication;
import com.triloucoazar.projectcars.interfaces.CarsApi;
import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.responses.ApiCallback;

import java.util.ArrayList;

import javax.inject.Inject;

public class PostService {

    @Inject
    CarsApi api;

    public PostService(CarsApplication applicationContext) {
        applicationContext.getApplicationComponent().inject(this);
    }

    public void fetchAllPosts(ApiCallback<ArrayList<Post>> callback) {
        api.fetchAllPosts().enqueue(callback);
    }

    public void createPost(Post post, ApiCallback<Post> callback) {
        Profile profile = Profile.getCurrentProfile();
        post.setUserName(profile.getName());
        post.setUserId(profile.getId());
        api.createUser(post).enqueue(callback);
    }
}