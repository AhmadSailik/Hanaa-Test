package com.example.hanaarestaurant;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RestuAdapter extends RecyclerView.Adapter<RestuAdapter.RestuViewHolder> {

    List<Restu>allRestu=new ArrayList<>();
    public RestuAdapter(List<Restu> allRestu) {
        this.allRestu = allRestu;
    }

    public static class RestuViewHolder extends RecyclerView.ViewHolder {
        public Restu restu;
        View itemView;
        public RestuViewHolder(@NonNull  View itemView) {
            super(itemView);
            this.itemView=itemView;
            itemView.findViewById(R.id.fragment).setOnClickListener((v)->{
            Intent intent=new Intent(itemView.getContext(),DetailsOfDish.class);

        intent.putExtra("name",restu.name);
        intent.putExtra("price",restu.price);
        intent.putExtra("ingredient",restu.ingredient);
        itemView.getContext().startActivity(intent);
            });
        }

    }

    @NonNull

    @Override
    public RestuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_restu,parent,false);
        RestuViewHolder restuViewHolder=new RestuViewHolder(view);
        return restuViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestuAdapter.RestuViewHolder holder, int position) {
        holder.restu=allRestu.get(position);
        TextView nameOfDish=holder.itemView.findViewById(R.id.viewTitle);
        TextView priceOfDish=holder.itemView.findViewById(R.id.viewPrice);
        nameOfDish.setText(holder.restu.name);
        priceOfDish.setText(holder.restu.price);
    }

    @Override
    public int getItemCount() {
        return allRestu.size();
    }
}
