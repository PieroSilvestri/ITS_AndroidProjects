package com.example.piero.myprova1;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity implements MyFragment.IUpdater{

    private static final String TAG = "Activity";
    private static final String FRAGMENT = "primo_fragment" ;

    TextView aText;
    MyFragment vFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aText = (TextView)findViewById(R.id.textView);

        FragmentManager fragmentManager = getFragmentManager();
        vFragment = (MyFragment)fragmentManager.findFragmentByTag(FRAGMENT);

        if(vFragment == null) {
            FragmentTransaction vTrans = fragmentManager.beginTransaction();

            vFragment = MyFragment.getInstance(123);

            vTrans.add(R.id.container, vFragment, FRAGMENT);
            vTrans.commit();
        }


    }

    @Override
    public void updateTextView(int aValue){
        aText.setText("" + aValue);
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
}
