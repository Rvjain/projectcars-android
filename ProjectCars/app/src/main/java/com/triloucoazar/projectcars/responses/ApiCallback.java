package com.triloucoazar.projectcars.responses;

import java.io.Serializable;

import retrofit.Callback;
import retrofit.Response;

public abstract class ApiCallback<T extends Serializable> implements Callback<ApiResponse<T>> {
    public abstract void failure(ApiError apiError);

    public abstract void success(T data);

    @Override
    public void onFailure(Throwable t) {
        failure(new ApiError(t.getMessage(), 0));
    }

    @Override
    public void onResponse(Response<ApiResponse<T>> response) {
        ApiResponse<T> apiResponse = response.body();
        if (apiResponse == null) {
            failure(new ApiError("Oops, ocorreu um erro", 0));
        } else {
            if (apiResponse.getErrorCode() != 200) {
                failure(new ApiError(apiResponse.getMessage(), apiResponse.getErrorCode()));
            } else {
                success(apiResponse.getData());
            }
        }
    }
}