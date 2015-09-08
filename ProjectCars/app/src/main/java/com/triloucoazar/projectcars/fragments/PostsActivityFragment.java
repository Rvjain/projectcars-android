package com.triloucoazar.projectcars.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.triloucoazar.projectcars.R;
import com.triloucoazar.projectcars.application.CarsApplication;
import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.services.PostService;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class PostsActivityFragment extends Fragment {

    @Inject
    PostService postService;

    public PostsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CarsApplication app = (CarsApplication) getActivity().getApplication();
        app.getApplicationComponent().inject(this);
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        postService.fetchAllPosts();
    }
}
