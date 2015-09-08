package com.triloucoazar.projectcars.fragments;

import android.support.v4.app.Fragment;

import com.triloucoazar.projectcars.application.CarsApplication;
import com.triloucoazar.projectcars.dagger.components.ApplicationComponent;

public class BaseFragment extends Fragment {

    protected ApplicationComponent injectionComponent() {
        CarsApplication app = (CarsApplication) getActivity().getApplication();
        return app.getApplicationComponent();
    }

}