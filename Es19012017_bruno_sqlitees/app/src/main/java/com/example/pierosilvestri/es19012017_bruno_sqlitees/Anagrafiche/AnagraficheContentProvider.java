package com.example.pierosilvestri.es19012017_bruno_sqlitees.Anagrafiche;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.pierosilvestri.es19012017_bruno_sqlitees.Data.DbHelper;

/**
 * Created by pierosilvestri on 19/01/17.
 */

public class AnagraficheContentProvider extends ContentProvider {

    public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/anagrafiche";
    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/anagrafiche";

    private static final String AUTHORITY = "com.example.pierosilvestri";
    private static final String BASE_PATH_CONTACTS = "anagrafiche";

    public static final Uri ANAGRAFICHE_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH_CONTACTS);

    private static final int ANAGRAFICHE = 1;
    private static final int ANAGRAFICHE_ID = 2;

    private static final UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        // content://com.example.data/contacts - 1
        mUriMatcher.addURI(AUTHORITY, BASE_PATH_CONTACTS, ANAGRAFICHE);
        // content://com.example.data/contacts/5 - 2
        mUriMatcher.addURI(AUTHORITY, BASE_PATH_CONTACTS + "/#", ANAGRAFICHE_ID);
    }

    private DbHelper mHelper;


    @Override
    public boolean onCreate() {

        mHelper = new DbHelper(getContext());

        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();

        int uriType = mUriMatcher.match(uri);

        switch (uriType) {
            case ANAGRAFICHE:
                builder.setTables(AnagraficheHelper.TABLE_NAME);
                break;
            case ANAGRAFICHE_ID:
                builder.setTables(AnagraficheHelper.TABLE_NAME);
                builder.appendWhere(AnagraficheHelper._ID + "=" + uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Unknown uri: " + uri);
        }

        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = builder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = mUriMatcher.match(uri);
        SQLiteDatabase db = mHelper.getWritableDatabase();
        long id = 0;

        switch (uriType) {
            case ANAGRAFICHE:
                id = db.insert(AnagraficheHelper.TABLE_NAME, null, values);
                break;
            default:
                throw new IllegalArgumentException("Unknown uri: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);

        db.close();

        return Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH_CONTACTS + "/" + id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
