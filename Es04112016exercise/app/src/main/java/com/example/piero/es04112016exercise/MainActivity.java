package com.example.piero.es04112016exercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupGUI();
    }

    private void setupGUI(){

        edit_text = (EditText) findViewById(R.id.edit_txt);

        Button btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(edit_text.getText().toString());
            }
        });
    }

    private void sendMessage(String messaggio){

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, messaggio);
        sendIntent.setType("text/plain");

        if(sendIntent.resolveActivity(getPackageManager()) != null){
            startActivity(sendIntent);
        }
    }
}
