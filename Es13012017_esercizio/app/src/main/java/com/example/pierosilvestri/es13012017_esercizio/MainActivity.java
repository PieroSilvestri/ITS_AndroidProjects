package com.example.pierosilvestri.es13012017_esercizio;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pierosilvestri.es13012017_esercizio.Town.Town;
import com.example.pierosilvestri.es13012017_esercizio.Town.TownAdapter;
import com.example.pierosilvestri.es13012017_esercizio.Town.TownContentProvider;
import com.example.pierosilvestri.es13012017_esercizio.Town.TownHelper;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = "MainActivity";

    private TownAdapter mAdapter;
    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle("Towns");
        setSupportActionBar(myToolbar);

        mAdapter = new TownAdapter(this, null);

        mListView = (ListView) findViewById(R.id.listView1);
        mListView.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(0, null, this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.add_button, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add:

                addTown();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addTown(){
        Toast.makeText(this, "ciao", Toast.LENGTH_SHORT).show();

        ContentValues values = new ContentValues();

        Random random = new Random();
        int randomInt = random.nextInt();

        values.put(TownHelper.NAME, "Città " + randomInt);

        // content provider definito nel manifest
        getContentResolver().insert(TownContentProvider.TOWNS_URI, values);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, TownContentProvider.TOWNS_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
}
