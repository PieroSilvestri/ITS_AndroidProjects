package com.example.piero.mysqlandroid1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameText, passwordText;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameText = (EditText)findViewById(R.id.textUsername);
        passwordText = (EditText)findViewById(R.id.textPassword);


    }

    public void OnLogin(View view){
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        String type = "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }

    public void OpenReg(View view){
        startActivity(new Intent(this, Register.class));

    }
}
