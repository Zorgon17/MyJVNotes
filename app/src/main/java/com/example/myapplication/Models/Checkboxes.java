package com.example.myapplication.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "checkboxes")
public class Checkboxes implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int ID = 0;

    @ColumnInfo(name = "Text")
    String text = "";

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

