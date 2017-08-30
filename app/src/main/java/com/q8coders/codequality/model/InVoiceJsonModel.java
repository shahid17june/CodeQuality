package com.q8coders.codequality.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shahid on 8/30/2017.
 */


public class InVoiceJsonModel {

    @SerializedName("count")
    public int count;

    @SerializedName("next")
    public String next;

    @SerializedName("previous")
    public String previous;

    @SerializedName("results")
    public List<InVoiceModel> results;
}
