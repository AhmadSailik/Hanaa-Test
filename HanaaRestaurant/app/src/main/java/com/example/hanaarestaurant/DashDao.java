package com.example.hanaarestaurant;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface DashDao {
    @Query("SELECT * FROM restu")
    List<Restu> getAll();
    @Insert
    void insertrAll(Restu...restus);
    @Delete
    void delete(Restu restu);
}
