package com.example.piero.es04112016intent;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final int PICK_CONTACT_CODE = 1029;

    @Override
    protected void onActivityResult(int requestCode, int resulCode, Intent data){
        if(requestCode == PICK_CONTACT_CODE && resulCode == RESULT_OK){

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupGui();
    }

    private void setupGui(){

        Button btn_web = (Button) findViewById(R.id.btn_web);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickWeb();
            }
        });

        Button btn_sms = (Button) findViewById(R.id.btn_sms);
        btn_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSms();
            }
        });

        Button btn_contacts = (Button) findViewById(R.id.btn_contact);
        btn_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickContacts();
            }
        });
    }

    private void clickWeb() {
        Uri webpage = Uri.parse("https://www.google.com");
        Intent vIntent = new Intent(Intent.ACTION_VIEW);
        vIntent.setData(webpage);
        // Crea il mio chooser
        Intent vChooser = Intent.createChooser(vIntent, "Il mio titolo");

        if(vIntent.resolveActivity(getPackageManager()) != null){
            startActivity(vChooser);
        }
    }

    private void pickContacts(){

        Intent vIntent = new Intent(Intent.ACTION_PICK);
        vIntent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if(vIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(vIntent, PICK_CONTACT_CODE);
        }
    }

    private void clickSms(){
        /* First Method */
        /*
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", "Ciao a tutti");
        //intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        */

        /* Second method */
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Pippo");
        sendIntent.setType("text/plain");

        if(sendIntent.resolveActivity(getPackageManager()) != null){
            startActivity(sendIntent);
        }
    }
}
