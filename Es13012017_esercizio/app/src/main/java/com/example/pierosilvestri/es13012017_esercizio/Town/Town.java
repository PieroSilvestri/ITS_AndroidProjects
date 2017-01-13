package com.example.pierosilvestri.es13012017_esercizio.Town;

import java.util.Random;

/**
 * Created by pierosilvestri on 13/01/17.
 */

public class Town {

    public long mId;
    public String mName;

    public Town(){}

    public Town(String nName){
        mName = nName;
    }

    public Town(int nId, String nName){
        mId = nId;
        mName = nName;
    }

    public static Town CreateRandomTown(){
        Random vRand = new Random();

        String vName = "Città" + vRand.nextInt();


        return new Town(vName);
    }

}
