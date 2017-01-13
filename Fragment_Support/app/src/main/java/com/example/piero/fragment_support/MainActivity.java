package com.example.piero.fragment_support;

import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentSelector.IOnButtonSelected, FirstDialog.IOndialogSelected{

    private final static String FRAGMENT_TAG = "current fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getSupportFragmentManager()
        if(getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG) == null){

            //Abbiamo fatto partire la transaction
            FragmentTransaction vTr = getSupportFragmentManager().beginTransaction();

            //Abbiamo aggiunto il nostro fragment
            vTr.add(R.id.container, FragmentSelector.getInstance("pippo"), FRAGMENT_TAG);
            vTr.commit();
        }

    }
    @Override
    public void onUpdateValue(String aCurrentValue){
        Log.d("TEST", aCurrentValue);


        /*
        FragmentTransaction vTrans = getSupportFragmentManager().beginTransaction();
        // Tolgo il fragment di prima e lo sostituisco con quello nuovo
        vTrans.replace(R.id.container, FragmentSelector.getInstance(aCurrentValue));
        vTrans.addToBackStack(null);
        vTrans.commit();
        */

        FirstDialog vDialog = FirstDialog.getInstance();
        vDialog.show(getSupportFragmentManager(), "DIALOG");
    }


    @Override
    public void onButtonSelected(String a) {
        getSupportActionBar().setTitle(a);
    }

}
