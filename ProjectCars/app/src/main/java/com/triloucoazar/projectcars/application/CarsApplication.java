package com.triloucoazar.projectcars.application;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.LoginEvent;
import com.facebook.FacebookSdk;
import com.triloucoazar.projectcars.dagger.components.ApplicationComponent;
import com.triloucoazar.projectcars.dagger.components.DaggerApplicationComponent;
import com.triloucoazar.projectcars.dagger.modules.ApplicationModule;
import io.fabric.sdk.android.Fabric;

public class CarsApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        FacebookSdk.sdkInitialize(getApplicationContext());
        initializeInjector();
    }

    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}