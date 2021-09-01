package com.example.hanaarestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addDish=findViewById(R.id.addDIsh);
        Button menu=findViewById(R.id.menu);
        addDish.setOnClickListener((v)->{
            Intent intent=new Intent(MainActivity.this,AddDish.class);
            startActivity(intent);
        });
        menu.setOnClickListener((v)->{
            Intent intent=new Intent(MainActivity.this,Menu.class);
            startActivity(intent);
        });
    }
}