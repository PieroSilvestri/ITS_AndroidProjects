package com.example.piero.es11112016esercizio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by piero on 11/11/2016.
 */
public class CustomAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Item> list_hotel;

    public CustomAdapter(Context aContex, ArrayList<Item> aData){
        list_hotel = aData;
        context = aContex;
    }

    @Override
    public int getCount() {
        return list_hotel.size();
    }

    @Override
    public Item getItem(int i) {
        return list_hotel.get(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).itemID;
    }

    class ViewHolder{
        TextView vhTitolo;
        ProgressBar vhProgress;
        RatingBar vhRating;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vCell;
        // Controllo se la view esiste o no
        // Questo mi serve per non fare l'inflater ogni volta risparmiando memoria
        if(view == null){
            // Se non esiste creo la view
            LayoutInflater layoutInflater = LayoutInflater.from(context);

            // 1) Creiamo la View "cella"
            vCell = layoutInflater.inflate(R.layout.item_layout, null);

            // 2) Tiro fuori i referimenti alla View
            TextView vTitolo = (TextView) vCell.findViewById(R.id.txt_title);
            ProgressBar vProgress = (ProgressBar) vCell.findViewById(R.id.progressBar);
            RatingBar vRating = (RatingBar) vCell.findViewById(R.id.ratingBar);

            ViewHolder vHolder = new ViewHolder();
            vHolder.vhTitolo = vTitolo;
            vHolder.vhProgress = vProgress;
            vHolder.vhRating = vRating;

            vCell.setTag(vHolder);

        }else{
            vCell = view;
        }

        ViewHolder viewHolder = (ViewHolder) vCell.getTag();


        // 3) Prendo il dato che mi serve
        Item vItem = getItem(i);

        // 4) Aggancio il dato con i valore che voglio
        viewHolder.vhTitolo.setText(vItem.title);
        viewHolder.vhProgress.setProgress(vItem.progress);
        viewHolder.vhRating.setNumStars(7);
        viewHolder.vhRating.setProgress(vItem.rating);

        return vCell;

    }
}
