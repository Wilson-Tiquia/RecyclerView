package com.example.recyclerviewtut;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DishInfoAdapter extends RecyclerView.Adapter<DishInfoAdapter.ViewHolder> {
    Context context;
    ArrayList<DishInfo> dishInfoArrayList;
    RecyclerView recyclerView;
    private RecyclerViewClickListener listener;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView dishname;
        ImageView dishpic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dishname = (TextView) itemView.findViewById(R.id.ulamname);
            dishpic = (ImageView) itemView.findViewById(R.id.ulampic);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());

        }
    }
    public DishInfoAdapter (Context context, ArrayList<DishInfo> dishInfos, RecyclerView rv, RecyclerViewClickListener listener){
        this.context = context;
        this.dishInfoArrayList = dishInfos;
        this.recyclerView = rv;
        this.listener = listener;

    }

    @NonNull
    @Override
    public DishInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.items, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DishInfoAdapter.ViewHolder holder, int position) {
        DishInfo dishInfo = dishInfoArrayList.get(position);
        holder.dishname.setText(""+dishInfo.getDishName());
        holder.dishpic.setImageBitmap(dishInfo.getDishImage());


    }

    @Override
    public int getItemCount() {
        return dishInfoArrayList.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }

}
