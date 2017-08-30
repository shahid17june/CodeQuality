package com.q8coders.codequality.model;

import com.google.gson.annotations.SerializedName;
import com.q8coders.codequality.model.addressModel.AddressModel;
import com.q8coders.codequality.model.branchModel.BranchModel;

import java.util.List;

/**
 * Created by shahid on 8/30/2017.
 */

public class InVoiceOrderModel {

    @SerializedName("id")
    public int id;

    @SerializedName("delivery_address")
    public AddressModel delivery_address;

    @SerializedName("status")
    public String status;

    @SerializedName("totalPrice")
    public float totalPrice;

    @SerializedName("created_time")
    public String created_time;

    @SerializedName("order_products")
    public List<OrderProductsList> order_products;

    @SerializedName("branch")
    public BranchModel branch;

    @SerializedName("serial_no")
    public String serial_no;

    @SerializedName("cons_member")
    public MemberModel1 cons_member;

    @SerializedName("customer")
    public CustomerModel customer;

    @SerializedName("customer_address")
    public AddressModel customer_address;

    @SerializedName("is_invoiced")
    public boolean is_invoiced;


}
