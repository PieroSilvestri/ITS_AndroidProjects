package com.example.piero.backgroundtimer;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimerFragment extends Fragment {

    public interface  IOnTimerUpdate{
        public void onUpdateValue(int value);
    }

    private static final String FRAGMENT_TAG = "FRAGMENT_TIMER";
    private IOnTimerUpdate mListener;


    public TimerFragment() {
        // Required empty public constructor
    }

    public static TimerFragment getInstance(){
        return  new TimerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return null;
    }

    private  static class MyTimer implements Runnable{

        WeakReference<TimerFragment> mRef;
        int mCounter;
        boolean mRunning;

        public  MyTimer(TimerFragment aRef){
            mRef = new WeakReference<TimerFragment>(aRef);
        }

        public void stop(){
            mRunning = false;
        }

        @Override
        public void run() {
            while (mRunning){
                if(mRef.get() != null){
                    mCounter++;
                    mRef.get().onTimerValue(mCounter);
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void onTimerValue(int aValue){
        Log.d(FRAGMENT_TAG, "onTimerValue:" + aValue);
        if(mListener != null){
            mListener.onUpdateValue(aValue);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(FRAGMENT_TAG, "onStart");
        setRetainInstance(true);

        Thread vTh = new Thread(new MyTimer(this));
        vTh.start();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(FRAGMENT_TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(FRAGMENT_TAG, "onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(FRAGMENT_TAG, "onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(FRAGMENT_TAG, "onStop");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(FRAGMENT_TAG, "onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(FRAGMENT_TAG, "onDetach");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(FRAGMENT_TAG, "onAttach");
        if(context instanceof IOnTimerUpdate){
            mListener = (IOnTimerUpdate)context;
        }
    }
}
