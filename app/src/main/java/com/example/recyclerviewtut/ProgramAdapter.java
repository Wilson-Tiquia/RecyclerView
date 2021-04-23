package com.example.recyclerviewtut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {

    Context context;
    String [] dishname;
    String [] prices;
    int [] images;

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        TextView name;
        TextView price;
        ImageView dishPic;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.ulamname);
            price = (TextView) itemView.findViewById(R.id.ulamprice);
            dishPic = (ImageView) itemView.findViewById(R.id.ulampic);

        }
    }

    public ProgramAdapter (Context context, String[] dishname, String [] prices, int [] images){
        this.context = context;
        this.dishname = dishname;
        this.prices = prices;
        this.images = images;
    }
    @NonNull
    @Override

    public ProgramAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.items,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramAdapter.ViewHolder holder, int position) {
        holder.name.setText(dishname[position]);
        holder.price.setText(prices[position]);
        holder.dishPic.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return dishname.length;
    }
}
