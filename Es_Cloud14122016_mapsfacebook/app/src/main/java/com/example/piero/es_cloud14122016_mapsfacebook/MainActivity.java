package com.example.piero.es_cloud14122016_mapsfacebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Intent mapsActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapsActivity = new Intent(this, MapsActivity.class);

        Button btn_maps = (Button) findViewById(R.id.btn_maps);
        Button btn_face = (Button) findViewById(R.id.btn_face);

        btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mapsActivity);
            }
        });

    }
}
