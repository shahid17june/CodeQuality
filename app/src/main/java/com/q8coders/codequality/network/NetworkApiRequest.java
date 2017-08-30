package com.q8coders.codequality.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.q8coders.codequality.utility.MyConstant.BASE_URL;

/**
 * Created by shahid on 8/30/2017.
 */


public class NetworkApiRequest {

    private NetworkApiRequest(){
    }

    public  static Gson getGsonInstance(){
      return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
    }


    private static Retrofit getRetrofitInstance(Gson gson){
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();

    }

    public static RetrofitApi getRetrofitAPiInstance(){
        return NetworkApiRequest.getRetrofitInstance(NetworkApiRequest.getGsonInstance()).create(RetrofitApi.class);
    }


}
