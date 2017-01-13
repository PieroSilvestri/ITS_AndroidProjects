package com.example.pierosilvestri.eserciziomenu.Article;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pierosilvestri.eserciziomenu.R;

import java.util.ArrayList;

/**
 * Created by pierosilvestri on 05/01/17.
 */

public class ArticleAdapter extends BaseAdapter {

    ArrayList<Article> articles;
    Context mContext;

    public ArticleAdapter(Context aContext, ArrayList<Article> aArticles){
        mContext = aContext;
        articles = aArticles;
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Article getItem(int position) {return articles.get(position);}

    @Override
    public long getItemId(int position) {return articles.get(position).getID();}

    class ViewHolder{
        TextView mId;
        TextView mTitolo;
        TextView mContenuto;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View vCell;
        if(view == null){
            // Se non esiste creo la view
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);

            // 1) Creiamo la view cella
            vCell = layoutInflater.inflate(R.layout.cell, null);

            // 2) Tiro fuori i riferimenti alla view
            TextView vId = (TextView) vCell.findViewById(R.id.textId);
            TextView vTitle = (TextView) vCell.findViewById(R.id.textTitle);
            TextView vContext = (TextView) vCell.findViewById(R.id.textContext);

            ViewHolder vHolder = new ViewHolder();
            vHolder.mId = vId;
            vHolder.mTitolo = vTitle;
            vHolder.mContenuto = vContext;

            vCell.setTag(vHolder);
        }else{
            vCell = view;
        }

        ViewHolder viewHolder = (ViewHolder) vCell.getTag();

        // 3) Prendo il dato che mi serve
        Article vArticle = getItem(position);
        // 4) Aggancio il dato con il valore che voglio
        viewHolder.mId.setText("" + vArticle.getID());
        viewHolder.mTitolo.setText("" + vArticle.getArt_title());
        viewHolder.mContenuto.setText("" + vArticle.getArt_context());

        return vCell;
    }
}
