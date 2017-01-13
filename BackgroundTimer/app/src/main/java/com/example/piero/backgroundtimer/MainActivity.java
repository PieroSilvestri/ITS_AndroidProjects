package com.example.piero.backgroundtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TimerFragment.IOnTimerUpdate{

    TextView mText;
    private static final String TIMER_FRAGMENT = "  timer_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = (TextView)findViewById(R.id.textView);

        TimerFragment vFrag = (TimerFragment)getSupportFragmentManager().findFragmentByTag(TIMER_FRAGMENT);
        if(vFrag == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(TimerFragment.getInstance(), TIMER_FRAGMENT)
                    .commit();
        }

    }

    private void updaevalue(int aValue){
        mText.setText(""  + aValue);
    }

    @Override
    public void onUpdateValue(final int value) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mText.setText(""  + value);
            }
        });
    }
}
