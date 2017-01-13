package com.example.piero.couchbase2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    public static final String DB_NAME = "couchbaseevents";
    public static final String TAG = "couchbaseevents";
    String documentId;
    Manager manager = null;
    Database database = null;
    TextView testo;
    TextView titolo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(TAG, "Begin Couchbase Events App");
        helloCBL();

        // retrieve the document from the database

        Log.d("DOCUMENT_ID", documentId);
        Document retrievedDocument = database.getDocument(documentId);
// display the retrieved document
        Log.d(TAG, "retrievedDocument=" + String.valueOf(retrievedDocument.getProperties()));

        testo =(TextView)findViewById(R.id.testo);
        testo.setText("Ciao");

        titolo =(TextView)findViewById(R.id.title);
        titolo.setText("Titolo");

        Log.d(TAG, "End Couchbase Events App");

    }

    private void helloCBL() {
        Manager manager = null;
        Database database = null;
        try {
            manager = new Manager(new AndroidContext(this), Manager.DEFAULT_OPTIONS);
            database = manager.getDatabase(DB_NAME);
        } catch (Exception e) {
            Log.e(TAG, "Error getting database", e);
            return;
        }
        // Create the document
        documentId = createDocument(database);
    /* Get and output the contents */
        //outputContents(database, documentId);
    /* Update the document and add an attachment */
        //updateDoc(database, documentId);
        // Add an attachment
        //addAttachment(database, documentId);
    /* Get and output the contents with the attachment */
        //outputContentsWithAttachment(database, documentId);
    }

    public Database getDatabaseInstance() throws CouchbaseLiteException {
        if ((this.database == null) & (this.manager != null)) {
            this.database = manager.getDatabase(DB_NAME);
        }
        return database;
    }
    public Manager getManagerInstance() throws IOException {
        if (manager == null) {
            manager = new Manager(new AndroidContext(this), Manager.DEFAULT_OPTIONS);
        }
        return manager;
    }

    private String createDocument(Database database) {
        // Create a new document and add data
        Document document = database.createDocument();
        String documentId = document.getId();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Titoolo", "Big Party");
        map.put("location", "My House");
        try {
            // Save the properties to the document
            document.putProperties(map);
        } catch (CouchbaseLiteException e) {
            Log.e(TAG, "Error putting", e);
        }
        Log.d("ID", documentId);
        return documentId;
    }
}
