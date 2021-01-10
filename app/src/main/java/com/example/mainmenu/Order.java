package com.example.mainmenu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Order extends AppCompatActivity {

    private ArrayList<String> posisi;

    RecyclerView recyclerView;
    String s1[];
    int s2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.bar_aksi3);


        Bundle intent1 = getIntent().getExtras();
        posisi = intent1.getStringArrayList("posisi");

        recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.drinks);
        s2 = getResources().getIntArray(R.array.price);

        OrderAdapter orderadapter = new OrderAdapter(this, posisi,s1,s2);
        recyclerView.setAdapter(orderadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}