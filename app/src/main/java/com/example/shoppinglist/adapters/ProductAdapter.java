package com.example.shoppinglist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppinglist.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private List<String> products = new ArrayList<>();
    private final Context context;

    public ProductAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        holder.productTextView.setText(products.get(position));
        holder.productDeleteButton.setOnClickListener(v -> {
            products.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount());
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void add(String product) {
        if (product.isBlank()) {
            Toast.makeText(context, R.string.warnEmptyProduct, Toast.LENGTH_SHORT).show();
        } else {
            products.add(product);
            this.notifyItemInserted(getItemCount());
        }
    }

    public void deleteAll() {
        int itemCount = products.size();
        products = new ArrayList<>();

        notifyItemRangeRemoved(0, itemCount);
        Toast.makeText(context, String.format(context.getString(R.string.deleteResult), itemCount), Toast.LENGTH_SHORT).show();
    }

    public static class ProductHolder extends RecyclerView.ViewHolder {

        public TextView productTextView;
        public ImageButton productDeleteButton;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            productTextView = itemView.findViewById(R.id.text_item);
            productDeleteButton = itemView.findViewById(R.id.delete_item);
        }
    }
}
