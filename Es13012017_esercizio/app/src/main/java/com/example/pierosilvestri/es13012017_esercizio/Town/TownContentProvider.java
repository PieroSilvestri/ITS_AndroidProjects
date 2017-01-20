package com.example.pierosilvestri.es13012017_esercizio.Town;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.pierosilvestri.es13012017_esercizio.Data.DataHelper;

/**
 * Created by pierosilvestri on 19/01/17.
 */

public class TownContentProvider extends ContentProvider {

    public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/towns";
    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/towns";

    private static final String AUTHORITY = "com.example.pierosilvestri";
    private static final String BASE_PATH_CONTACTS = "towns";

    public static final Uri TOWNS_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH_CONTACTS);

    private static final int TOWNS = 1;
    private static final int TOWNS_ID = 2;

    private static final UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        // content://com.example.data/contacts - 1
        mUriMatcher.addURI(AUTHORITY, BASE_PATH_CONTACTS, TOWNS);
        // content://com.example.data/contacts/5 - 2
        mUriMatcher.addURI(AUTHORITY, BASE_PATH_CONTACTS + "/#", TOWNS_ID);
    }

    private DataHelper mHelper;


    @Override
    public boolean onCreate() {
        mHelper = new DataHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();

        int uriType = mUriMatcher.match(uri);

        switch (uriType) {
            case TOWNS:
                builder.setTables(TownHelper.TABLE_NAME);
                break;
            case TOWNS_ID:
                builder.setTables(TownHelper.TABLE_NAME);
                builder.appendWhere(TownHelper._ID + "=" + uri.getLastPathSegment());
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
            case TOWNS:
                id = db.insert(TownHelper.TABLE_NAME, null, values);
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
