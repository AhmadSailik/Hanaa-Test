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
    OnClicListeners onClicListeners;
    public RestuAdapter(List<Restu> allRestu,OnClicListeners onClicListeners) {
        this.allRestu = allRestu;
        this.onClicListeners=onClicListeners;
    }

    public static class RestuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public Restu restu;
        View itemView;
        OnClicListeners onClicListeners;
        public RestuViewHolder(@NonNull  View itemView,OnClicListeners onClicListeners) {
            super(itemView);
            this.itemView=itemView;
            this.onClicListeners=onClicListeners;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClicListeners.onClicks(getAdapterPosition());


        }
    }
    public interface OnClicListeners{
        void onClicks(int position);
    }

    @NonNull

    @Override
    public RestuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_restu,parent,false);
        RestuViewHolder restuViewHolder=new RestuViewHolder(view,onClicListeners);
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
