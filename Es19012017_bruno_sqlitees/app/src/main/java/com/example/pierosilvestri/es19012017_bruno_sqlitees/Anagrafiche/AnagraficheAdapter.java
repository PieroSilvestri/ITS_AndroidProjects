package com.example.pierosilvestri.es19012017_bruno_sqlitees.Anagrafiche;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pierosilvestri.es19012017_bruno_sqlitees.R;

/**
 * Created by pierosilvestri on 19/01/17.
 */

public class AnagraficheAdapter extends CursorAdapter {

    public AnagraficheAdapter(Context context, Cursor c) {
        super(context, c, false);
    }

    private class ViewHolder {
        TextView txtNome, txtCognome;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cell, null);

        ViewHolder holder = new ViewHolder();
        holder.txtNome = (TextView) view.findViewById(R.id.text_nome);
        holder.txtCognome = (TextView) view.findViewById(R.id.text_cognome);
        view.setTag(holder);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.txtNome.setText("" + cursor.getString(cursor.getColumnIndex(AnagraficheHelper.NOME)));
        holder.txtCognome.setText("" + cursor.getString(cursor.getColumnIndex(AnagraficheHelper.COGNOME)));
    }
}
