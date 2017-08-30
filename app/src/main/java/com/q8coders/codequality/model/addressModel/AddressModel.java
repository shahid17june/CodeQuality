package com.q8coders.codequality.model.addressModel;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shahid on 8/30/2017.
 */


public class AddressModel implements Parcelable {

    @SerializedName("id")
    public int id;

    @SerializedName("phone")
    public String phone;

    @SerializedName("name")
    public String name;

    @SerializedName("block")
    public String block;

    @SerializedName("street")
    public String street;

    @SerializedName("house")
    public String house;

    @SerializedName("apartment")
    public String apartment;

    @SerializedName("floor")
    public String floor;

    @SerializedName("extra_directions")
    public String extra_directions;

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("longitude")
    public double longitude;

    @SerializedName("is_default")
    public boolean is_default;

    @SerializedName("member")
    public int member;

    protected AddressModel(Parcel in) {
        id = in.readInt();
        phone = in.readString();
        name = in.readString();
        block = in.readString();
        street = in.readString();
        house = in.readString();
        apartment = in.readString();
        floor = in.readString();
        extra_directions = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        is_default = in.readByte() != 0;
        member = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(phone);
        dest.writeString(name);
        dest.writeString(block);
        dest.writeString(street);
        dest.writeString(house);
        dest.writeString(apartment);
        dest.writeString(floor);
        dest.writeString(extra_directions);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeByte((byte) (is_default ? 1 : 0));
        dest.writeInt(member);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AddressModel> CREATOR = new Creator<AddressModel>() {
        @Override
        public AddressModel createFromParcel(Parcel in) {
            return new AddressModel(in);
        }

        @Override
        public AddressModel[] newArray(int size) {
            return new AddressModel[size];
        }
    };
}
