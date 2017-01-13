package it.kdevgroup.storelocator;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Michele on 04/05/2016.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> products;

    public ProductListAdapter(List<Product> products, Context ctx) {
        this.products = products;
        this.context = ctx;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product, parent, false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.txtNome.setText(products.get(position).getName());
        holder.txtPrezzo.setText(products.get(position).getPrice());
        if (products.get(position).isAvailable()) {
            holder.txtDisponibile.setText(context.getString(R.string.disponibile));
            holder.txtDisponibile.setBackgroundColor(Color.GREEN);
        } else {
            holder.txtDisponibile.setText(context.getString(R.string.non_disponibile));
            holder.txtDisponibile.setBackgroundColor(Color.RED);
        }
    }


    @Override
    public int getItemCount() {
        return (products == null) ? 0 : products.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /**
     * "Contenitore" di ogni card
     */
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView txtNome;
        TextView txtPrezzo;
        TextView txtDisponibile;

        ProductViewHolder(View itemView) {
            super(itemView);
//            card = (CardView) itemView.findViewById(R.id.cardView);
            txtNome = (TextView) itemView.findViewById(R.id.product);
            txtPrezzo = (TextView) itemView.findViewById(R.id.price);
            txtDisponibile = (TextView) itemView.findViewById(R.id.available);
        }
    }
}
