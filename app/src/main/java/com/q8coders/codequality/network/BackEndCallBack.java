package com.q8coders.codequality.network;

/**
 * Created by shahid on 8/30/2017.
 */


public interface BackEndCallBack {

    void onSuccess();

    void onFailure();

    void onPrepare();

    void networkError();

}
