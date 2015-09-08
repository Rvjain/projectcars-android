package com.triloucoazar.projectcars.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ResponseArray<T extends Serializable> implements Serializable {
    @SerializedName("error_code")
    private int errorCode;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private ArrayList<T> data;
}
