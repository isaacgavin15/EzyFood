package com.example.mainmenu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.cardview.widget.CardView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.myViewHolder>{

    Context context;
    ArrayList<String>posisi;

    int image[]= {R.drawable.mineral,R.drawable.orange,R.drawable.boba,R.drawable.beer,R.drawable.chocolate,R.drawable.soda};
    String nama[];
    int harga[];


    public OrderAdapter(Context ct, ArrayList<String> product, String s1[],int s2[]){
        context=ct;
        posisi=product;
        nama = s1;
        harga = s2;
    }

    @NonNull
    @Override
    public OrderAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.order_layout_row, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OrderAdapter.myViewHolder holder, final int position) {
        holder.text1.setText(nama[Integer.parseInt(posisi.get(position))]);
        holder.text2.setText("RP. "+String.valueOf(harga[Integer.parseInt(posisi.get(position))]));
        holder.image.setImageResource(image[Integer.parseInt(posisi.get(position))]);
        holder.order_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_drink = new Intent(v.getContext(), Drink.class);
                v.getContext().startActivity(intent_drink);
            }
        });
        holder.my_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_order_list = new Intent(v.getContext(), OrderList.class);
                intent_order_list.putExtra("produk", posisi);
                intent_order_list.putExtra("quantity",holder.qty.getText().toString());
                v.getContext().startActivity(intent_order_list);
            }
        });
    }


    @Override
    public int getItemCount() {
        return posisi.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView text1, text2;
        ImageView image;
        Button my_order, order_more;
        TextInputEditText qty;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            text1= itemView.findViewById(R.id.nama_produk);
            text2= itemView.findViewById(R.id.harga_produk);
            image= itemView.findViewById(R.id.gambar_produk);
            my_order = itemView.findViewById(R.id.my_order_btn);
            order_more = itemView.findViewById(R.id.order_more_btn);
            qty = itemView.findViewById(R.id.jumlah_produk);
        }
    }
}
