package com.example.recyclerviewtut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter ProgramAdapter;
    RecyclerView.LayoutManager layoutManager;
    String [] recipeName = {"Tokneneng (Filipino Street Food)", "Purple Yam Jam", "Lumpia Mollica"};
    String [] prices = {"1500", "2000","3000"};
    int [] dishimage = {R.drawable.circle_cropped, R.drawable.purpleyam, R.drawable.lumpiamolica};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ProgramAdapter = new ProgramAdapter(this,recipeName,prices,dishimage);
        recyclerView.setAdapter(ProgramAdapter);

    }
}