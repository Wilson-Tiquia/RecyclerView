package com.example.recyclerviewtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MoreInfo extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        TextView tv = findViewById(R.id.nameoffood);
        String fname = "Food name not set";
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            fname = extras.getString("foodname");
        }
        tv.setText(fname);

        lv = (ListView) findViewById(R.id.listv);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> quotes = databaseAccess.getIngredients(fname);
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
        lv.setAdapter(adapter);

    }
}