package com.triloucoazar.projectcars.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.triloucoazar.projectcars.R;
import com.triloucoazar.projectcars.models.Post;

/**
 * A placeholder fragment containing a simple view.
 */
public class PostsActivityFragment extends Fragment {

    public PostsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        new Post().fetchAllPosts();
    }
}
