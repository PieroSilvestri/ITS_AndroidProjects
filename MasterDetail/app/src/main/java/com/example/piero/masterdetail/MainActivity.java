package com.example.piero.masterdetail;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements BlankFragment.IOnButtonSelected, FragmentDetail.IOnButtonSelectedDetail{

    private final static String FRAGMENT_TAG = "current fragment";
    private final static String FRAGMENT_COLOR = "current fragment color";
    private boolean mHasDetail = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Esiste un container che si chiama detail_container?
        if(findViewById(R.id.detail_container) != null){
            // Se true sono in un tablet
            mHasDetail = true;
        }

        // Il fragment lo aggiungo sulla interfaccia grafica
        if(getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG) == null){

            //Abbiamo fatto partire la transaction
            FragmentTransaction vTr = getSupportFragmentManager().beginTransaction();

            //Abbiamo aggiunto il nostro fragment
            vTr.add(R.id.container, BlankFragment.getInstance(), FRAGMENT_TAG);
            vTr.commit();
        }

    }

    @Override
    public void onUpdateValue(String aCurrentValue) {
        Log.d("TEST", aCurrentValue);

        FragmentTransaction vTrans = getSupportFragmentManager().beginTransaction();

        if(mHasDetail){
            vTrans.replace(R.id.detail_container, FragmentDetail.getInstance(aCurrentValue));
        }
        else {
            vTrans.replace(R.id.container, FragmentDetail.getInstance(aCurrentValue), FRAGMENT_TAG);
            vTrans.addToBackStack("pippo");
        }
        vTrans.commit();
    }

    @Override
    public void onUpdateValueDetail(String aCurrentValue) {
        Log.d("TEST A: ", "Il colore è: " + aCurrentValue);


        FragmentTransaction vTrans = getSupportFragmentManager().beginTransaction();
        vTrans.replace(R.id.container, BlankFragment.getColor(aCurrentValue));

        vTrans.commit();

    }
}
