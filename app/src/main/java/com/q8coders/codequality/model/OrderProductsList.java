package com.q8coders.codequality.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by shahid on 8/30/2017.
 */


public class OrderProductsList {

    @SerializedName("id")
    public int id;

/*    @SerializedName("product")
    public OrderProductModel product;*/

    @SerializedName("price")
    public float price;

    @SerializedName("quantity")
    public int quantity;

    @SerializedName("note")
    public String note;

/*    @SerializedName("field_values")
    public List<OrderFieldsListJson> field_values;*/

}
