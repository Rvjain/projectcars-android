package com.triloucoazar.projectcars.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.triloucoazar.projectcars.R;
import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.responses.ApiResponse;
import com.triloucoazar.projectcars.services.PostService;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;

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
        postService.createPost(plate.getText().toString(), message.getText().toString(), new Callback<ApiResponse<Post>>() {
            @Override
            public void onResponse(retrofit.Response response) {
                getActivity().finish();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}