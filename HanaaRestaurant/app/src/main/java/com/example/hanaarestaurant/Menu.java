package com.example.hanaarestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;

import java.util.List;

public class Menu extends AppCompatActivity  {
DashDatabase dashDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button button=findViewById(R.id.homePage);
        button.setOnClickListener((v)->{
            Intent intent=new Intent(Menu.this,MainActivity.class);
            startActivity(intent);
        });
        dashDatabase =  Room.databaseBuilder(getApplicationContext(), DashDatabase.class, "dashDatas").allowMainThreadQueries().build();
        List<Restu> dashList=dashDatabase.dashDao().getAll();
        RecyclerView allTaskRecyclerView=findViewById(R.id.recyclerView);
        allTaskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        allTaskRecyclerView.setAdapter(new RestuAdapter(dashList));
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

}