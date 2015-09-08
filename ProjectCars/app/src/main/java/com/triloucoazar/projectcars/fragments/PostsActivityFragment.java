package com.triloucoazar.projectcars.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;
import com.triloucoazar.projectcars.R;
import com.triloucoazar.projectcars.adapters.PostAdapter;
import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.responses.ResponseArray;
import com.triloucoazar.projectcars.services.PostService;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.Response;

public class PostsActivityFragment extends BaseFragment {

    @Inject
    PostService postService;

    @Bind(R.id.posts_list_view)
    ListView listView;

    @Bind(R.id.posts_fab)
    FloatingActionButton fab;

    private PostAdapter postAdapter;

    public PostsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_posts, container, false);

        injectionComponent().inject(this);
        ButterKnife.bind(this, view);
        fab.attachToListView(listView);
        initListView();

        return view;
    }

    private void initListView() {
        postAdapter = new PostAdapter(getActivity(), new ArrayList<Post>());
        listView.setAdapter(postAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        postService.fetchAllPosts(new Callback<ResponseArray<Post>>() {
            @Override
            public void onResponse(Response<ResponseArray<Post>> response) {
                postAdapter.clear();
                postAdapter.addAll(response.body().getData());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }


    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
