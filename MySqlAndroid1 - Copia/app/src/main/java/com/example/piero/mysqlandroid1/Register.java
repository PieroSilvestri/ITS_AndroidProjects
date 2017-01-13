package com.example.piero.mysqlandroid1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText titolo, testo, data, audio, immagine;
    String str_name, str_surname, str_age, str_username, str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        titolo = (EditText)findViewById(R.id.nameText);
        testo = (EditText)findViewById(R.id.surnameText);
        data = (EditText)findViewById(R.id.ageText);
        audio = (EditText)findViewById(R.id.usernameText);
        immagine = (EditText)findViewById(R.id.passwordText);

    }

    public void OnReg(View view){
        String str_titolo = titolo.getText().toString();
        String str_testo = testo.getText().toString();
        String str_data = data.getText().toString();
        String str_audio = audio.getText().toString();
        String str_immagine = immagine.getText().toString();
        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_titolo, str_testo, str_data, str_audio, str_immagine);
    }
}
