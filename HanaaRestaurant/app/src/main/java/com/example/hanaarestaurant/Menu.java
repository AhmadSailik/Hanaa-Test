package com.example.hanaarestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.List;

public class Menu extends AppCompatActivity implements RestuAdapter.OnClicListeners {
DashDatabase dashDatabase;
RestuAdapter.OnClicListeners onClicListeners;
Restu restu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button button=findViewById(R.id.homePage);
        button.setOnClickListener((v)->{
            Intent intent=new Intent(Menu.this,MainActivity.class);
        });
        dashDatabase =  Room.databaseBuilder(getApplicationContext(), DashDatabase.class, "dashDatas").allowMainThreadQueries().build();
        List<Restu> dashList=dashDatabase.dashDao().getAll();
        RecyclerView allTaskRecyclerView=findViewById(R.id.recyclerView);
        allTaskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        allTaskRecyclerView.setAdapter(new RestuAdapter(dashList, onClicListeners));
    }

    @Override
    public void onClicks(int position) {

        Intent intent=new Intent(Menu.this,DetailsOfDish.class);
//        Intent intent=new Intent(itemView.getContext(),DetailsOfDish.class);
        intent.putExtra("name",restu.name);
        intent.putExtra("price",restu.price);
        intent.putExtra("ingredient",restu.ingredient);
        startActivity(intent);
    }
}