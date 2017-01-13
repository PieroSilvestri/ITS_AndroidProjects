package com.example.piero.buttoncolor;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment{

    private static final String VALORE = "valore";



    public interface IOnChangeColor{
        public void onChangeColor(String buttonValue, String colorValue);
    }

    private IOnChangeColor mListener = new IOnChangeColor() {
        @Override
        public void onChangeColor(String buttonValue, String colorValue) {

        }
    };

    public static DetailFragment getInstance(String aValue){
        DetailFragment vFragment = new DetailFragment();
        Bundle vBundle = new Bundle();
        vBundle.putString(VALORE, aValue);

        //Metto nel campo arguments un elemento di tipo bundle
        vFragment.setArguments(vBundle);

        return vFragment;
    }

    TextView textView;
    Button btnChange;
    String colore;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vView = inflater.inflate(R.layout.fragment_detail, container, false);

        final Bundle vBundle = getArguments();
        String testo = vBundle.getString(VALORE);



        textView = (TextView)vView.findViewById(R.id.textView);
        textView.setText(testo);

        final String array[] = {"BLUE", "RED", "YELLOW"};

        btnChange = (Button)vView.findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Scegli colore")
                        .setItems(array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                                Log.d("VALORE ", array[which]);
                                colore = String.valueOf(array[which]);
                                changeColor(String.valueOf(textView.getText()), colore);
                            }
                        })
                        .show();
            }
        });

        return vView;
    }

    private void changeColor(String buttonValue, String colorValue){
        mListener.onChangeColor(buttonValue, colorValue);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Quando il mio fragment viene attaccato all'activity vedo se riesco ad attaccare alla mia interfaccia
        if(getActivity() instanceof IOnChangeColor){
            mListener = (IOnChangeColor)getActivity();
        }

    }

}
