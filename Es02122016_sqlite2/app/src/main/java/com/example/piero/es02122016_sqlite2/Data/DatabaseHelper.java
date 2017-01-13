package com.example.piero.es02122016_sqlite2.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

/**
 * Created by piero on 02/12/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "contacts.db";
    private static final int VERSION = 1;

    public DatabaseHelper(Context aContext){

        super(aContext, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ContactsHelper.CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
