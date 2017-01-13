package com.example.pierosilvestri.es13012017_esercizio.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pierosilvestri.es13012017_esercizio.Town.Town;
import com.example.pierosilvestri.es13012017_esercizio.Town.TownHelper;

import java.util.ArrayList;

/**
 * Created by pierosilvestri on 13/01/17.
 */

public class Dataset {

    private static Dataset mInstance = null;

    public static Dataset Get(Context aContext){
        if(mInstance == null){
            mInstance = new Dataset(aContext);
        }

        return mInstance;
    }

    ArrayList<Town> mTowns;
    DataHelper mDataHelper;

    private Dataset(Context aContext){
        mTowns = new ArrayList<>();
        mDataHelper = new DataHelper(aContext);
    }

    public  ArrayList<Town> getTowns(){
        // Readable Perchè devo leggere
        SQLiteDatabase vDB = mDataHelper.getReadableDatabase();

        Cursor vCursor = vDB.query(TownHelper.TABLE_NAME, null, null, null, null, null, null);

        while(vCursor.moveToNext()){
            Town vContact = new Town();
            vContact.mId = vCursor.getLong(vCursor.getColumnIndex(TownHelper._ID));
            vContact.mName = vCursor.getString(vCursor.getColumnIndex(TownHelper.NAME));

            mTowns.add(vContact);
        }
        vCursor.close();
        vDB.close();

        return mTowns;
    }

    public Town addTown(Town aContact){

        // Writable perchè ci devo scrivere
        SQLiteDatabase vDB = mDataHelper.getWritableDatabase();

        ContentValues vValue = new ContentValues();
        vValue.put(TownHelper.NAME, aContact.mName);

        // la funzione insert torna un long
        long vInseredId = vDB.insert(TownHelper.TABLE_NAME, null, vValue);

        aContact.mId = vInseredId;
        vDB.close();

        mTowns.add(aContact);
        return aContact;
    }

    public boolean removeTown(long aID){

        SQLiteDatabase vDB = mDataHelper.getWritableDatabase();
        int vRows = vDB.delete(TownHelper.TABLE_NAME, TownHelper._ID + " = " + aID, null);

        int vRemovePosition = -1;
        // Faccio questo per trovare la POSIZIONE dell'elemento da cancellare
        // non tramite l'ID ovviamente perchè usiamo la posizione dell'arrayList
        for (int vIndex = 0; vIndex < mTowns.size(); vIndex++){
            if(mTowns.get(vIndex).mId == aID){
                vRemovePosition = vIndex;
                break;
            }
        }
        if(vRemovePosition >= 0){
            mTowns.remove(vRemovePosition);
        }

        mTowns.remove(aID);
        return (vRows > 0);
    }

}
