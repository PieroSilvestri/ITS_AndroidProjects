package com.example.piero.mysql_jsonparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    JSONObject jsonObject;
    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.usernameEdit);
        password = (EditText)findViewById(R.id.passwordEdit);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin(username.getText().toString(), password.getText().toString());
            }
        });


    }

    public void onLogin(String username, String password){
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        String url = "http://pierosilvestri1.altervista.org/mysql-android/login.php?username="+username+"&password="+password;
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    jsonObject = new JSONObject(new String(responseBody));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("MYJSON", jsonObject.toString());

                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("server_response");
                    Toast.makeText(MainActivity.this, jsonArray.getJSONObject(0).getString("autentication"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(MainActivity.this, "Errore", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
