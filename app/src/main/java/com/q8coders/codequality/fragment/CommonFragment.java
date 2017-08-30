package com.q8coders.codequality.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.q8coders.codequality.R;
import com.q8coders.codequality.utility.MyConstant;
import com.q8coders.codequality.utility.MyUtility;

/**
 * Created by shahid on 8/30/2017.
 */

public class CommonFragment extends Fragment {
    private View view;
    private String text;
    private ActionBar actionBar;
    private Activity activity;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        actionBar = MyUtility.setUpActionBar(activity);

        Bundle bundle = getArguments();
        text = bundle.getString(MyConstant.COMING_FROM);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view==null){

            view = inflater.inflate(R.layout.common_layout, container, false);
            TextView textView = view.findViewById(R.id.textView);

            textView.setText(getString());
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        actionBar.setTitle(getString());
    }

    private String getString(){
        String my_text;
        if (text.equals(MyConstant.TAG_DASHBOARD))
            my_text =activity.getString(R.string.title_dashboard);
        else
            my_text = activity.getString(R.string.title_notifications);

        return my_text;
    }

}
