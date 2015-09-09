package com.triloucoazar.projectcars.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.triloucoazar.projectcars.R;
import com.triloucoazar.projectcars.activities.FacebookLoginActivity;
import com.triloucoazar.projectcars.activities.PostsActivity;

import org.json.JSONException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FacebookLoginFragment extends BaseFragment {

    @Bind(R.id.login_button)
    LoginButton loginButton;

    private CallbackManager callbackManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facebook_login, container, false);

        ButterKnife.bind(this, view);
        setupLogin();
        return view;
    }

    private void setupLogin() {
        loginButton.setReadPermissions("public_profile", "email");
        loginButton.setFragment(this);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, getFacebookCallback());
    }

    @NonNull
    private FacebookCallback<LoginResult> getFacebookCallback() {
        return new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                requestUserInfo();
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException exception) {
                showLoginFailedToast();
            }
        };
    }

    private void showLoginFailedToast() {
        Toast.makeText(getActivity(), R.string.login_fail, Toast.LENGTH_LONG).show();
    }

    private void requestUserInfo() {
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name");
        new GraphRequest(AccessToken.getCurrentAccessToken(), "/me",
                parameters, HttpMethod.GET, getInfoRequestCallback()).executeAsync();
    }

    @NonNull
    private GraphRequest.Callback getInfoRequestCallback() {
        return new GraphRequest.Callback() {
            public void onCompleted(GraphResponse response) {
                try {
                    String id = response.getJSONObject().getString("id");
                    String name = response.getJSONObject().getString("name");
                    Profile.setCurrentProfile(new Profile(id, null, null, null, name, null));
                    ((FacebookLoginActivity) getActivity()).navigateToHome();
                } catch (JSONException e) {
                    e.printStackTrace();
                    showLoginFailedToast();
                }
            }
        };
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}