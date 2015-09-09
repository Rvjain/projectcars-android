package com.triloucoazar.projectcars.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ApiError {
    @SerializedName("error_code")
    private Integer code;

    @SerializedName("message")
    private ArrayList<String> messages;

    public ApiError(ArrayList<String> messages, int code) {
        this.messages = messages;
        this.code = code;
    }

    public ApiError(String message, int code) {
        ArrayList<String> messages = new ArrayList<>();
        messages.add(message);
        this.messages = messages;
        this.code = code;
    }

    @Override
    public String toString() {
        return messages.toString();
    }
}