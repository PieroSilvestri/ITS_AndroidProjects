package com.example.piero.fragment_2;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    public interface IUpdateText{
        public void updateTextView(int aValue);
    }

    private static final String TAG = "Fragment";
    private static final String COUNTER = "quello che vuoi" ;

    private IUpdateText mUpdate;

    public MyFragment() {
        // Required empty public constructor
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
        mUpdate = null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");

        Activity vHostActivity = getActivity();

        if(vHostActivity instanceof IUpdateText){
            mUpdate = (IUpdateText)vHostActivity;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vView = inflater.inflate(R.layout.counter_layout, container, false);

        if(savedInstanceState != null){
            mCounter = savedInstanceState.getInt(COUNTER);
        }

        Button vBtn = (Button)vView.findViewById(R.id.button5);
        vBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tastoPremuto();
            }
        });

        mText = (TextView)(vView.findViewById(R.id.txt1));

        return vView;
    }
    public void tastoPremuto(){
        //((IUpdateText)getActivity()).updateTextView(mCounter);
        if(mUpdate != null){
            mUpdate.updateTextView(mCounter);
        }
    }


    public void inc(){
        mCounter++;
        mText.setText("" + mCounter);
    }
    public void dec(){
        mCounter--;
        mText.setText("" + mCounter);
    }

}
