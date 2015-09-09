package com.triloucoazar.projectcars.dagger.modules;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.triloucoazar.projectcars.application.CarsApplication;
import com.triloucoazar.projectcars.interfaces.CarsApi;
import com.triloucoazar.projectcars.services.PostService;

import org.parceler.Parcel;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Callback;
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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.10:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(CarsApi.class);
    }

    @Provides
    PostService providePostService() {
        return new PostService(application);
    }
}