package com.example.pierosilvestri.es13012017_esercizio.TownDetail;

/**
 * Created by pierosilvestri on 19/01/17.
 */

public class TownDetail {

    public long mId;
    public int townId;
    public int temperatura;
    public String data;

    public TownDetail(){}

    public TownDetail(int nTownId, int nTemperatura, String nData){
        townId = nTownId;
        temperatura = nTemperatura;
        data = nData;
    }

}
