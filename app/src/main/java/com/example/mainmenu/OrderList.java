package com.example.mainmenu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class OrderList extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<String> produk = new ArrayList<>();
    int image[]= {R.drawable.mineral,R.drawable.orange,R.drawable.boba,R.drawable.beer,R.drawable.chocolate,R.drawable.soda};
    String s1[];
    int s2[];
    String qty;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.bar_aksi4);

        recyclerView = findViewById(R.id.recyclerView3);
        s1 = getResources().getStringArray(R.array.drinks);
        s2 = getResources().getIntArray(R.array.price);

        Bundle intent1 = getIntent().getExtras();
        produk = intent1.getStringArrayList("produk");
        qty = intent1.getString("quantity");

        OrderListAdapter orderlistadapter = new OrderListAdapter(this,produk,s1,s2,qty);
        recyclerView.setAdapter(orderlistadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}