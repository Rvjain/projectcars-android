package com.triloucoazar.projectcars.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ApiResponse<T extends Serializable> implements Serializable {
    @SerializedName("error_code")
    private int errorCode;

    @SerializedName("message")
    private ArrayList<String> message;

    @SerializedName("data")
    private T data;

    public T getData() {
        return data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public ArrayList<String> getMessage() {
        return message;
    }
}
