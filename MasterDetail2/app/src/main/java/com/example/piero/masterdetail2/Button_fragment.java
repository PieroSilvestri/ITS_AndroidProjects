package com.example.piero.masterdetail2;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Button_fragment extends Fragment {

    public interface IOnButtonSelected{
        public void onUpdateValue(String aCurrentValue);
    }

    private IOnButtonSelected mListener = new IOnButtonSelected() {
        @Override
        public void onUpdateValue(String aCurrentValue) {

        }
    };

    public static Button_fragment getInstance(){
        return new Button_fragment();
    }

    private static  final  String CURRENT_STRING = "stringa_iniziale";

    public Button_fragment() {
        // Required empty public constructor
    }

    private String mLabel;
    private String mCurrentLabel;
    TextView fText;
    Button btnA;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vView = inflater.inflate(R.layout.fragment_button_fragment, container, false);

        fText = (TextView)vView.findViewById(R.id.textView);
        fText.setText(mLabel);

        btnA = (Button)vView.findViewById(R.id.btnA);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateIO("A");
            }
        });

        Button btnB = (Button)vView.findViewById(R.id.btnB);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateIO("B");
            }
        });

        Button btnC = (Button)vView.findViewById(R.id.btnC);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateIO("C");
            }
        });

        return vView;
    }

    public void updateIO(String value){
        mListener.onUpdateValue(value);
    }

    public void changeColor(int value){
        btnA.setBackgroundColor(value);
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
