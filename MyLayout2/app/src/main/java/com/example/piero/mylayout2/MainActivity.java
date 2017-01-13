package com.example.piero.mylayout2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycalculator);

        Button mPiu = (Button)findViewById(R.id.piu);
        Button mMeno = (Button)findViewById(R.id.meno);
    }
}
