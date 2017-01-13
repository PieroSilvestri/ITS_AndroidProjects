package com.example.piero.contatore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "TEST_ACTIVITY";
    private  static final  String CONTATORE3 = "contatore_moltiplicato_molte_volte";
    private  static final  String CONTATORE4 = "contatore_moltiplicato_n_volte";
    public static final String VALORE = "valore";

    private int xCounter = 0;
    private int yCounter = 0;

    TextView xTextView;
    TextView yTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle vBundle = getIntent().getExtras();
        if (vBundle != null) {
            xCounter = vBundle.getInt(VALORE);
            yCounter = xCounter;
        }

        if (savedInstanceState != null) {
            yCounter = savedInstanceState.getInt(CONTATORE4);
        }


        xTextView = (TextView) findViewById(R.id.startValueText);
        xTextView.setText("" + xCounter);

        yTextView = (TextView)findViewById(R.id.textView3);
        yTextView.setText("" + yCounter);



        Button xBtn1 = (Button)findViewById(R.id.buttonX3);
        xBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yCounter = yCounter * 3;
                yTextView.setText("" + yCounter);
            }
        });

        Button xBtn2 = (Button)findViewById(R.id.buttonX4);
        xBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yCounter = yCounter * 4;
                yTextView.setText("" + yCounter);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, this + "D:onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,this + "D:onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,this + "D:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,this + "D:onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,this + "D:onStop");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, this + "D:onSaveInstance");
        // Salvo lo stato della mia variabile xCounter
        outState.putInt(CONTATORE4, yCounter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, this + "D:onDestroy");
    }
}
