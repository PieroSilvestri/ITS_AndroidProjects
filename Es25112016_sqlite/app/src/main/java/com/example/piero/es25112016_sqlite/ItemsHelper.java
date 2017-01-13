package com.example.piero.es25112016_sqlite;

import android.provider.BaseColumns;

/**
 * Created by piero on 25/11/2016.
 */
public class ItemsHelper implements BaseColumns{

    public static final String TABLE_NAME = "items";
    public static final String NAME = "name";
    public static final String QUANTITY = "quantity";

    public static final String CREATE_QUERY =
            "CREATE TABLE " + TABLE_NAME
                    + " ( "+_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NAME + " TEXT NOT NULL, "
                    + QUANTITY + " NOT NULL "
                    + " );";

    public static final String DROP_QUERY =
            "DROP TABLE IF EXIST " + TABLE_NAME;
}

