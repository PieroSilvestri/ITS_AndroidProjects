package com.example.pierosilvestri.es13012017_esercizio.Town;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
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

public class TownAdapter extends CursorAdapter {

    public TownAdapter(Context context, Cursor c) {
        super(context, c, false);
    }

    private class ViewHolder {
        TextView txtNome, txtCognome;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_town, null);

        ViewHolder holder = new ViewHolder();
        holder.txtNome = (TextView) view.findViewById(R.id.textView_singleTown);
        view.setTag(holder);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.txtNome.setText("" + cursor.getString(cursor.getColumnIndex(TownHelper.NAME)));
    }
}
