package com.example.mainmenu;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    String data1[];
    int data2[],img[];
    Context context;
    private ArrayList<String> product = new ArrayList<String>();

    public myAdapter(Context ct, String s1[], int s2[], int images[]){
        context=ct;
        data1 = s1;
        data2 = s2;
        img = images;
    }

    @NonNull
    @Override
    public myAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.lay_row, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.myViewHolder holder, final int position) {
        holder.text1.setText(data1[position]);
        holder.text2.setText("RP. "+String.valueOf(data2[position]));
        holder.image.setImageResource(img[position]);

        holder.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_drink = new Intent(v.getContext(), Order.class);
                product.add(String.valueOf(position));
                intent_drink.putExtra("posisi",product);
                v.getContext().startActivity(intent_drink);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView text1, text2;
        ImageView image;
        Button btnOrder;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            text1= itemView.findViewById(R.id.drinkTitle);
            text2= itemView.findViewById(R.id.drinkDesc);
            image= itemView.findViewById(R.id.drinkImage);
            btnOrder = itemView.findViewById(R.id.orderBtn);
        }
    }
}
