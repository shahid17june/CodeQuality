package com.q8coders.codequality.network;

import com.q8coders.codequality.model.InVoiceJsonModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by shahid on 8/30/2017.
 */

public interface RetrofitApi {

    //get List of Invoice
    @GET("api/drivers/{member_id}/invoices/")
    Observable<InVoiceJsonModel> getListOfInvoice(@Path("member_id") int member_id,
                                                  @Query("page") int page);
}
