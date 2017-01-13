package com.example.pierosilvestri.es13012017_esercizio.Town;

import android.provider.BaseColumns;

/**
 * Created by pierosilvestri on 13/01/17.
 */

public class TownHelper implements BaseColumns {
    public static final String TABLE_NAME = "Towns";
    public static final String NAME = "name";

    public static final String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME
            + " ( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME  + " TEXT NOT NULL "
            + ");";
}
