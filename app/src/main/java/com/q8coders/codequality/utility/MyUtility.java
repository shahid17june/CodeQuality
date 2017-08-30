package com.q8coders.codequality.utility;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.q8coders.codequality.R;

/**
 * Created by shahid on 8/30/2017.
 */

public class MyUtility {

    public static void navigateTo(FragmentActivity activity, Fragment mFragment, String TAG, boolean isBackStack) {

        FragmentTransaction fragmentManager = activity.getSupportFragmentManager().beginTransaction();
        fragmentManager.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        if (isBackStack)
            fragmentManager.addToBackStack(null);

        fragmentManager.replace(R.id.content, mFragment, TAG).commit();
    }


    public static ActionBar setUpActionBar(Activity activity) {
        ActionBar actionBar = null;
        if (activity != null) {
            actionBar = ((AppCompatActivity) activity).getSupportActionBar();
        }
        return actionBar;
    }

}
