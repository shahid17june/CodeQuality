package com.q8coders.codequality.presenter.homePresenter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.q8coders.codequality.R;
import com.q8coders.codequality.adapter.InVoiceAdapter;
import com.q8coders.codequality.fragment.HomeFragment;
import com.q8coders.codequality.model.InVoiceModel;
import com.q8coders.codequality.modelView.InVoiceModelView;
import com.q8coders.codequality.network.BackEndCallBack;
import com.q8coders.codequality.utility.MyConstant;
import com.q8coders.codequality.utility.MyUtility;
import com.q8coders.codequality.utility.helper.MyMessageDialog;
import com.q8coders.codequality.utility.helper.MyRecylerClickListner;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shahid on 8/30/2017.
 */

public class HomePresenter implements HomeFragment.MyListner, BackEndCallBack, MyRecylerClickListner {
    private FragmentActivity activity;
    private HomeFragment homeFragment;

    private InVoiceModelView inVoiceModelView;
    private List<InVoiceModel> inVoiceList;
    private InVoiceAdapter inVoiceAdapter;
    private int page = 1;


    public HomePresenter(FragmentActivity activity) {
        this.activity = activity;
        inVoiceModelView = new InVoiceModelView(this, activity);
        inVoiceList = new LinkedList<>();


    }

    public void createFragment() {
        homeFragment = new HomeFragment();
        homeFragment.setHelper(this);
        MyUtility.navigateTo(activity, homeFragment, MyConstant.TAG_HOME, true);
    }


    @Override
    public void setUpList(RecyclerView recyclerView) {
        inVoiceAdapter = new InVoiceAdapter(inVoiceList);
        recyclerView.setAdapter(inVoiceAdapter);

        inVoiceAdapter.setClickListner(this);

        inVoiceModelView.getListOfInvoice(11, page);

    }

    private void notifyList() {
        inVoiceAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess() {
        homeFragment.showOrHideLoader(View.GONE);
        inVoiceList.addAll(inVoiceModelView.list);
        notifyList();

    }

    @Override
    public void onFailure() {
        homeFragment.showOrHideLoader(View.GONE);

    }

    @Override
    public void onPrepare() {
        homeFragment.showOrHideLoader(View.VISIBLE);

    }

    @Override
    public void networkError() {
        Toast.makeText(activity, activity.getString(R.string.internet_connection_issue), Toast.LENGTH_LONG).show();
    }

    @Override
    public void click(int position, String taskIdentifier) {

        String posButton = activity.getResources().getString(R.string.ok);
        String title = activity.getResources().getString(R.string.dialog_title);

        new MyMessageDialog(activity,title,inVoiceList.get(position).invoice_no,posButton ){
            @Override
            public void dialogPositiveClicked() {

            }
        };


    }
}
