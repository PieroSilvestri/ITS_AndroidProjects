package com.example.piero.buttoncolor;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {

    Button btnA, btnB, btnC;
    Bundle vBundle;
    String bottone, colore;
    private static final String BOTTONE = "bottoneValore";
    private static final String COLORE = "coloreValore";

    public interface IOnButtonSelected{
        public void onUpdateValue(String aCurrentValue);
    }

    private IOnButtonSelected mListener = new IOnButtonSelected() {
        @Override
        public void onUpdateValue(String aCurrentValue) {

        }
    };

    public static ButtonFragment getInstance(String buttonValue, String colorValue){
        ButtonFragment vFragment = new ButtonFragment();
        Bundle mBundle = new Bundle();
        mBundle.putString(BOTTONE, buttonValue);
        mBundle.putString(COLORE, colorValue);

        //Metto nel campo arguments un elemento di tipo bundle
        vFragment.setArguments(mBundle);

        return vFragment;
    }

    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vView = inflater.inflate(R.layout.fragment_button, container, false);

        vBundle = getArguments();
        colore = "";
        bottone = "";
        if(vBundle != null){
            bottone = vBundle.getString(BOTTONE);
            colore = vBundle.getString(COLORE);
        }

        Log.d("BTN" , bottone);
        Log.d("COL", colore);


        btnA = (Button)vView.findViewById(R.id.btnA);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyClick("A");
            }

        });

        btnB = (Button)vView.findViewById(R.id.btnB);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyClick("B");
            }
        });

        btnC = (Button)vView.findViewById(R.id.btnC);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyClick("C");
            }
        });

        switch (bottone){
            case "A":
                btnA.setBackgroundColor(Color.parseColor(colore));
                break;
            case "B":
                btnB.setBackgroundColor(Color.parseColor(colore));
                break;
            case "C":
                btnC.setBackgroundColor(Color.parseColor(colore));
                break;
            default:
                break;
        }

        return vView;
    }

    private void notifyClick(String value){
        mListener.onUpdateValue(value);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(getActivity() instanceof IOnButtonSelected){
            mListener = (IOnButtonSelected)getActivity();
        }

    }

}
