package com.example.hanaarestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailsOfDish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_dish);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=getIntent();
        String name=intent.getExtras().getString("name","name");
        String price=intent.getExtras().getString("price","price");
        String ingredient=intent.getExtras().getString("ingredient","ingredient");

        TextView textView=findViewById(R.id.mainTitle);
        TextView textView1=findViewById(R.id.subTitle);
        TextView textView2=findViewById(R.id.subPrice);
        TextView textView3=findViewById(R.id.subIngrident);
        textView.setText(name);
        textView1.setText(name);
        textView2.setText(price);
        textView3.setText(ingredient);

    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}