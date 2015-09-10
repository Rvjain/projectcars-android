package com.triloucoazar.projectcars.dagger.modules;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.triloucoazar.projectcars.application.CarsApplication;
import com.triloucoazar.projectcars.interfaces.CarsApi;
import com.triloucoazar.projectcars.services.PostService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

@Module
public class ApplicationModule {
    private final CarsApplication application;

    public ApplicationModule(CarsApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    CarsApi provideCarsApi() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.21:8080")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(CarsApi.class);
    }

    @Provides
    PostService providePostService() {
        return new PostService(application);
    }
}