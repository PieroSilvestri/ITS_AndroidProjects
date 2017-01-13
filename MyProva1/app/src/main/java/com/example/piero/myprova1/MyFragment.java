package com.example.piero.myprova1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by piero on 15/04/2016.
 */
public class MyFragment extends Fragment {

    private static final String TAG = "Fragment";
    private static final String COUNTER = "quello che vuoi" ;
    private static final String VALORE_INIZIALE = "CONTATORE" ;

    public MyFragment() {
        // Required empty public constructor
    }

    public interface IUpdater{
        void updateTextView(int a);
    }

    private int aCounter;
    private IUpdater updater;

    public static MyFragment getInstance(int aCounter){
        MyFragment vFrag = new MyFragment();

        Bundle vBundle = new Bundle();
        vBundle.putInt(MyFragment.VALORE_INIZIALE, aCounter);
        vFrag.setArguments(vBundle);

        return vFrag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vView = inflater.inflate(R.layout.fragment_main, container, false);

        Bundle vBundle = getArguments();
        if(vBundle != null){
            aCounter = vBundle.getInt(VALORE_INIZIALE);
        }


        Button vBtn1 = (Button)vView.findViewById(R.id.button);
        vBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inc();
            }
        });

        Button vBtn2 = (Button)vView.findViewById(R.id.button2);
        vBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dec();
            }
        });

        return vView;
    }

    public void inc(){
        aCounter++;
        if(updater != null){
            updater.updateTextView(aCounter);
        }
    }
    public void dec(){
        aCounter--;
        if(updater != null){
            updater.updateTextView(aCounter);
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
        updater = null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");

        if(context instanceof IUpdater){
            updater = (IUpdater)context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    TextView mText;
    int mCounter;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER, mCounter);
    }
}
