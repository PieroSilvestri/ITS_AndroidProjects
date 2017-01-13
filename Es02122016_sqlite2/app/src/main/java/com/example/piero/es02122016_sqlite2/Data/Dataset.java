package com.example.piero.es02122016_sqlite2.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by piero on 02/12/2016.
 */
public class Dataset {
    private static Dataset mInstance = null;

    public static Dataset Get(Context aContext){
        if(mInstance == null){
            mInstance = new Dataset(aContext);
        }

        return mInstance;
    }

    ArrayList<Contact> mContacts;

    DatabaseHelper databaseHelper;


    private Dataset(Context aContext){
        mContacts = new ArrayList<>();
        databaseHelper = new DatabaseHelper(aContext);
    }

    public  ArrayList<Contact> getContacts(){
        // Readable Perchè devo leggere
        SQLiteDatabase vDB = databaseHelper.getReadableDatabase();
        Cursor vCursor = vDB.query(ContactsHelper.TABLE_NAME, null, null, null, null, null, null);

        while(vCursor.moveToNext()){
            Contact vContact = new Contact();
            vContact.mId = vCursor.getLong(vCursor.getColumnIndex(ContactsHelper._ID));
            vContact.mName = vCursor.getString(vCursor.getColumnIndex(ContactsHelper.NAME));
            vContact.mSurname = vCursor.getString(vCursor.getColumnIndex(ContactsHelper.SURNAME));

            mContacts.add(vContact);
        }
        vCursor.close();
        vDB.close();

        return mContacts;
    }

    public Contact addContact(Contact aContact){

        // Writable perchè ci devo scrivere
        SQLiteDatabase vDB = databaseHelper.getWritableDatabase();

        ContentValues vValue = new ContentValues();
        vValue.put(ContactsHelper.NAME, aContact.mName);
        vValue.put(ContactsHelper.SURNAME, aContact.mSurname);

        // la funzione insert torna un long
        long vInseredId = vDB.insert(ContactsHelper.TABLE_NAME, null, vValue);

        aContact.mId = vInseredId;
        vDB.close();

        mContacts.add(aContact);
        return aContact;
    }

    public boolean removeContact(long aID){

        SQLiteDatabase vDB = databaseHelper.getWritableDatabase();
        int vRows = vDB.delete(ContactsHelper.TABLE_NAME, ContactsHelper._ID + " = " + aID, null);

        int vRemovePosition = -1;
        // Faccio questo per trovare la POSIZIONE dell'elemento da cancellare
        // non tramite l'ID ovviamente perchè usiamo la posizione dell'arrayList
        for (int vIndex = 0; vIndex < mContacts.size(); vIndex++){
            if(mContacts.get(vIndex).mId == aID){
                vRemovePosition = vIndex;
                break;
            }
        }
        if(vRemovePosition >= 0){
            mContacts.remove(vRemovePosition);
        }

        mContacts.remove(aID);
        return (vRows > 0);
    }

}
