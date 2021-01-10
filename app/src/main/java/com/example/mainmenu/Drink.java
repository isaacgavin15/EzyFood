package com.example.mainmenu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Drink extends AppCompatActivity {

    RecyclerView recyclerView;
    int image[]= {R.drawable.mineral,R.drawable.orange,R.drawable.boba,R.drawable.beer,R.drawable.chocolate,R.drawable.soda};
    String s1[];
    int s2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.bar_aksi2);

        recyclerView = findViewById(R.id.recycleView);
        s1 = getResources().getStringArray(R.array.drinks);
        s2 = getResources().getIntArray(R.array.price);

        myAdapter myadapter = new myAdapter(this,s1,s2,image);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}