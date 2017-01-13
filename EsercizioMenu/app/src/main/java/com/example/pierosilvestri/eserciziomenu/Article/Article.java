package com.example.pierosilvestri.eserciziomenu.Article;

import java.util.Random;

/**
 * Created by pierosilvestri on 05/01/17.
 */

public class Article {

    private long ID;
    private String art_titolo;
    private String art_contenuto;

    public long getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getArt_title() {
        return art_titolo;
    }

    public void setArt_title(String art_title) {
        this.art_titolo = art_title;
    }

    public String getArt_context() {
        return art_contenuto;
    }

    public void setArt_context(String art_context) {
        this.art_contenuto = art_context;
    }

    public Article(String art_title, String art_context){
        this.art_titolo = art_title;
        this.art_contenuto = art_context;
    }

    public static Article CreateRandom(){
        Random vRand = new Random();

        String vName = "nome" + vRand.nextInt();
        String vSurname = "surname" + vRand.nextInt();

        return new Article(vName, vSurname);
    }
}
