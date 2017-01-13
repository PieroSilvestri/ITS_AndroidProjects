package com.example.piero.fragment_support;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSelector extends Fragment {

    public interface IOnButtonSelected{
        public void onUpdateValue(String aCurrentValue);
    }

    private TextView mTextView;

    FirstDialog firstD = new FirstDialog();

    private static  final  String CURRENT_STRING = "stringa_iniziale";
    private static final String START_VALUE = "string di partenza";
    private String mCurrentLabel;

    private IOnButtonSelected mListener = new IOnButtonSelected() {
        @Override
        public void onUpdateValue(String aCurrentValue) {

        }
    };

    public static FragmentSelector getInstance(String startValue){
        FragmentSelector vFrag = new FragmentSelector();

        Bundle vBundle = new Bundle();
        vBundle.putString(START_VALUE, startValue);
        vFrag.setArguments(vBundle);

        return vFrag;
    }

    public static FragmentSelector getInstance(){
        return FragmentSelector.getInstance("--");
    }

    private void updateGUI(){
        mTextView.setText(mCurrentLabel);
    }

    public FragmentSelector() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vView = inflater.inflate(R.layout.fragment_fragment_selector, container, false);

        if(savedInstanceState != null){
            mCurrentLabel = savedInstanceState.getString(CURRENT_STRING);
        }
        else {
            mCurrentLabel = getArguments().getString(START_VALUE, "--");
        }

        mTextView = (TextView)vView.findViewById(R.id.textView);
        mTextView.setText(mCurrentLabel);

        // Button A
        Button vBtnA = (Button)vView.findViewById(R.id.btn_a);
        vBtnA.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v){
                mCurrentLabel = "A";
                mListener.onUpdateValue(mCurrentLabel);
                updateGUI();
            }
        });

        // Button B
        Button vBtnB = (Button)vView.findViewById(R.id.btn_b);
        vBtnB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentLabel = "B";
                mListener.onUpdateValue(mCurrentLabel);
                updateGUI();
            }
        });


        // Button C
        Button vBtnC = (Button)vView.findViewById(R.id.btn_c);
        vBtnC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentLabel = "C";
                mListener.onUpdateValue(mCurrentLabel);
                updateGUI();
            }
        });

        updateGUI();
        // Inflate the layout for this fragment
        return vView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Quando il mio fragment viene attaccato all'activity vedo se riesco ad attaccare alla mia interfaccia
        if(getActivity() instanceof IOnButtonSelected){
            mListener = (IOnButtonSelected)getActivity();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CURRENT_STRING, mCurrentLabel);
    }


}
