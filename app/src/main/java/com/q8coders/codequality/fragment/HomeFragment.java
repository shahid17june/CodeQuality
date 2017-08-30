package com.q8coders.codequality.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.q8coders.codequality.R;
import com.q8coders.codequality.utility.MyUtility;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by shahid on 8/30/2017.
 */

public class HomeFragment extends Fragment {
    private View view;
    private ActionBar actionBar;
    private Activity activity;
    private MyListner myListner;
    private AVLoadingIndicatorView avLoadingIndicatorView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        actionBar = MyUtility.setUpActionBar(activity);
    }

    public void setHelper(MyListner myListner){
        this.myListner = myListner;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.home_fragment, container, false);
            avLoadingIndicatorView = view.findViewById(R.id.avi);
            RecyclerView recyclerView = view.findViewById(R.id.recylerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));

            myListner.setUpList(recyclerView);

        }


        return view;
    }

    public void showOrHideLoader(int visibilty) {
        avLoadingIndicatorView.setVisibility(visibilty);
    }

    @Override
    public void onResume() {
        super.onResume();
        actionBar.setTitle(activity.getString(R.string.title_home));
    }

    public interface MyListner{
        void setUpList(RecyclerView recyclerView);
    }
}
