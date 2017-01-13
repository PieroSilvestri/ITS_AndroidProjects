package com.example.piero.es25112016_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    DbHelper vHelper;
    SQLiteDatabase vDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vHelper = new DbHelper(this);
        insertData();

        vDb = vHelper.getReadableDatabase();

        //Cursor vCursor = vDb.rawQuery("SELECT * FROM " + ItemsHelper.TABLE_NAME, null);

        Cursor vCursor = vDb.query(ItemsHelper.TABLE_NAME, null, "_id = 10 OR quantity = 12", null, null, null, null);

        while(vCursor.moveToNext()){
            int vId = vCursor.getInt(vCursor.getColumnIndex(ItemsHelper._ID));
            String vName = vCursor.getString(vCursor.getColumnIndex(ItemsHelper.NAME));
            int vQuantity = vCursor.getInt(vCursor.getColumnIndex(ItemsHelper.QUANTITY));

            Log.d("DB", "ID: " + vId + " NAME: " + vName + " QUANTITY: " + vQuantity);
        }

        vCursor.close();
    }

    public void insertData(){
        SQLiteDatabase db = vHelper.getReadableDatabase();

        for(int index = 0; index < 100; index++){
            ContentValues values = new ContentValues();

            values.put(ItemsHelper.NAME, "name " + index);
            values.put(ItemsHelper.QUANTITY, index);

            db.insert(ItemsHelper.TABLE_NAME, null, values);
        }

        db.close();
    }
}
