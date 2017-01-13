package com.example.piero.masterdetail;


import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetail extends Fragment {

    public interface IOnButtonSelectedDetail{
        public void onUpdateValueDetail(String newColor);
    }

    private IOnButtonSelectedDetail mListener = new IOnButtonSelectedDetail() {
        @Override
        public void onUpdateValueDetail(String newColor) {

        }
    };

    private static final String VALORE = "valore";
    TextView vText;

    public static FragmentDetail getInstance(String aValue){
        FragmentDetail vFragment = new FragmentDetail();
        Bundle vBundle = new Bundle();
        vBundle.putString(VALORE, aValue);

        //Metto nel campo arguments un elemento di tipo bundle
        vFragment.setArguments(vBundle);

        return vFragment;
    }

    public FragmentDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vView = inflater.inflate(R.layout.fragment_fragment_detail, container, false);

        vText = (TextView)vView.findViewById(R.id.etichetta);

        Bundle vBundle = getArguments();
        String vString = vBundle.getString(VALORE);

        vText.setText(vString);

        Button vBtnColor = (Button)vView.findViewById(R.id.btnColor);
        vBtnColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                changeColor("red");
            }
        });

        return vView;
    }

    public void changeColor(String color){
        mListener.onUpdateValueDetail(color);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Quando il mio fragment viene attaccato all'activity vedo se riesco ad attaccare alla mia interfaccia
        if(getActivity() instanceof IOnButtonSelectedDetail){
            mListener = (IOnButtonSelectedDetail)getActivity();
        }
    }

}
