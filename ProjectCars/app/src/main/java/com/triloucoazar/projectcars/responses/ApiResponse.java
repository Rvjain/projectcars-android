package com.triloucoazar.projectcars.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ApiResponse<T extends Serializable> implements Serializable {
    @SerializedName("error_code")
    private int errorCode;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private T data;

    public T getData() {
        return data;
    }
}
