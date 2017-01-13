package com.example.piero.testdialog;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by piero on 06/05/2016.
 */
public class SecondDialog extends DialogFragment {

    private static final String TITLE = "Titolo";
    private static final String MESSAGE = "Messaggio";

    public  interface ISecondDIalogAnswer{
        void listValue(String valore);
    }

    private ISecondDIalogAnswer mListener = new ISecondDIalogAnswer() {
        @Override
        public void listValue(String valore){

        }

    };

    public static SecondDialog getInstance(String aTitle, String aMessage){
        SecondDialog vFrag = new SecondDialog();

        Bundle vBundle = new Bundle();
        vBundle.putString(TITLE, aTitle);
        vBundle.putString(MESSAGE, aMessage);

        vFrag.setArguments(vBundle);

        return vFrag;
    }

    String array[] = {"Ciao", "Miao", "Bau"};


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle vBundle = new Bundle();

        // Set the dialog title
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(vBundle.getString(TITLE))
                .setItems(array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        Log.d("VALORE ", array[which]);
                        mListener.listValue(array[which]);
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof ISecondDIalogAnswer){
            mListener = (ISecondDIalogAnswer)activity;
        }
    }

}
