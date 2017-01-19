package com.example.pierosilvestri.es19012017_bruno_sqlitees.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pierosilvestri.es19012017_bruno_sqlitees.Anagrafiche.AnagraficheHelper;

/**
 * Created by pierosilvestri on 19/01/17.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "anagrafiche1";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AnagraficheHelper.CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(AnagraficheHelper.DROP_QUERY);
    }
}
