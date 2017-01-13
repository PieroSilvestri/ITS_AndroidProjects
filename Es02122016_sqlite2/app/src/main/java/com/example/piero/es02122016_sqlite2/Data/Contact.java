package com.example.piero.es02122016_sqlite2.Data;

import java.util.Random;

/**
 * Created by piero on 02/12/2016.
 */
public class Contact {

    public long mId;
    public String mName;
    public String mSurname;

    public Contact(){

    }

    public Contact(String aName, String aSurname){
        mName = aName;
        mSurname = aSurname;
    }

    public Contact(long aId, String aName, String aSurname){
        mId = aId;
        mName = aName;
        mSurname = aSurname;
    }

    public static Contact CreateRandom(){
        Random vRand = new Random();

        String vName = "nome" + vRand.nextInt();
        String vSurname = "surname" + vRand.nextInt();

        return new Contact(vName, vSurname);
    }
}
