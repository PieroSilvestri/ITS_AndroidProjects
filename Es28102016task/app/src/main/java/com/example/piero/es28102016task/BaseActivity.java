package com.example.piero.es28102016task;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public abstract class BaseActivity extends Activity {

    private static final String DATE = "DATE";

    String mCreate;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(DATE, mCreate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.getActionBar().setTitle(this.getName());
        if(savedInstanceState == null){
            Date mDate = new Date();
            mCreate = mDate.toString();
        }else{
            mCreate = savedInstanceState.getString(DATE);
        }
        setupGUI();
    }

    protected abstract String getName();

    private void setupGUI(){
        Button vBtnA = (Button) findViewById(R.id.btnA);
        vBtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchA();
            }
        });

        Button vBtnB = (Button) findViewById(R.id.btnB);
        vBtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchB();
            }
        });

        Button vBtnC = (Button) findViewById(R.id.btnC);
        vBtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchC();
            }
        });

        Button vBtnD = (Button) findViewById(R.id.btnD);
        vBtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchD();
            }
        });

        Button vBtnMain = (Button) findViewById(R.id.btnMain);
        vBtnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMain();
            }
        });

        Button vBtnNotifica = (Button) findViewById(R.id.btnNotifica);
        vBtnNotifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNotifica();
            }
        });

        TextView textView1 = (TextView) findViewById(R.id.textView);
        textView1.setText(mCreate);

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(getName());
    }

    protected void launchA(){
        // definisco l'intenzione di aprire l'Activity "MainActivity.java"
        Intent openA = new Intent(this, ActivityA.class);
        //openA.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        // passo all'attivazione dell'activity page1.java
        startActivity(openA);
    }
    protected void launchB(){
        // definisco l'intenzione di aprire l'Activity "MainActivity.java"
        Intent openB = new Intent(this, ActivityB.class);
       // openB.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // passo all'attivazione dell'activity page1.java
        startActivity(openB);
    }
    protected void launchC(){
        // definisco l'intenzione di aprire l'Activity "MainActivity.java"
        Intent openC = new Intent(this, ActivityC.class);
        // passo all'attivazione dell'activity page1.java
        startActivity(openC);
    }
    protected void launchD(){
        // definisco l'intenzione di aprire l'Activity "MainActivity.java"
        Intent openD = new Intent(this, ActivityD.class);
        // passo all'attivazione dell'activity page1.java
        startActivity(openD);
    }

    protected void launchMain(){
        // definisco l'intenzione di aprire l'Activity "MainActivity.java"
        Intent openMain = new Intent(this, MainActivity.class);
        // passo all'attivazione dell'activity page1.java
        startActivity(openMain);
    }

    protected void launchNotifica(){

    }
}
