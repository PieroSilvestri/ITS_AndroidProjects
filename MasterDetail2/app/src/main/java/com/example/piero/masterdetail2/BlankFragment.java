package com.example.piero.masterdetail2;


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
public class BlankFragment extends Fragment {

    TextView text;
    private static final String VALORE = "VALORE";


    public static BlankFragment getInstance(String aValue){
        BlankFragment vFragment = new BlankFragment();
        Bundle vBundle = new Bundle();
        vBundle.putString(VALORE, aValue);

        //Metto nel campo arguments un elemento di tipo bundle
        vFragment.setArguments(vBundle);

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

        text = (TextView)vView.findViewById(R.id.textView2);
        Bundle vBundle = getArguments();
        String vString = vBundle.getString(VALORE);

        text.setText(vString);

        Button vBtn = (Button)vView.findViewById(R.id.button);
        vBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button_fragment myFragment = new Button_fragment();
                myFragment.changeColor(90150);
            }
        });

        return vView;
    }

}
