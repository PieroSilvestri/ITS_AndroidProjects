package com.example.piero.es11112016esercizio;

import java.util.Random;

/**
 * Created by piero on 11/11/2016.
 */
public class Item {

    public int itemID;
    public String title;
    public int progress;
    public int rating;

    public Item(int hotelID){

        itemID = hotelID;
        title = "Hotel numero: " + hotelID;
        Random rProgress = new Random();
        progress = rProgress.nextInt(100);
        Random rRating = new Random();
        rating = rRating.nextInt(10);
    }

}
