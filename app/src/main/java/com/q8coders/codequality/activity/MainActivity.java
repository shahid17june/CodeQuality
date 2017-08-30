package com.q8coders.codequality.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.q8coders.codequality.R;
import com.q8coders.codequality.presenter.commonPresenter.CommonPresenter;
import com.q8coders.codequality.presenter.homePresenter.HomePresenter;
import com.q8coders.codequality.utility.MyConstant;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {

        switch (item.getItemId()) {
            case R.id.navigation_home:
                new HomePresenter(this).createFragment();
                break;

            case R.id.navigation_dashboard:
                new CommonPresenter(this).createFragment(MyConstant.TAG_DASHBOARD);
                break;

            case R.id.navigation_notifications:
                new CommonPresenter(this).createFragment(MyConstant.TAG_NOTIFICATION);
                break;

        }

        return true;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //set home menu
        Menu menu = navigation.getMenu();
        MenuItem homeMenuItem = menu.findItem(R.id.navigation_home);
        mOnNavigationItemSelectedListener.onNavigationItemSelected(homeMenuItem);

    }

}
