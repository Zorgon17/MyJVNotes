package com.example.myapplication.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class CheckboxListAdapter {
}


class CheckBoxViewHolder extends RecyclerView.ViewHolder {

    //объявляем объекты которые мы добавили в файл
    CardView notes_container;
    TextView textView_title;
    TextView textView_notes;
    TextView textView_date;
    ImageView imageView_pin;


    public CheckBoxViewHolder (@NonNull View itemView) { //связываем объявленные объекты с теми что есть в notes_list.xml
        super(itemView);

    }
}