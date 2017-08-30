package com.q8coders.codequality.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shahid on 8/30/2017.
 */


public class CustomerModel {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String username;

    @SerializedName("phone")
    public String phone;
}
