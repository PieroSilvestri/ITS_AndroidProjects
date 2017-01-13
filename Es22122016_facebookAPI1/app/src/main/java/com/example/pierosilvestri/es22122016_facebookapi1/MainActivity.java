package com.example.pierosilvestri.es22122016_facebookapi1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    CallbackManager callbackManager;
    TextView my_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_main);

        callbackManager = CallbackManager.Factory.create();

        my_text = (TextView)findViewById(R.id.textView2);

        LoginButton loginButton = (LoginButton) findViewById(R.id.btn_login);
        loginButton.setReadPermissions("email");

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(MainActivity.this, "Accesso effettuato", Toast.LENGTH_SHORT).show();
                my_text.setText("Login Effettuato");
                // App code
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "Accesso NON effettuato", Toast.LENGTH_SHORT).show();
                my_text.setText("OnCancel");
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Toast.makeText(MainActivity.this, "Accesso NON effettuato", Toast.LENGTH_SHORT).show();
                my_text.setText("OnError");

            }


        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
