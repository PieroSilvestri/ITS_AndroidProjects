package com.example.piero.masterdetail2;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Button_fragment.IOnButtonSelected{

    private final static String FRAGMENT_TAG = "current fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Il fragment lo aggiungo sulla interfaccia grafica
        if(getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG) == null){

            //Abbiamo fatto partire la transaction
            FragmentTransaction vTr = getSupportFragmentManager().beginTransaction();

            //Abbiamo aggiunto il nostro fragment
            vTr.add(R.id.button_container, Button_fragment.getInstance(), FRAGMENT_TAG);
            vTr.commit();
        }

    }

    @Override
    public void onUpdateValue(String aCurrentValue) {
        Log.d("TEST", aCurrentValue);

        FragmentTransaction vTrans = getSupportFragmentManager().beginTransaction();

            vTrans.replace(R.id.button_container, BlankFragment.getInstance(aCurrentValue), FRAGMENT_TAG);
            vTrans.addToBackStack("pippo");
        vTrans.commit();
    }
}
