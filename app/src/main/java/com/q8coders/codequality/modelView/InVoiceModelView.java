package com.q8coders.codequality.modelView;

import android.app.Activity;
import android.widget.Toast;
import com.q8coders.codequality.R;
import com.q8coders.codequality.model.InVoiceJsonModel;
import com.q8coders.codequality.model.InVoiceModel;
import com.q8coders.codequality.network.BackEndCallBack;
import com.q8coders.codequality.network.NetworkApiRequest;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeoutException;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by shahid on 8/30/2017.
 */


public class InVoiceModelView implements BackEndCallBack {

    private BackEndCallBack callBack;
    private Activity mContext;
    public int count;
    public List<InVoiceModel> list;

    public InVoiceModelView(BackEndCallBack callBack, Activity mContext) {
        this.callBack = callBack;
        this.mContext = mContext;
    }

    public void getListOfInvoice(int memberId, int page) {
        callBack.onPrepare();
        NetworkApiRequest.getRetrofitAPiInstance().getListOfInvoice(memberId, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError);
    }

    private void handleResponse(InVoiceJsonModel inVoiceJsonModel) {
        count = inVoiceJsonModel.count;
        list = inVoiceJsonModel.results;
        callBack.onSuccess();

    }

    private void handleError(Throwable error) {
        callBack.onFailure();

        if (error instanceof TimeoutException || error instanceof SocketException || error instanceof UnknownHostException) {
            callBack.networkError();

        } else {
            Toast.makeText(mContext, mContext.getString(R.string.somethingwrong), Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onPrepare() {

    }

    @Override
    public void networkError() {

    }
}
