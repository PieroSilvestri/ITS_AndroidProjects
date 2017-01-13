package com.example.piero.es11112016listview;

import java.util.Random;

/**
 * Created by piero on 11/11/2016.
 */
public class Item {

    public int mID;
    public String mName;
    public int mLiter;
    public String valore;

    public Item(int aID){
        mID = aID;
        mName = "Birra " + aID;
        Random vRand = new Random();
        mLiter = vRand.nextInt(10);
        valore ="Rating: " + vRand.nextInt(5);
    }
}
