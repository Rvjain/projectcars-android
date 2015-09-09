package com.triloucoazar.projectcars.responses;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit.Callback;
import retrofit.Response;

public abstract class ApiCallback<T extends Serializable> implements Callback<ApiResponse<T>> {
    public abstract void failure(ApiError apiError);

    public abstract void success(T data);

    @Override
    public void onFailure(Throwable t) {
        ArrayList<String> messages = new ArrayList<>();
        messages.add(t.getMessage());

        failure(new ApiError(messages, 0));
    }

    @Override
    public void onResponse(Response<ApiResponse<T>> response) {
        ApiResponse<T> apiResponse = response.body();

        if (apiResponse.getErrorCode() != 200) {
            failure(new ApiError(apiResponse.getMessage(), apiResponse.getErrorCode()));
        } else {
            success(apiResponse.getData());
        }
    }
}