package com.q8coders.codequality.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shahid on 8/30/2017.
 */

public class InVoiceModel {

    @SerializedName("id")
    public int id;

    @SerializedName("order")
    public InVoiceOrderModel order;

    @SerializedName("employee")
    public MemberModel1 employee;

    @SerializedName("created_time")
    public String created_time;

    @SerializedName("invoice_no")
    public String invoice_no;
}
