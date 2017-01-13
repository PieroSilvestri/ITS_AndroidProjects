package com.example.piero.fragmentsimple;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    TextView myText;

    public BlankFragment() {
        // Required empty public constructor
    }


    public void changeText(String value){
        myText.setText(value);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vView = inflater.inflate(R.layout.fragment_blank, container, false);

        myText = (TextView)vView.findViewById(R.id.textView);

        return vView;

    }

}
