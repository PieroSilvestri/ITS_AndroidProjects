package com.example.piero.fragmentsimple;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    private static final String TAG = "Mio Tag";
    private final static String FRAGMENT_TAG = "current fragment";

    MyFragment mCounterFragment = new MyFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Il fragment lo aggiungo sulla interfaccia grafica
        if(getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG) == null){

            //Abbiamo fatto partire la transaction
            FragmentTransaction vTr = getSupportFragmentManager().beginTransaction();


            //Abbiamo aggiunto il nostro fragment
            vTr.add(R.id.container, mCounterFragment, FRAGMENT_TAG);
            vTr.commit();
        }


            //Abbiamo fatto partire la transaction

        Button vBtn = (Button)findViewById(R.id.button);
        vBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounterFragment.cambiaTesto("Ciao");
            }
        });

    }
}
