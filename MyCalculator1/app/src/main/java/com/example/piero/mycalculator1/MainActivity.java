package com.example.piero.mycalculator1;

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
    private String mCounter = "";
    private double conteggio = 1;
    private double x1;
    private double x2;
    private boolean punto;
    private String segno = "";

    private static final String TAG = "TEST_CONTATORE";
    private static final String MIO_CONTATORE = "Mio_contatore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "M:onCreate");
        setContentView(R.layout.activity_main);

        mEtichetta = (TextView)findViewById(R.id.display);

        //Faccio l'ascolto dei tasti numerici
        {
            Button btn0 = (Button)findViewById(R.id.btn0);
            btn0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCounter = mCounter + "0";
                    updateGUI();
                }
            });

            Button btn1 = (Button) findViewById(R.id.btn1);
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mCounter == "0" || mCounter == "0.0"){
                        mCounter = "1";
                    }
                    else{
                        mCounter = mCounter + "1";
                    }

                    updateGUI();
                }
            });

            Button btn2 = (Button) findViewById(R.id.btn2);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mCounter == "0" || mCounter == "0.0"){
                        mCounter = "2";
                    }
                    else {
                        mCounter = mCounter + "2";
                    }
                    updateGUI();
                }
            });

            Button btn3 = (Button) findViewById(R.id.btn3);
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mCounter == "0" || mCounter == "0.0"){
                        mCounter = "3";
                    }
                    else {
                        mCounter = mCounter + "3";
                    }
                    updateGUI();
                }
            });

            Button btn4 = (Button) findViewById(R.id.btn4);
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mCounter == "0" || mCounter == "0.0"){
                        mCounter = "4";
                    }
                    else {
                        mCounter = mCounter + "4";
                    }
                    updateGUI();
                }
            });

            Button btn5 = (Button) findViewById(R.id.btn5);
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mCounter == "0" || mCounter == "0.0"){
                        mCounter = "5";
                    }
                    else {
                        mCounter = mCounter + "5";
                    }
                    updateGUI();
                }
            });

            Button btn6 = (Button) findViewById(R.id.btn6);
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mCounter == "0" || mCounter == "0.0"){
                        mCounter = "6";
                    }
                    else {
                        mCounter = mCounter + "6";
                    }
                    updateGUI();
                }
            });

            Button btn7 = (Button) findViewById(R.id.btn7);
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mCounter == "0" || mCounter == "0.0"){
                        mCounter = "7";
                    }
                    else {
                        mCounter = mCounter + "7";
                    }
                    updateGUI();
                }
            });

            Button btn8 = (Button) findViewById(R.id.btn8);
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mCounter == "0" || mCounter == "0.0"){
                        mCounter = "8";
                    }
                    else {
                        mCounter = mCounter + "8";
                    }
                    updateGUI();
                }
            });

            Button btn9 = (Button) findViewById(R.id.btn9);
            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mCounter == "0" || mCounter == "0.0"){
                        mCounter = "9";
                    }
                    else {
                        mCounter = mCounter + "9";
                    }
                    updateGUI();
                }
            });
        }


        //Faccio l'ascolto degli altri tasti
        {
            Button btnPiu = (Button) findViewById(R.id.btnPiu);
            btnPiu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    x1 = Double.parseDouble(mCounter);
                    mCounter = mCounter + "+";
                    updateGUI();
                    mCounter = "";
                    segno = "+";
                }
            });

            Button btnMeno = (Button) findViewById(R.id.btnMeno);
            btnMeno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    x1 = Double.parseDouble(mCounter);
                    mCounter = mCounter + "-";
                    updateGUI();
                    mCounter = "";
                    segno = "-";
                }
            });

            Button btnMolt = (Button) findViewById(R.id.btnMolt);
            btnMolt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    x1 = Double.parseDouble(mCounter);
                    mCounter = mCounter + "x";
                    updateGUI();
                    mCounter = "";
                    segno = "x";
                }
            });

            Button btnDiv = (Button) findViewById(R.id.btnDiv);
            btnDiv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    x1 = Double.parseDouble(mCounter);
                    mCounter = mCounter + "/";
                    updateGUI();
                    mCounter = "";
                    segno = "/";
                }
            });
        }

        // Altri tasti
        {
            Button btnUguale = (Button) findViewById(R.id.btnUguale);
            btnUguale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    x2 = Double.parseDouble(mCounter);
                    if (segno == "+") {
                        conteggio = x1 + x2;
                    } else if (segno == "-") {
                        conteggio = x1 - x2;
                    } else if (segno == "x") {
                        conteggio = x1 * x2;
                    } else if (segno == "/") {
                        conteggio = x1 / x2;
                    }
                    mCounter = String.valueOf(conteggio);
                    updateGUI();
                }
            });

            Button btnC = (Button) findViewById(R.id.btnC);
            btnC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    x1 = 0;
                    x2 = 0;
                    conteggio = 0;
                    segno = "";
                    punto = false;
                    mCounter = String.valueOf(conteggio);
                    updateGUI();
                }
            });

            Button btnVirgola = (Button) findViewById(R.id.btnVirg);
            btnVirgola.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(punto == true){

                    }
                    else {
                        mCounter = mCounter + ".";
                        punto = true;
                    }
                    updateGUI();
                }
            });


        }

    }

    private  void updateGUI(){
        mEtichetta.setText(mCounter);
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

}
