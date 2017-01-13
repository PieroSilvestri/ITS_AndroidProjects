package com.example.piero.es25112016_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by piero on 25/11/2016.
 */
public class DbHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "database1";
    private static final int VERSIONE = 1;

    public DbHelper(Context context){
        super(context, DB_NAME, null, VERSIONE);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Vado a prendere la query dalla classe
        sqLiteDatabase.execSQL(ItemsHelper.CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(ItemsHelper.DROP_QUERY);

    }
}
