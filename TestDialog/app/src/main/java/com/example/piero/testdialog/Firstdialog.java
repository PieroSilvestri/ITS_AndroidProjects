package com.example.piero.testdialog;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by piero on 06/05/2016.
 */
public class Firstdialog extends DialogFragment {

    private static final String TITLE = "Titolo";
    private static final String MESSAGE = "Messaggio";

    public  interface IDIalogAnswer{
        void onYes();
        void onNo();
    }

    private IDIalogAnswer mListener = new IDIalogAnswer() {
        @Override
        public void onYes() {
        }

        @Override
        public void onNo() {

        }
    };

    public static Firstdialog getInstance(String aTitle, String aMessage){
        Firstdialog vFrag = new Firstdialog();

        Bundle vBundle = new Bundle();
        vBundle.putString(TITLE, aTitle);
        vBundle.putString(MESSAGE, aMessage);

        vFrag.setArguments(vBundle);

        return vFrag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        Bundle vBundle = getArguments();

        builder.setTitle(vBundle.getString(TITLE));
        builder.setMessage(vBundle.getString(MESSAGE))
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        mListener.onYes();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        mListener.onNo();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof IDIalogAnswer){
            mListener = (IDIalogAnswer)activity;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
