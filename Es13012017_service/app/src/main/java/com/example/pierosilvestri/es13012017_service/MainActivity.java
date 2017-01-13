package com.example.pierosilvestri.es13012017_service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RandomService mService;
    Button vBtnSend;
    TextView mLabel;
    Boolean mBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vBtnSend = (Button) findViewById(R.id.button);
        mLabel = (TextView) findViewById(R.id.textView2);

        vBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBound){
                    mLabel.setText("" + mService.getRandomNumber());
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        bindService(new Intent(this, RandomService.class), mConnection, Context.BIND_AUTO_CREATE);



    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            RandomService.MyBinder vMyBinder = (RandomService.MyBinder)service;

            mService = vMyBinder.getService();

            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };
}
