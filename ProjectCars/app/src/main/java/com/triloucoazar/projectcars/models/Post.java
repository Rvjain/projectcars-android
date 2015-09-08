package com.triloucoazar.projectcars.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Post implements Serializable {

    @SerializedName("car_plate")
    private String carPlate;

    @SerializedName("message")
    private String message;

    public String getCarPlate() {
        return carPlate;
    }

    public String getMessage() {
        return message;
    }
}
