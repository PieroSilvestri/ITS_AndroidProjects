package com.example.piero.testdialog;

import android.app.Application;

/**
 * Created by piero on 13/05/2016.
 */
public class MainApp extends Application {

    private static MainApp mInstance;

    public int pippo;
    public static MainApp get(){
        return mInstance;
    }
    @Override
    public void onCreate(){
        super.onCreate();


        mInstance = this;
        initForTest();

    }

    private void initForTest(){
        pippo = 198;
    }




}
