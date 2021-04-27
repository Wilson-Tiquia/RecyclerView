package com.example.recyclerviewtut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    DishInfoAdapter.RecyclerViewClickListener listener;
    ArrayList<DishInfo> dishInfoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setOnClickListener();
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        dishInfoList = databaseAccess.getImageAndName();
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        DishInfoAdapter dishInfoAdapter = new DishInfoAdapter(this, dishInfoList,recyclerView,listener);
        recyclerView.setAdapter(dishInfoAdapter);
        databaseAccess.close();

    }

    private void setOnClickListener() {
        listener = new DishInfoAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), MoreInfo.class);
                intent.putExtra("foodname", dishInfoList.get(position).getDishName());
                startActivity(intent);

            }
        };
    }
}