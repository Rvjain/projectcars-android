package com.triloucoazar.projectcars.dagger.components;

import com.triloucoazar.projectcars.dagger.modules.ApplicationModule;
import com.triloucoazar.projectcars.fragments.CreatePostFragment;
import com.triloucoazar.projectcars.fragments.PostsFragment;
import com.triloucoazar.projectcars.services.PostService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(PostService postService);

    void inject(PostsFragment fragment);

    void inject(CreatePostFragment fragment);
}