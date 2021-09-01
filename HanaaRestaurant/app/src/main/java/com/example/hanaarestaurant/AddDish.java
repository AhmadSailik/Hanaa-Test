package com.example.hanaarestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class AddDish extends AppCompatActivity  {
DashDatabase dashDatabase;
DashDao dashDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EditText name=findViewById(R.id.editTextName);
        EditText price=findViewById(R.id.editTextPrice);
        EditText ingredients=findViewById(R.id.editTextIngredients);
        Button button=findViewById(R.id.submit);
        button.setOnClickListener((v)->{
            Restu restu=new Restu(name.getText().toString(),price.getText().toString(),ingredients.getText().toString());
            dashDatabase =  Room.databaseBuilder(getApplicationContext(), DashDatabase.class, "dashDatas").allowMainThreadQueries().build();
            dashDao=dashDatabase.dashDao();
            dashDao.insertrAll(restu);
            Intent goToMain=new Intent(AddDish.this,MainActivity.class);
            startActivity(goToMain);
        });
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}