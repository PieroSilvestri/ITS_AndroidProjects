package com.example.pierosilvestri.es13012017_esercizio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.pierosilvestri.es13012017_esercizio.Data.Dataset;
import com.example.pierosilvestri.es13012017_esercizio.Town.Town;
import com.example.pierosilvestri.es13012017_esercizio.Town.TownAdapter;
import com.example.pierosilvestri.es13012017_esercizio.Town.TownHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TITLE = "Titolo";
    private static final String MESSAGE = "Messaggio";

    Dataset mDataset;
    TownAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataset = Dataset.Get(this);
        ListView vList = (ListView) findViewById(R.id.listView1);

        mAdapter = new TownAdapter(this, mDataset.getTowns());
        vList.setAdapter(mAdapter);

        Button vBtn = (Button) findViewById(R.id.btn_aggiungi);
        vBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataset.addTown(Town.CreateRandomTown());
                mAdapter.notifyDataSetChanged();
            }
        });

    }
}
