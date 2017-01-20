package com.example.pierosilvestri.es19012017_bruno_sqlitees;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pierosilvestri.es19012017_bruno_sqlitees.Anagrafiche.Anagrafiche;
import com.example.pierosilvestri.es19012017_bruno_sqlitees.Anagrafiche.AnagraficheAdapter;
import com.example.pierosilvestri.es19012017_bruno_sqlitees.Anagrafiche.AnagraficheContentProvider;
import com.example.pierosilvestri.es19012017_bruno_sqlitees.Anagrafiche.AnagraficheHelper;
import com.example.pierosilvestri.es19012017_bruno_sqlitees.Data.DbHelper;

import java.sql.NClob;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = "MainActivity";

    private AnagraficheAdapter mCursorAdapter;
    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle("Anagrafe");
        setSupportActionBar(myToolbar);

        mCursorAdapter = new AnagraficheAdapter(this, null);

        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(mCursorAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent vIntent = new Intent(MainActivity.this, DetailActivity.class)
                vIntent.putExtra("IDANAGRAFICHE", id)
                startActivity(vIntent);
            }
        });

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "ciao", Toast.LENGTH_SHORT).show();
                Log.d("valore", "uaoaaaa");
                return true;
            }
        });

        getSupportLoaderManager().initLoader(0, null, this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.add, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add:

                addPerson();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addPerson(){
        Toast.makeText(this, "ciao", Toast.LENGTH_SHORT).show();

        ContentValues values = new ContentValues();

        Random random = new Random();
        int randomInt = random.nextInt();

        values.put(AnagraficheHelper.NOME, "Nome " + randomInt);
        values.put(AnagraficheHelper.COGNOME, "Cognome" + randomInt);
        values.put(AnagraficheHelper.DATANASCITA, randomInt + "/2017");
        values.put(AnagraficheHelper.EMAIL, randomInt + "@gmail.com");
        values.put(AnagraficheHelper.TELEFONO, "" + randomInt);
        values.put(AnagraficheHelper.INDIRIZZO, "Via Roma " + randomInt);
        values.put(AnagraficheHelper.CIVICO, randomInt);
        values.put(AnagraficheHelper.CITTA, "Città " + randomInt);
        values.put(AnagraficheHelper.CAP, randomInt);
        values.put(AnagraficheHelper.PROVINCIA, "Provincia " + randomInt);
        values.put(AnagraficheHelper.LATITUDINE, randomInt);
        values.put(AnagraficheHelper.LONGITUDINE, randomInt);

        // content provider definito nel manifest
        getContentResolver().insert(AnagraficheContentProvider.ANAGRAFICHE_URI, values);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, AnagraficheContentProvider.ANAGRAFICHE_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mCursorAdapter.swapCursor(null);
    }
}
