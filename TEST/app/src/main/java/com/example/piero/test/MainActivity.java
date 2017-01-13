package com.example.piero.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TEST-APP";
    int mCounter;
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = (TextView)findViewById(R.id.etichetta);

        MyRunnable myRunnable = new MyRunnable(this);

        Thread vThread = new Thread(myRunnable);
        vThread.start();

    }

    private void updateText(final int aValue){

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mText.setText("Miei soldi: " + aValue + "$");
            }
        });
    }

    private class MyRunnable implements Runnable{

        MainActivity vRef;
        WeakReference<MainActivity> mWeak;
        boolean mRunning;
        public MyRunnable(MainActivity aRef){
            mWeak = new WeakReference<MainActivity>(aRef);
            mRunning = true;
        }

        @Override
        public void run() {
            while (mRunning) {
                if (mWeak.get() != null) {
                    Log.d(TAG, "COUNTER:" + mCounter + " " +mWeak.get());
                    mWeak.get().updateText(mCounter);
                } else{
                  mRunning = false;
                }
                Log.d(TAG, "Timer running " + this);

                mCounter++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy:" + this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d(TAG, "onFinalize" + this);
    }
}
