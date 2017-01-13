package com.example.piero.masterdetail;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private static boolean tasto = false;

    public interface IOnButtonSelected{
        public void onUpdateValue(String aCurrentValue);
    }

    private TextView mTextView;

    private static  final  String CURRENT_STRING = "stringa_iniziale";
    private static  final  String COLOR_STRING = "stringa_colore";
    private static final String START_VALUE = "string di partenza";
    private String mCurrentLabel;
    Button vBtnA;
    Button vBtnB;
    Button vBtnC;

    private IOnButtonSelected mListener = new IOnButtonSelected() {
        @Override
        public void onUpdateValue(String aCurrentValue) {

        }
    };

    public static BlankFragment getInstance(){
        return new BlankFragment();
    }

    public static BlankFragment getColor(String aValue){
        BlankFragment vFragment = new BlankFragment();
        Bundle vBundle = new Bundle();
        vBundle.putString(COLOR_STRING, aValue);

        //Metto nel campo arguments un elemento di tipo bundle
        vFragment.setArguments(vBundle);

        Log.d("TEST COLORE", "Il colore è: " + vBundle.getString(COLOR_STRING));

        tasto = true;

        return vFragment;
    }

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vView = inflater.inflate(R.layout.fragment_blank, container, false);


        mTextView = (TextView)vView.findViewById(R.id.textView);
        mTextView.setText(mCurrentLabel);

        Bundle vBundle = new Bundle();
        Bundle cBundle = getArguments();

        if(tasto != false){
            Log.d("TEST COLOREEE!!!", "COLORE: " + cBundle.getString(COLOR_STRING));
            vBtnA.setBackgroundColor(0xFF00FF00);
        }

        // String vColor = vBundle.getString(COLOR_STRING);
        // Log.d("TEST COLOR:", "Il colore èèè: " + vColor);

        // Button A
        vBtnA = (Button)vView.findViewById(R.id.button1);
        vBtnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                notifyClick("A");
            }
        });

        // Button B
        vBtnB = (Button)vView.findViewById(R.id.button2);
        vBtnB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                notifyClick("B");
            }
        });


        // Button C
        vBtnC = (Button)vView.findViewById(R.id.button3);
        vBtnC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                notifyClick("C");
            }
        });

        // Inflate the layout for this fragment
        return vView;

    }

    private void notifyClick(String value){
        mListener.onUpdateValue(value);
    }

    public void changeColor(){
        vBtnA.setBackgroundColor(0xFF00FF00);
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
