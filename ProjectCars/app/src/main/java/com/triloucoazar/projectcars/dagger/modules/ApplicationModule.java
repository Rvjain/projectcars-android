package com.triloucoazar.projectcars.dagger.modules;

import android.app.Application;
import android.content.Context;

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
