package com.example.mainmenu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.cardview.widget.CardView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.myViewHolder>{

    Context context;
    ArrayList<String>prodak = new ArrayList<>();

    int jumlah;
    int saldo=100000,temp;
    int image[]= {R.drawable.mineral,R.drawable.orange,R.drawable.boba,R.drawable.beer,R.drawable.chocolate,R.drawable.soda};
    String nama[];
    int harga[];

    public OrderListAdapter(Context ct, ArrayList<String> product, String s1[],int s2[],String quantity){
        context=ct;
        prodak=product;
        nama = s1;
        harga = s2;

        jumlah=Integer.parseInt(quantity);
    }

    @NonNull
    @Override
    public OrderListAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.order_list_row, parent, false);
        return new OrderListAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OrderListAdapter.myViewHolder holder, final int position) {
        holder.after.setVisibility(View.INVISIBLE);
        holder.balance.setText("$ " + String.valueOf(saldo));
        holder.total.setText("Total : RP. "+String.valueOf(hitung_total()));
        holder.text1.setText(nama[Integer.parseInt(prodak.get(0))]);
        holder.text2.setText("RP. "+String.valueOf(harga[Integer.parseInt(prodak.get(0))]));
        holder.image.setImageResource(image[Integer.parseInt(prodak.get(0))]);
        holder.qty.setText("x "+String.valueOf(jumlah));
        holder.pay_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.pay_now.getText().equals("Pay Now"))
                {
                    if(saldo >= hitung_total())
                    {
                        saldo = saldo - hitung_total();
                        holder.pay_now.setText("Main Menu");
                        holder.after.setVisibility(View.VISIBLE);
                        holder.balance.setText("$ " + String.valueOf(saldo));
                        holder.after.setText("Your order is complete\nThank You");
                    }
                    else
                    {
                        holder.after.setText("Saldo Tidak Cukup!");
                    }
                }
                else if(holder.pay_now.getText().equals("Main Menu"))
                {
                    Intent back_to_main = new Intent(v.getContext(), MainActivity.class);
                    v.getContext().startActivity(back_to_main);
                }
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDelete();
            }
        });
    }

    public void onDelete()
    {
        prodak.remove(0);
    }

    public int hitung_total()
    {
        int total=0;
        total+= (harga[Integer.parseInt(prodak.get(0))]*jumlah);
        return total;
    }


    @Override
    public int getItemCount() {
        return prodak.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView text1, text2,qty,total,after, balance;
        ImageView image;
        Button pay_now;
        ImageButton delete;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            balance = itemView.findViewById(R.id.Saldo);
            text1= itemView.findViewById(R.id.nama);
            text2= itemView.findViewById(R.id.harga);
            image= itemView.findViewById(R.id.foto);
            pay_now = itemView.findViewById(R.id.pay_now_btn);
            qty = itemView.findViewById(R.id.quantity);
            total = itemView.findViewById(R.id.total);
            delete = itemView.findViewById(R.id.hapus_btn);
            after = itemView.findViewById(R.id.after_pay);
        }
    }

}

