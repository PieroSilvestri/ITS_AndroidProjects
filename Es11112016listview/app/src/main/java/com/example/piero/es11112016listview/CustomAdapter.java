package com.example.piero.es11112016listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by piero on 11/11/2016.
 */
public class CustomAdapter extends BaseAdapter {

    private Context mContex;
    private ArrayList<Item> mData;

    public CustomAdapter(Context aContex, ArrayList<Item> aData){
        mData = aData;
        mContex = aContex;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Item getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).mID;
    }

    class ViewHolder{

        TextView mName;
        TextView mLiter;
        TextView valore;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vCell;
        // Controllo se la view esiste o no
        // Questo mi serve per non fare l'inflater ogni volta risparmiando memoria
        if(view == null){
            // Se non esiste creo la view
            LayoutInflater layoutInflater = LayoutInflater.from(mContex);

            // 1) Creiamo la View "cella"
            vCell = layoutInflater.inflate(R.layout.item_layout, null);

            // 2) Tiro fuori i referimenti alla View
            TextView vName = (TextView) vCell.findViewById(R.id.txt_name);
            TextView vLiter = (TextView) vCell.findViewById(R.id.txt_value);
            TextView vValore = (TextView) vCell.findViewById(R.id.txt_valore);

            ViewHolder vHolder = new ViewHolder();
            vHolder.mName = vName;
            vHolder.mLiter = vLiter;
            vHolder.valore = vValore;

            vCell.setTag(vHolder);

        }else{
            vCell = view;
        }

        ViewHolder viewHolder = (ViewHolder) vCell.getTag();


        // 3) Prendo il dato che mi serve
        Item vItem = getItem(i);

        // 4) Aggancio il dato con i valore che voglio
        viewHolder.mName.setText(vItem.mName);
        viewHolder.mLiter.setText("" + vItem.mLiter);
        viewHolder.valore.setText(vItem.valore);

        return vCell;
    }
}
