package com.example.hanaarestaurant;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


    @Entity
    public class Restu {
        @PrimaryKey(autoGenerate = true)
        public int DishId;
        @ColumnInfo(name = "dish_name")
        public String name;
        @ColumnInfo(name = "dish_price")
        public String price;
        @ColumnInfo(name = "dish_ingredient")
        public String ingredient;

        public Restu(String name, String price, String ingredient){
            this.name=name;
            this.price= price;
            this.ingredient=ingredient;
        }
    }

