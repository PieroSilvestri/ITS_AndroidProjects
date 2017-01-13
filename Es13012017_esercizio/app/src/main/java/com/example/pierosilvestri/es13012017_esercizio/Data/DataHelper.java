package com.example.pierosilvestri.es13012017_esercizio.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pierosilvestri.es13012017_esercizio.Town.TownHelper;

/**
 * Created by pierosilvestri on 13/01/17.
 */

public class DataHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "towns.db";
    private static final int VERSION = 1;

    public DataHelper(Context aContext){
        super(aContext, DB_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TownHelper.CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
