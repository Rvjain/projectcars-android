package com.triloucoazar.projectcars.models;

import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.triloucoazar.projectcars.application.CarsApplication;
import com.triloucoazar.projectcars.interfaces.CarsApi;
import com.triloucoazar.projectcars.responses.ResponseArray;

import java.io.Serializable;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.Response;


public class Post implements Serializable {

    @SerializedName("car_plate")
    private String carPlate;

    @SerializedName("message")
    private String message;

}
