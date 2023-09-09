package com.example.myapplication.DataBase;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Models.Checkboxes;

import java.util.List;


@Dao
public interface CheckboxDAO {
    @Insert(onConflict = REPLACE)
    void insert(Checkboxes checkbox);

    @Query("SELECT * FROM notes ORDER BY id DESC")
    List<Checkboxes> getAll();

    @Query("UPDATE checkboxes SET Text =:Text WHERE ID =:ID")
    void update(int ID, String Text);

    @Delete
    void delete(Checkboxes checkbox);
}
