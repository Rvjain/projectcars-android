package com.triloucoazar.projectcars.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {

    @SerializedName("car_plate")
    private String carPlate;

    @SerializedName("message")
    private String message;

    @SerializedName("user_name")
    private String userName;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("created_at")
    private Date createdAt;

    public Post(String carPlate, String message) {
        this.carPlate = carPlate;
        this.message = message;
        this.createdAt = new Date();
    }

    public String getCarPlate() {
        return carPlate;
    }

    public String getMessage() {
        return message;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}