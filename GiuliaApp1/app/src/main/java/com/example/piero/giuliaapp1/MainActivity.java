package com.example.piero.giuliaapp1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btnModa, btnSpettacolo, btnArte, btnCinema, btnSport, btnStoria;
    private final String MY_TAG = "TAGVALORE";

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, MapsActivity.class);

        btnModa = (Button)findViewById(R.id.buttonModa);
        btnModa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("TAGVALORE", "MODA");
                startActivity(intent);
            }
        });

        btnSpettacolo = (Button)findViewById(R.id.buttonSpettacolo);
        btnSpettacolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(MY_TAG, "SPETTACOLO");
                startActivity(intent);
            }
        });

        btnArte = (Button)findViewById(R.id.buttonArte);
        btnArte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(MY_TAG, "ARTE");
                startActivity(intent);
            }
        });

        btnCinema = (Button)findViewById(R.id.buttonCinema);
        btnCinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(MY_TAG, "CINEMA");
                startActivity(intent);
            }
        });

        btnSport = (Button)findViewById(R.id.buttonSport);
        btnSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(MY_TAG, "SPORT");
                startActivity(intent);
            }
        });

        btnStoria = (Button)findViewById(R.id.buttonStoria);
        btnStoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(MY_TAG, "STORIA");
                startActivity(intent);
            }
        });

    }
}
