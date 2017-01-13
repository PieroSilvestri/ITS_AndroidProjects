package com.example.piero.giuliaapp1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import android.widget.Toast;
import java.net.URI;
import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    private TextView textViewTitle, textViewDesc, textViewPhone;
    private ImageButton phoneImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle dati = getIntent().getExtras();

        String title = dati.getString("TITLE");
        String desc = dati.getString("DESC");
        final String phone = dati.getString("PHONE");
        ArrayList<String> tags = dati.getStringArrayList("TAGS");
        Double lat = dati.getDouble("LAT");
        Double lon = dati.getDouble("LON");
        int id = dati.getInt("ID");

        textViewTitle = (TextView)findViewById(R.id.textViewTitle);
        textViewTitle.setText(title);

        textViewDesc = (TextView)findViewById(R.id.textViewDesc);
        textViewDesc.setText(desc);

        textViewPhone = (TextView)findViewById(R.id.textViewPhone);
        textViewPhone.setText(phone);

        phoneImage = (ImageButton) findViewById(R.id.phoneImage);

        phoneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone)));
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.imageViewDetail);
        // link img placeholder  Picasso.with(this).load(jsonObject.getString("featured_image")).into(imageView);
        imageView.setImageResource(R.drawable.immagine);

    }
}
