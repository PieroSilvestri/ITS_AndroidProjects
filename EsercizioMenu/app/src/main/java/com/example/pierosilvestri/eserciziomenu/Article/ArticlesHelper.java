package com.example.pierosilvestri.eserciziomenu.Article;

import android.provider.BaseColumns;

/**
 * Created by pierosilvestri on 06/01/17.
 */

public class ArticlesHelper implements BaseColumns {

    public static final String TABLE_NAME = "Articles";
    public static final String TITLE = "title";
    public static final String CONTENUTO = "contenuto";

    public static final String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME
            + " ( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TITLE  + " TEXT NOT NULL, "
            + CONTENUTO + " TEXT NOT NULL "
            + ");";

}
