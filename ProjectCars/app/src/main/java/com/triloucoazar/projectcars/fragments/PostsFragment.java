package com.triloucoazar.projectcars.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.melnykov.fab.FloatingActionButton;
import com.triloucoazar.projectcars.R;
import com.triloucoazar.projectcars.activities.CreatePostActivity;
import com.triloucoazar.projectcars.adapters.PostAdapter;
import com.triloucoazar.projectcars.responses.ApiCallback;
import com.triloucoazar.projectcars.responses.ApiError;
import com.triloucoazar.projectcars.models.Post;
import com.triloucoazar.projectcars.services.PostService;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PostsFragment extends BaseFragment {

    @Inject
    PostService postService;

    @Bind(R.id.posts_list_view)
    ListView listView;

    @Bind(R.id.posts_fab)
    FloatingActionButton fab;

    @Bind(R.id.posts_swipe_refresh)
    PullRefreshLayout refreshLayout;

    private PostAdapter postAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        injectionComponent().inject(this);
        ButterKnife.bind(this, view);
        fab.attachToListView(listView);
        initListView();
        return view;
    }

    private void initListView() {
        postAdapter = new PostAdapter(getActivity(), new ArrayList<Post>());
        listView.setAdapter(postAdapter);
        initRefresh();
    }

    private void initRefresh() {
        refreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_MATERIAL);
        refreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshList();
            }
        });
        refreshList();
    }

    private void refreshList() {
        refreshLayout.setRefreshing(true);
        postService.fetchAllPosts(new ApiCallback<ArrayList<Post>>() {
            @Override
            public void failure(ApiError apiError) {
                Toast.makeText(getActivity(), apiError.toString(), Toast.LENGTH_LONG).show();
                refreshLayout.setRefreshing(false);
            }

            @Override
            public void success(ArrayList<Post> data) {
                postAdapter.clear();
                postAdapter.addAll(data);
                refreshLayout.setRefreshing(false);
            }
        });
    }

    @OnClick(R.id.posts_fab)
    public void createPost() {
        Intent intent = new Intent(getActivity(), CreatePostActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), fab, getString(R.string.transition_create_post));
        getActivity().startActivity(intent, options.toBundle());
    }
}