package com.example.pierosilvestri.es13012017_esercizio.Town;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pierosilvestri.es13012017_esercizio.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by pierosilvestri on 13/01/17.
 */

public class TownAdapter extends BaseAdapter {

    ArrayList<Town> mData;
    Context mContext;

    public TownAdapter(Context aContext, ArrayList<Town> aData){
        this.mContext = aContext;
        this.mData = aData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Town getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mData.get(position).mId;
    }

    class ViewHolder{
        TextView mName;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View vCell;

        if(view == null){
            // Se non esiste creo la view
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);

            // 1) Creiamo la View "cella"
            vCell = layoutInflater.inflate(R.layout.single_town, null);

            // 2) Tiro fuori i riferimenti alla view
            TextView vName = (TextView) vCell.findViewById(R.id.textView_singleTown);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.mName = vName;

            vCell.setTag(viewHolder);
        }else{
            vCell = view;
        }

        ViewHolder viewHolder = (ViewHolder) vCell.getTag();

        // 3) Prendo il dato che mi serve
        Town vTown = getItem(position);
        viewHolder.mName.setText("" + vTown.mName);

        return vCell;
    }
}
