package com.example.piero.silvestripiero;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by piero on 06/05/2016.
 */
public class Firstdialog extends DialogFragment {

    private static final String VALORE = "valore";
    private static final String MESSAGE = "Messaggio";
    private int valore;

    public  interface IDIalogAnswer{
        void onYes(int value);
        void onNo();
    }

    private IDIalogAnswer mListener = new IDIalogAnswer() {
        @Override
        public void onYes(int value) {
        }

        @Override
        public void onNo() {

        }
    };

    public static Firstdialog getInstance(int aValue){
        Firstdialog vFrag = new Firstdialog();

        Bundle vBundle = new Bundle();
        vBundle.putInt(VALORE, aValue);

        vFrag.setArguments(vBundle);

        return vFrag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        Bundle vBundle = getArguments();
        if(vBundle != null){
            valore = vBundle.getInt(VALORE) * 2;

        }
        builder.setTitle("RADDOPPIO");
        builder.setMessage("Vuoi raddoppiare?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        mListener.onYes(valore);
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
