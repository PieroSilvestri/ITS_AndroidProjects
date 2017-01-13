package com.example.piero.testdialog;

import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Firstdialog.IDIalogAnswer, SecondDialog.ISecondDIalogAnswer, ThirdDialog.IThirdDIalogAnswer{

    private TextView mText;
    private String TAG = "DIALOGATORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){

        }

        mText = (TextView)findViewById(R.id.textView);

        Button btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Bottone 1");
                Firstdialog dialog = Firstdialog.getInstance("Titolobello", "Bottone1");
                dialog.show(getSupportFragmentManager(), "DIALOG1");
            }
        });

        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Bottone 2");
                SecondDialog dialog = SecondDialog.getInstance("Titolobello", "Bottone2");
                dialog.show(getSupportFragmentManager(), "DIALOG2");
            }
        });

        Button btn3 = (Button)findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Bottone 3");
                ThirdDialog dialog = ThirdDialog.getInstance("Titolobello", "Bottone3");
                dialog.show(getSupportFragmentManager(), "DIALOG3");
            }
        });

        Button btn4 = (Button)findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Bottone 4");
                Toast.makeText(MainActivity.this, R.string.testo_del_toast, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void updateUI(String risposta){
        mText.setText(risposta);
    }

    @Override
    public void onYes() {
        updateUI("Yes");
    }

    @Override
    public void onNo() {
        updateUI("No");
    }

    @Override
    public void listValue(String valore) {
        Log.d("Megapiero", valore);
        updateUI(valore);
    }

    @Override
    public void listValueThird(String[] valore, ArrayList<Integer> ArrayList) {
        String lista = "";
        for(int i = 0; i < ArrayList.size(); i++){
            lista += (i+1) + ")" + valore[ArrayList.get(i)] + " ";
        }
        updateUI(lista);
    }
}
