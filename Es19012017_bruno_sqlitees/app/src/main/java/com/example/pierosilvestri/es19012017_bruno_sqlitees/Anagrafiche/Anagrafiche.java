package com.example.pierosilvestri.es19012017_bruno_sqlitees.Anagrafiche;

import java.util.Random;

/**
 * Created by pierosilvestri on 19/01/17.
 */

public class Anagrafiche {
    public long aId;
    public String nome;
    public String cognome;
    public String dataNascita;
    public String email;
    public String telefono;
    public String indirizzo;
    public int civico;
    public String citta;
    public int casellaPostale;
    public String provincia;
    public int lat;
    public int lon;

    public Anagrafiche(){}

    public Anagrafiche(String nNome, String nCognome, String nDataNascita, String nEmail, String nTelefono, String nIndirizzo, int nCivico, String nCitta, int nCasellaPostale, String nProvincia){
        nome = nNome;
        cognome = nCognome;
        dataNascita = nDataNascita;
        email = nEmail;
        telefono = nTelefono;
        indirizzo = nIndirizzo;
        civico = nCivico;
        citta = nCitta;
        casellaPostale = nCasellaPostale;
        provincia = nProvincia;
    }

    public static Anagrafiche anagraficheRandom(){
        Random random = new Random();

        String mNome = "Nome " + random.nextInt();
        String mCognome = "Cognome" + random.nextInt();
        String mDataNascita = random.nextInt() + "/2017";
        String mEmail = random.nextInt() + "@gmail.com";
        String mTelefono = "" + random.nextInt();
        String mIndirizzo = "Via Roma " + random.nextInt();
        int mCivico = random.nextInt();
        String mCitta = "Città " + random.nextInt();
        int mCasellaPostale = random.nextInt();
        String mProvincia = "Provincia " + random.nextInt();

        return new Anagrafiche(mNome, mCognome, mDataNascita, mEmail, mTelefono, mIndirizzo, mCivico, mCitta, mCasellaPostale, mProvincia);
    }
}
