package com.example.piero.fragmentsimple;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment{

    TextView text;

    private static final String TAG = "Fragment";
    private static final String COUNTER = "quello che vuoi" ;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vView = inflater.inflate(R.layout.fragment_blank, container, false);

        text = (TextView)vView.findViewById(R.id.textView);

        return vView;
    }

    public void cambiaTesto(String a){
        text.setText(a);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

}
