package com.example.myapplication.Models;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Notes implements Serializable {

    @PrimaryKey(autoGenerate = true) //автоматически присваивает новое значение для ID
    int ID = 0;

    @ColumnInfo(name = "Title")
    String title = "";

    @ColumnInfo(name = "Notes")
    String note = "";

    @ColumnInfo(name = "Date")
    String date = "";

    @ColumnInfo(name = "Pinned") //позволит закреплять заметки
    Boolean pinned = false;


    // Зона тлена -_-

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }
}
