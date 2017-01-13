package com.example.piero.es02122016_sqlite2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.piero.es02122016_sqlite2.Data.Contact;
import com.example.piero.es02122016_sqlite2.Data.ContactsAdapter;
import com.example.piero.es02122016_sqlite2.Data.ContactsHelper;
import com.example.piero.es02122016_sqlite2.Data.Dataset;
import com.example.piero.es02122016_sqlite2.Data.Dialog1;

public class MainActivity extends AppCompatActivity implements Dialog1.IDIalogAnswer{

    private static final String TITLE = "Titolo";
    private static final String MESSAGE = "Messaggio";

    Dataset mDataset;
    ContactsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Esercizio da finire:
        // Al click dell'elemento dare la possibilità di modificarlo

        mDataset = Dataset.Get(this);
        ListView vList = (ListView) findViewById(R.id.listView);

        mAdapter = new ContactsAdapter(this, mDataset.getContacts());
        vList.setAdapter(mAdapter);

        vList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle vBundle = new Bundle();
                vBundle.putInt("POSITION", i);
                vBundle.putLong("ID", l);
                vBundle.putString(TITLE, "Cancella");
                vBundle.putString(MESSAGE, "Sicuro che vuoi cancellare l'elemento '" + mAdapter.getItem(i).mName + "' ?");

                Dialog1 dialog = new Dialog1();
                dialog.setArguments(vBundle);
                dialog.show(getSupportFragmentManager(), "DIALOG1");
                return true;
            }
        });

        Button vBtn = (Button) findViewById(R.id.button);
        vBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataset.addContact(Contact.CreateRandom());
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onYes(long l) {
        mDataset.removeContact(l);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onNo() {
        Toast toast = Toast.makeText(this, "Hai premuto NO", Toast.LENGTH_LONG);
        toast.show();
    }
}
