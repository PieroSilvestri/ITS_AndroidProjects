package com.example.piero.fragment_support;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by piero on 22/04/2016.
 */
public class FirstDialog extends DialogFragment {

    private static final String DIALOG_VALUE = "string di partenza";

    private String dTextView;

    public interface IOndialogSelected{
        public void onButtonSelected(String a);
    }

    public static FirstDialog getInstance(){
        return new FirstDialog();
    }

    public static FirstDialog getInstance(String startValue){

        FirstDialog vDialog = new FirstDialog();

        Bundle vBundle = new Bundle();
        vBundle.putString(DIALOG_VALUE, startValue);
        vDialog.setArguments(vBundle);

        return vDialog;
    }

    private  IOndialogSelected mListener = new IOndialogSelected() {
        @Override
        public void onButtonSelected(String a) {

        }
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder vBuilder = new AlertDialog.Builder(getActivity());
        vBuilder.setMessage(dTextView);

        vBuilder.setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DIALOG", "" + which);
                mListener.onButtonSelected("+++");
            }
        });

        vBuilder.setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DIALOG", "" + which);
                mListener.onButtonSelected("---");
            }
        });
        vBuilder.setNeutralButton("Neutrale", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DIALOG", "" + which);
                mListener.onButtonSelected("!!!");
            }
        });


        return vBuilder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(getActivity() instanceof IOndialogSelected){
            mListener = (IOndialogSelected)getActivity();
        }
    }
}
