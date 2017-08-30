package com.q8coders.codequality.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shahid on 8/30/2017.
 */


public class MemberModel1 {

    @SerializedName("id")
    public int id;

    @SerializedName("username")
    public String username;

    @SerializedName("email")
    public String email;

    @SerializedName("phone")
    public String phone;
}
