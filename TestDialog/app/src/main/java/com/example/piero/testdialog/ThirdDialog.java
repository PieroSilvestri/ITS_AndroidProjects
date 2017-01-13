package com.example.piero.testdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by piero on 06/05/2016.
 */
public class ThirdDialog extends DialogFragment {

    private static final String TITLE = "Titolo";
    private static final String MESSAGE = "Messaggio";

    public  interface IThirdDIalogAnswer{
        void listValueThird(String[] valore, ArrayList<Integer> ArrayList);
    }

    private IThirdDIalogAnswer mListener = new IThirdDIalogAnswer() {
        @Override
        public void listValueThird(String[] valore, ArrayList<Integer> ArrayList){

        }

    };


    public static ThirdDialog getInstance(String aTitle, String aMessage){
        ThirdDialog vFrag = new ThirdDialog();

        Bundle vBundle = new Bundle();
        vBundle.putString(TITLE, aTitle);
        vBundle.putString(MESSAGE, aMessage);

        vFrag.setArguments(vBundle);

        return vFrag;
    }

    String array[] = {"Gelato", "Carne", "Pesce"};
    ArrayList<Integer> mSelectedItems;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mSelectedItems = new ArrayList();  // Where we track the selected items

        Bundle vBundle = new Bundle();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Set the dialog title
        builder.setTitle(vBundle.getString(TITLE))
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setMultiChoiceItems(array, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedItems.add(which);
                                } else if (mSelectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                        // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        mListener.listValueThird(array, mSelectedItems);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof IThirdDIalogAnswer){
            mListener = (IThirdDIalogAnswer)activity;
        }
    }

}
