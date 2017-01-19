package com.example.pierosilvestri.es19012017_bruno_sqlitees;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pierosilvestri.es19012017_bruno_sqlitees.Anagrafiche.Anagrafiche;
import com.example.pierosilvestri.es19012017_bruno_sqlitees.Anagrafiche.AnagraficheContentProvider;
import com.example.pierosilvestri.es19012017_bruno_sqlitees.Anagrafiche.AnagraficheHelper;

public class DetailActivity extends AppCompatActivity {

    private Anagrafiche vAnagrafiche;
    TextView tNome, tCognome, tDataNascita, tEmail, tTelefono, tIndirizzo, tCivico, tCitta, tCasellaPostale, tProvincia, tLatitudine, tLongitudine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setTitle("Anagrafe");
        setSupportActionBar(myToolbar);

        Bundle vBundle = getIntent().getExtras();
        long id = vBundle.getLong("IDANAGRAFICHE");

        vAnagrafiche = newAnagrafiche(id);

        tNome = (TextView) findViewById(R.id.detail_nome);
        tNome.setText(vAnagrafiche.nome);

        tCognome = (TextView) findViewById(R.id.detail_cognome);
        tCognome.setText(vAnagrafiche.cognome);

        tDataNascita = (TextView) findViewById(R.id.detail_DataNascita);
        tDataNascita.setText(vAnagrafiche.dataNascita);

        tEmail = (TextView) findViewById(R.id.detail_email);
        tEmail.setText(vAnagrafiche.email);

        tTelefono = (TextView) findViewById(R.id.detail_telefono);
        tTelefono.setText(vAnagrafiche.telefono);

        tIndirizzo = (TextView) findViewById(R.id.detail_indirizzo);
        tIndirizzo.setText(vAnagrafiche.indirizzo);

        tCivico = (TextView) findViewById(R.id.detail_civico);
        tCivico.setText("" + vAnagrafiche.civico);

        tCitta = (TextView) findViewById(R.id.detail_citta);
        tCitta.setText(vAnagrafiche.citta);

        tCasellaPostale = (TextView) findViewById(R.id.detail_cap);
        tCasellaPostale.setText("" + vAnagrafiche.casellaPostale);

        tProvincia = (TextView) findViewById(R.id.detail_provincia);
        tProvincia.setText(vAnagrafiche.provincia);

        tLatitudine = (TextView) findViewById(R.id.detail_lat);
        tLatitudine.setText("" + vAnagrafiche.lat);

        tLongitudine = (TextView) findViewById(R.id.detail_long);
        tLongitudine.setText("" + vAnagrafiche.lon);

    }

    public Anagrafiche newAnagrafiche(long id) {

        Uri uriToUpdate = Uri.parse(AnagraficheContentProvider.ANAGRAFICHE_URI + "/" + id);
        Cursor cursor = getContentResolver().query(uriToUpdate, null, null, null, null);

        if(cursor != null){
            if (cursor.moveToFirst()) {
                // Get version from Cursor
                //String bookName = cursor.getString(cursor.getColumnIndex(AnagraficheHelper.NOME));

                Anagrafiche vAnagrafiche = new Anagrafiche();
                vAnagrafiche.nome = cursor.getString(cursor.getColumnIndex(AnagraficheHelper.NOME));
                vAnagrafiche.cognome = cursor.getString(cursor.getColumnIndex(AnagraficheHelper.COGNOME));
                vAnagrafiche.dataNascita = cursor.getString(cursor.getColumnIndex(AnagraficheHelper.DATANASCITA));
                vAnagrafiche.email = cursor.getString(cursor.getColumnIndex(AnagraficheHelper.EMAIL));
                vAnagrafiche.telefono = cursor.getString(cursor.getColumnIndex(AnagraficheHelper.TELEFONO));
                vAnagrafiche.indirizzo = cursor.getString(cursor.getColumnIndex(AnagraficheHelper.INDIRIZZO));
                vAnagrafiche.civico = cursor.getInt(cursor.getColumnIndex(AnagraficheHelper.CIVICO));
                vAnagrafiche.citta = cursor.getString(cursor.getColumnIndex(AnagraficheHelper.CITTA));
                vAnagrafiche.casellaPostale = cursor.getInt(cursor.getColumnIndex(AnagraficheHelper.CAP));
                vAnagrafiche.provincia = cursor.getString(cursor.getColumnIndex(AnagraficheHelper.PROVINCIA));
                vAnagrafiche.lat = cursor.getInt(cursor.getColumnIndex(AnagraficheHelper.LATITUDINE));
                vAnagrafiche.lon = cursor.getInt(cursor.getColumnIndex(AnagraficheHelper.LONGITUDINE));

                return vAnagrafiche;

            }

        }
        Toast.makeText(getApplicationContext(), "Prova nullo", Toast.LENGTH_SHORT).show();
        return null;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.edit, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.edit:

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
