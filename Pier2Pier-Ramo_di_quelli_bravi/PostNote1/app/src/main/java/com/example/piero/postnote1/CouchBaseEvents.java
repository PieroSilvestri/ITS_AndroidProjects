package com.example.piero.postnote1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.couchbase.lite.Database;
import com.couchbase.lite.Manager;

public class CouchBaseEvents extends AppCompatActivity {

    // Variabili
    public static final String DB_NAME = "couchbaseevents";
    public static final String TAG = "couchbaseevents";
    String documentId;
    Manager manager = null;
    Database database = null;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couch_base_events);

    }
}
