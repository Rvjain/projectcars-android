package com.triloucoazar.projectcars.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.triloucoazar.projectcars.R;
import com.triloucoazar.projectcars.analytics.Analytics;
import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.responses.ApiCallback;
import com.triloucoazar.projectcars.responses.ApiError;
import com.triloucoazar.projectcars.services.PostService;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreatePostFragment extends BaseFragment {

    @Bind(R.id.create_post_message)
    EditText message;

    @Bind(R.id.create_post_plate)
    EditText plate;

    @Inject
    PostService postService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_post, container, false);
        ButterKnife.bind(this, view);
        injectionComponent().inject(this);
        return view;
    }

    @OnClick(R.id.create_post_button)
    public void createPost() {
        Post post = new Post(plate.getText().toString(), message.getText().toString());
        postService.createPost(post, new ApiCallback<Post>() {
            @Override
            public void failure(ApiError apiError) {
                Toast.makeText(getActivity(), apiError.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void success(Post data) {
                Analytics.trackPostCreation(data);
                getActivity().finish();
            }
        });
    }
}