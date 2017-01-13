package com.example.piero.contatore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {


    public MainActivity() {
        super();
    }

    private TextView mEtichetta;
    private int mCounter;

    private static final String TAG = "TEST_ACTIVITY";
    private static final String MIO_CONTATORE = "Mio_contatore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "M:onCreate");
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            mCounter = savedInstanceState.getInt(MIO_CONTATORE);
        }

        mEtichetta = (TextView)findViewById(R.id.etichetta);

        Button vBtnPiu = (Button)findViewById(R.id.piu);
        vBtnPiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter++;
                updateGUI();
            }
        });
        Button vBtnMeno = (Button)findViewById(R.id.meno);
        vBtnMeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter--;
                updateGUI();
            }
        });

        Button vNext = (Button)findViewById(R.id.btnNext);
        vNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity();
            }
        });

        updateGUI();
    }
    private  void updateGUI(){
        mEtichetta.setText("" + mCounter);
    }


    // Medoto per lanciare una nuova activity
    private void launchActivity(){
        Intent vIntent = new Intent(this, DetailActivity.class);
        Bundle vBundle = new Bundle();

        vBundle.putInt(DetailActivity.VALORE, mCounter);
        vIntent.putExtras(vBundle);

        startActivity(vIntent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "M:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "M:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "M:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "M:onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "M:onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MIO_CONTATORE, mCounter);
        Log.d(TAG, "M:onSaveInstance");
    }
}
