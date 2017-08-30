package com.q8coders.codequality.utility.helper;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

/**
 * Created by shahid on 8/30/2017.
 */



public abstract class MyMessageDialog {

    public MyMessageDialog(Activity activity, String title, String message, String setPosButton){

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);

        builder.setPositiveButton(setPosButton, (dialog, id) -> {
                    dialogPositiveClicked();
                    dialog.dismiss();
                });



        AlertDialog alert11 = builder.create();
        alert11.show();
    }

    public abstract void dialogPositiveClicked();


}
