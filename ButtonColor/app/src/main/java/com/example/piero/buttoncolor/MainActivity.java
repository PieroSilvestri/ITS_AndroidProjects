package com.example.piero.buttoncolor;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements ButtonFragment.IOnButtonSelected, DetailFragment.IOnChangeColor{

    private static final String TAG = "Mio Tag";
    private final static String FRAGMENT_TAG = "Button Fragment";
    private final static String FRAGMENT_TAG2 = "Detail Fragment";

    ButtonFragment buttonFragment = new ButtonFragment();
    DetailFragment detailFragment = new DetailFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG) == null){

            //Abbiamo fatto partire la transaction
            FragmentTransaction vTr = getSupportFragmentManager().beginTransaction();


            //Abbiamo aggiunto il nostro fragment
            vTr.add(R.id.container, buttonFragment, FRAGMENT_TAG);
            vTr.commit();
        }
    }

    @Override
    public void onUpdateValue(String aCurrentValue) {
        FragmentTransaction vTr = getSupportFragmentManager().beginTransaction();

        //Abbiamo aggiunto il nostro fragment
        vTr.replace(R.id.container, detailFragment.getInstance(aCurrentValue), FRAGMENT_TAG2);
        vTr.commit();
    }

    @Override
    public void onChangeColor(String buttonValue, String colorValue) {
        FragmentTransaction vTr = getSupportFragmentManager().beginTransaction();


        //Abbiamo aggiunto il nostro fragment
        vTr.replace(R.id.container, buttonFragment.getInstance(buttonValue, colorValue), FRAGMENT_TAG);
        vTr.commit();
    }
}
