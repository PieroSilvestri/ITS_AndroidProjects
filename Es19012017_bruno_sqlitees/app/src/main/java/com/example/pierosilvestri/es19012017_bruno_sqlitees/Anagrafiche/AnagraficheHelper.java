package com.example.pierosilvestri.es19012017_bruno_sqlitees.Anagrafiche;

import android.provider.BaseColumns;

/**
 * Created by pierosilvestri on 19/01/17.
 */

public class AnagraficheHelper implements BaseColumns {

    public static final String TABLE_NAME = "anagrafiche";
    public static final String NOME = "nome";
    public static final String COGNOME = "cognome";
    public static final String DATANASCITA = "dataNascita";
    public static final String EMAIL = "email";
    public static final String TELEFONO = "telefono";
    public static final String INDIRIZZO = "indirizzo";
    public static final String CIVICO = "civico";
    public static final String CITTA = "citta";
    public static final String CAP = "cap";
    public static final String PROVINCIA = "provincia";
    public static final String LATITUDINE = "latitudine";
    public static final String LONGITUDINE = "longitudine";


    public static final String CREATE_QUERY =
            "CREATE TABLE " + TABLE_NAME + " ( " +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + // _id obbligatorio
                    NOME + " TEXT NOT NULL, " +
                    COGNOME + " TEXT NOT NULL," +
                    DATANASCITA + " TEXT NOT NULL," +
                    EMAIL + " TEXT NOT NULL," +
                    TELEFONO + " TEXT NOT NULL," +
                    INDIRIZZO + " TEXT NOT NULL," +
                    CIVICO + " INTEGER NOT NULL," +
                    CITTA + " TEXT NOT NULL," +
                    CAP + " INTEGER NOT NULL," +
                    PROVINCIA + " TEXT NOT NULL," +
                    LATITUDINE + " INTEGER NOT NULL," +
                    LONGITUDINE + " INTEGER NOT NULL" +
                    ");";

    public static final String DROP_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

}
