package com.example.piero.es02122016_sqlite2.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.piero.es02122016_sqlite2.R;

import java.util.ArrayList;

/**
 * Created by piero on 02/12/2016.
 */
public class ContactsAdapter extends BaseAdapter {

    ArrayList<Contact> mData;
    Context mContext;

    public ContactsAdapter(Context aContext,ArrayList<Contact> aData){
        mContext = aContext;
        mData = aData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Contact getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).mId;
    }

    class ViewHolder{
        TextView mId;
        TextView mName;
        TextView mSurname;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vCell;
        // Controllo se la view esiste o no
        // Questo mi serve per non fare l'inflater ogni volta risparmiando memoria
        if(view == null){
            // Se non esiste creo la view
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);

            // 1) Creiamo la View "cella"
            vCell = layoutInflater.inflate(R.layout.cell, null);

            // 2) Tiro fuori i referimenti alla View
            TextView vId = (TextView) vCell.findViewById(R.id.txt_ID);
            TextView vName = (TextView) vCell.findViewById(R.id.txt_name);
            TextView vSurname = (TextView) vCell.findViewById(R.id.txt_surname);

            ViewHolder vHolder = new ViewHolder();
            vHolder.mId = vId;
            vHolder.mName = vName;
            vHolder.mSurname = vSurname;

            vCell.setTag(vHolder);

        }else{
            vCell = view;
        }

        ViewHolder viewHolder = (ViewHolder) vCell.getTag();

        // 3) Prendo il dato che mi serve
        Contact vContact = getItem(i);
        // 4) Aggancio il dato con i valore che voglio
        viewHolder.mId.setText("" + vContact.mId);
        viewHolder.mName.setText("" + vContact.mName);
        viewHolder.mSurname.setText("" + vContact.mSurname);

        return vCell;
    }
}
