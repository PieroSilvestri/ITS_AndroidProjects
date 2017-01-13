package com.example.piero.esercizio1a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parse();
    }

    public void parse(){
        try{

            //17 ; 18 keywords
            InputStream inputStream = getResources().openRawResource(R.raw.attiv_commerc);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            // Pre
            String line = br.readLine();	//read header

            String[] element = new String[18];	//string array to store data of a line

            // Aggiungere l'id dell'attività commerciale
            int i = 0;

            Map<Address, ArrayList<Integer>> addresses = new HashMap<Address, ArrayList<Integer>>();
            Address address = null;

            ArrayList<Integer> sameAddress = new ArrayList<Integer>();


            // Rifaccio il readLine per prendere dalla seconda riga
            while((line = br.readLine()) != null){
                //loop per prendere la linea completa di ogni record
                while(countOccurrences(line, ';') < 17){
                    line = line.concat(br.readLine());
                    System.out.println("numero: " + i + "linea:" + line);
                }

                //array che salva i valori del record
                element = line.split(";");

                //se l'indirizzo è valido, crea oggetto
                if(element[2].length() > 0 && element[3].length() > 0 && element[4].length() > 0){
                    address = new Address(element[2], element[3], element[4], element[5]);
                    ++i;
                    //prende lista di indirizzi già esistenti
                    ArrayList<Integer> temp = addresses.get(address);
                    //controlla se esiste la lista, se sì
                    if(temp == null){
                        sameAddress = new ArrayList<Integer>();
                        sameAddress.add(i);
                        addresses.put(address, sameAddress);
                    }
                    else {
                        temp.add(i);
                        addresses.put(address, temp);
                    }
                }
            }
            System.out.println("Numero record: " + (i-1));

	        /*
	        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyB5GGoPW7HZwSr5t2Oz50-rdCkCZhECuEU");
			GeocodingResult[] results =  GeocodingApi.geocode(context,
					"Milano " + addresses.get(inputId)).await();
			System.out.println(results[0].formattedAddress);


            FileWriter fw = new FileWriter("nomefileout.csv");
            PrintWriter pw = new PrintWriter(fw);
            pw.println("id1;lat;lng;google address");
            int k=0;

            GeoApiContext context = null;
            GeocodingResult[] results = null;

            for(Address tAddress: addresses.keySet()) {
                System.out.println(tAddress.toString());
                pw.println(tAddress);
                if(k<10){
                    context = new GeoApiContext().setApiKey("AIzaSyC3SJmokiUIlTe7-wC4EDl73VuYz-WjKcg");
                    results =  GeocodingApi.geocode(context,
                            "Milano " + tAddress.toString()).await();
                    System.out.println(results[0].formattedAddress);
                }
                ++k;
            }


            pw.close();
            */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int countOccurrences(String str, char c){
        int i = 0;
        for(int j = 0; j<str.length(); ++j){
            if(str.charAt(j) == c)
                ++i;
        }
        return i;
    }
}
