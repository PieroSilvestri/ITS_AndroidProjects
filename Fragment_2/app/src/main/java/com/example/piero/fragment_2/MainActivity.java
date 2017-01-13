package com.example.piero.fragment_2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements MyFragment.IUpdateText{

    private static final String TAG = "Activity";
    private static final String FRAGMENT = "primo_fragment" ;
    TextView mText;

    MyFragment mCounterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        mText = (TextView)findViewById(R.id.textView);

        FragmentManager fragmentManager = getFragmentManager();
        mCounterFragment = (MyFragment)fragmentManager.findFragmentByTag(FRAGMENT);

        if(mCounterFragment == null) {
            FragmentTransaction vTrans = fragmentManager.beginTransaction();

            mCounterFragment = new MyFragment();

            vTrans.add(R.id.container, mCounterFragment, FRAGMENT);
            vTrans.commit();
        }

        Button btn1 = (Button)findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounterFragment.inc();
            }
        });

        Button btn2 = (Button)findViewById(R.id.button4);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounterFragment.dec();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void updateTextView(int aValue) {
        mText.setText("" + aValue);

    }

}
