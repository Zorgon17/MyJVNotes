package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Checkboxes;
import com.example.myapplication.Models.CheckboxesClickListener;
import com.example.myapplication.R;

import java.util.List;

public class CheckboxListAdapter extends RecyclerView.Adapter<CheckBoxViewHolder> {

    Context context;
    List<Checkboxes> list;
    CheckboxesClickListener listener;

    public CheckboxListAdapter(Context context, List<Checkboxes> list, CheckboxesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CheckBoxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CheckBoxViewHolder(LayoutInflater.from(context).inflate(R.layout.checkbox_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CheckBoxViewHolder holder, int position) {

        holder.textView_checkbox_text.setText(list.get(position).getText());
        holder.textView_checkbox_text.setSelected(true);

        holder.checkboxes_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}


class CheckBoxViewHolder extends RecyclerView.ViewHolder {

    CardView checkboxes_container;
    TextView textView_checkbox_text;


    public CheckBoxViewHolder(@NonNull View itemView) {
        super(itemView);

        checkboxes_container = itemView.findViewById(R.id.checkboxes_container);
        textView_checkbox_text = itemView.findViewById(R.id.textView_checkbox_text);
    }
}