package com.example.hanaarestaurant;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Restu.class},version = 1)
public abstract class DashDatabase extends RoomDatabase {
    public abstract DashDao dashDao();
}
