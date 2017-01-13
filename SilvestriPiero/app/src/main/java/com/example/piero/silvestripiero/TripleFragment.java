package com.example.piero.silvestripiero;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TripleFragment extends Fragment {

    private final static String TAG = "TripleFragment";
    private final static String VALORE = "valore";
    private static final String MIO_CONTATORE = "Mio_contatore";


    public TripleFragment() {
        // Required empty public constructor
    }

    public static TripleFragment getInstance(int aValue){
        TripleFragment vFragment = new TripleFragment();
        Bundle vBundle = new Bundle();
        vBundle.putInt(VALORE, aValue);

        //Metto nel campo arguments un elemento di tipo bundle
        vFragment.setArguments(vBundle);

        return vFragment;
    }

    TextView textView2;
    private int valore;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vView = inflater.inflate(R.layout.fragment_blank2, container, false);
        // Inflate the layout for this fragment

        textView2 = (TextView)vView.findViewById(R.id.textView2);

        Bundle vBundle = getArguments();
        if(vBundle != null){
            valore = vBundle.getInt(VALORE) * 3;
        }

        if(savedInstanceState != null){
            valore = savedInstanceState.getInt(MIO_CONTATORE);
        }

        textView2.setText(String.valueOf(valore));


        return vView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MIO_CONTATORE, valore);
        Log.d(TAG, "onSaveInstance");
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
}
