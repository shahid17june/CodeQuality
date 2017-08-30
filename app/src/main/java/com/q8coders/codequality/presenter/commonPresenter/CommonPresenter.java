package com.q8coders.codequality.presenter.commonPresenter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.q8coders.codequality.fragment.CommonFragment;
import com.q8coders.codequality.fragment.HomeFragment;
import com.q8coders.codequality.utility.MyConstant;
import com.q8coders.codequality.utility.MyUtility;

/**
 * Created by shahid on 8/30/2017.
 */

public class CommonPresenter {

    private FragmentActivity activity;
    private CommonFragment commonFragment;


    public CommonPresenter(FragmentActivity activity) {
        this.activity = activity;

    }

    public void createFragment(String TAG) {
        commonFragment = new CommonFragment();

        Bundle bundle = new Bundle();
        bundle.putString(MyConstant.COMING_FROM,TAG);
        commonFragment.setArguments(bundle);
        MyUtility.navigateTo(activity, commonFragment, MyConstant.TAG_HOME, false);
    }

}
