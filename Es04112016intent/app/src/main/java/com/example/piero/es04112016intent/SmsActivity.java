package com.example.piero.es04112016intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        TextView txt_sms = (TextView) findViewById(R.id.txt_sms);

        Intent vIntent = getIntent();
        Bundle vData = vIntent.getExtras();
        if(vData != null){
            txt_sms.setText(vData.getString(Intent.EXTRA_TEXT));
        }

    }
}
