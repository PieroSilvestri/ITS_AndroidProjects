package com.example.piero.contatore;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends Activity {

    private static final String TAG = "TEST_ACTIVITY";
    private  static final  String CONTATORE = "contatore_raddoppiato_molte_volte";
    public static final String VALORE = "valore";

    int mCounter = 0;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this + "D:onCreate");
        setContentView(R.layout.activity_detail);

        // Prendo il riferimento all'altra activity

        Bundle vBundle = getIntent().getExtras();
        if (vBundle != null) {
            mCounter = vBundle.getInt(VALORE);
        }

        if (savedInstanceState != null) {
            mCounter = savedInstanceState.getInt(CONTATORE);
        }


        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText("" + mCounter);

        Button vBtn = (Button) findViewById(R.id.button);
        vBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter = mCounter * 2;
                mTextView.setText("" + mCounter);
            }
        });

        Button vBtn2 = (Button) findViewById(R.id.button2);
        vBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vIntent = new Intent(DetailActivity.this, DetailActivity.class);
                Bundle vBundle = new Bundle();
                vBundle.putInt(DetailActivity.VALORE, mCounter);

                vIntent.putExtras(vBundle);
                startActivity(vIntent);
            }
        });

        Button vBtn3 = (Button) findViewById(R.id.button3);
        vBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mIntent = new Intent(DetailActivity.this, ThirdActivity.class);
                Bundle vBundle = new Bundle();

                vBundle.putInt(DetailActivity.VALORE, mCounter);
                mIntent.putExtras(vBundle);

                startActivity(mIntent);
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,this + "D:onStart");
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
        Log.d(TAG,this + "D:onSaveInstance");
        // Salvo lo stato della mia variabile vCounter
        outState.putInt(CONTATORE, mCounter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,this + "D:onDestroy");
    }
}
