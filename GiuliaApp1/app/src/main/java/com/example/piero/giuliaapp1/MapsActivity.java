package com.example.piero.giuliaapp1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String valore;
    private ArrayList<OggettoMaps> arrayList;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Bundle dati = getIntent().getExtras();
        valore = dati.getString("TAGVALORE");

        textView = (TextView)findViewById(R.id.textViewType);
        textView.setText(valore);

        setMapItems();


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    public void setMapItems(){
        OggettoMaps gorizia = new OggettoMaps();
        ArrayList<String> tagGorizia = new ArrayList<String>();
        tagGorizia.add("STORIA");
        tagGorizia.add("SPETTACOLO");
        gorizia.setAll("Gorizia", "Centro città mega bello", "0481 520599", tagGorizia, 45.940181, 13.620175, 0);

        OggettoMaps castelloDiGorizia = new OggettoMaps();
        castelloDiGorizia.setTitle("Castello di Gorizia");
        ArrayList<String> tagCastelloDiGorizia = new ArrayList<String>();
        tagCastelloDiGorizia.add("STORIA");
        tagCastelloDiGorizia.add("CINEMA");
        castelloDiGorizia.setDescription("Storia e spettacolo");
        castelloDiGorizia.setPhone("0481123456");
        castelloDiGorizia.setType(tagCastelloDiGorizia);
        castelloDiGorizia.setLat(45.944444);
        castelloDiGorizia.setLon(13.62779);
        castelloDiGorizia.setId(1);

        OggettoMaps parcoDellaRimembranza = new OggettoMaps();
        ArrayList<String> tagParcoDellaRimembranza = new ArrayList<String>();
        tagParcoDellaRimembranza.add("SPETTACOLO");
        tagParcoDellaRimembranza.add("ARTE");
        parcoDellaRimembranza.setAll("Parco della Rimembranza", "Parco pubblico con monumenti", "0481 560899", tagParcoDellaRimembranza, 45.937920, 13.614172, 2);

        arrayList = new ArrayList<OggettoMaps>();

        arrayList.add(gorizia);
        arrayList.add(castelloDiGorizia);
        arrayList.add(parcoDellaRimembranza);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng castelloGorizia = new LatLng(-34, 151);

        for (OggettoMaps item : arrayList) {
            for(String val : item.getType()){
                if(val.equals(valore)){
                    mMap.addMarker(new MarkerOptions().position(new LatLng(item.getLat(), item.getLon())).snippet(valore + item.getDescription()).title(item.getTitle()));
                }
            }
        }

        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) return;
        googleMap.setMyLocationEnabled(true);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(arrayList.get(0).getLat(), arrayList.get(0).getLon())));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(14));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(MapsActivity.this, DetailsActivity.class);
                Bundle bundle = new Bundle();

                String id = marker.getId();
                id = id.substring(1,id.length());

                for(OggettoMaps item : arrayList){
                    if(item.getTitle().equals(marker.getTitle())){
                        bundle.putString("TITLE", item.getTitle());
                        bundle.putString("DESC", item.getDescription());
                        bundle.putString("PHONE", item.getPhone());
                        bundle.putStringArrayList("TAGS", item.getType());
                        bundle.putDouble("LAT", item.getLat());
                        bundle.putDouble("LON", item.getLon());
                        bundle.putInt("ID", item.getId());
                    }
                }

                intent.putExtras(bundle);
                startActivity(intent);
            }

        });
    }

}
