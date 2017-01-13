package com.example.pierosilvestri.eserciziomenu.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pierosilvestri.eserciziomenu.Article.ArticleAdapter;
import com.example.pierosilvestri.eserciziomenu.Article.ArticlesHelper;

/**
 * Created by pierosilvestri on 06/01/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "articles.db";
    private static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ArticlesHelper.CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
