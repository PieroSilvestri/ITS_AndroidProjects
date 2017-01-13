package com.example.piero.silvestripiero;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements ButtonFragment.TripleSelected, Firstdialog.IDIalogAnswer, Resetdialog.IDIalogAnswer{

    private final static String TAG = "Main";
    private final static String FRAGMENT_TAG = "Main Fragment";
    private final static String FRAGMENT_TAG2 = "Triple Fragment";
    ButtonFragment buttonFragment = new ButtonFragment();
    TripleFragment tripleFragment = new TripleFragment();

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
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstance");
    }

    @Override
    public void onYes(int value) {
        FragmentTransaction vTr = getSupportFragmentManager().beginTransaction();

        //Abbiamo aggiunto il nostro fragment
        vTr.replace(R.id.container, buttonFragment.getInstance(value), FRAGMENT_TAG);
        vTr.commit();
    }

    @Override
    public void onNo() {
    }

    @Override
    public void onResetYes() {
        FragmentTransaction vTr = getSupportFragmentManager().beginTransaction();

        //Abbiamo aggiunto il nostro fragment
        vTr.replace(R.id.container, buttonFragment.getInstance(0), FRAGMENT_TAG);
        vTr.commit();
    }

    @Override
    public void onResetNo() {

    }

    @Override
    public void tripleFragment(int aCurrentValue) {
        FragmentTransaction vTr = getSupportFragmentManager().beginTransaction();

        //Abbiamo aggiunto il nostro fragment
        vTr.replace(R.id.container, tripleFragment.getInstance(aCurrentValue), FRAGMENT_TAG2);
        vTr.addToBackStack("ButtonFragment");
        vTr.commit();
    }
}
