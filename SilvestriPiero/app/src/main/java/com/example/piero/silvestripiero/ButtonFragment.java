package com.example.piero.silvestripiero;


import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment{

    private final static String TAG = "ButtonFragment";
    private final static String VALORE = "valore";
    private static final String MIO_CONTATORE = "Mio_contatore";



    public interface TripleSelected{
        public void tripleFragment(int aCurrentValue);
    }

    private TripleSelected myListener = new TripleSelected() {
        @Override
        public void tripleFragment(int aCurrentValue) {

        }
    };

    public static ButtonFragment getInstance(int aValue){
        ButtonFragment vFragment = new ButtonFragment();
        Bundle vBundle = new Bundle();
        vBundle.putInt(VALORE, aValue);

        //Metto nel campo arguments un elemento di tipo bundle
        vFragment.setArguments(vBundle);

        return vFragment;
    }

    TextView textView;
    private int mCounter;
    Button btnTriple, btnDouble, btnMeno, btnPiu, btnReset;

    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vView = inflater.inflate(R.layout.fragment_blank, container, false);

        textView = (TextView)vView.findViewById(R.id.textView);



        Bundle vBundle = getArguments();
        if(vBundle != null){
            mCounter = vBundle.getInt(VALORE);
        }

        if(savedInstanceState != null){
            mCounter = savedInstanceState.getInt(MIO_CONTATORE);
        }


        textView.setText(String.valueOf(mCounter));


        btnPiu = (Button)vView.findViewById(R.id.btnPiu);
        btnPiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "PIU'");
                mCounter++;
                updateGUI();
            }
        });

        btnMeno = (Button)vView.findViewById(R.id.btnMeno);
        btnMeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "MENO");
                mCounter--;
                if(mCounter < 0){
                    mCounter = 0;
                }
                updateGUI();
            }
        });

        // Raddoppio
        btnDouble = (Button)vView.findViewById(R.id.btnDouble);
        btnDouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "RADDOPPIO");
                // Creao l'oggetto firstdialog della classe FIRSTDIALOG
                Firstdialog firstdialog = Firstdialog.getInstance(mCounter);
                firstdialog.show(getActivity().getSupportFragmentManager().beginTransaction(), "DIALOG1");
            }
        });

        btnReset = (Button)vView.findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "RESET");
                Resetdialog resetdialog = new Resetdialog();
                resetdialog.show(getActivity().getSupportFragmentManager().beginTransaction(), "DIALOG2");
            }
        });

        btnTriple = (Button)vView.findViewById(R.id.btnTripl);
        btnTriple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "TRIPLICO" + String.valueOf(mCounter));
                myListener.tripleFragment(mCounter);
            }
        });

        return vView;
    }

    private void updateGUI(){
        textView.setText("" + mCounter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof TripleSelected){
            myListener = (TripleSelected)context;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MIO_CONTATORE, mCounter);
        Log.d(TAG, "M:onSaveInstance");
    }
}
