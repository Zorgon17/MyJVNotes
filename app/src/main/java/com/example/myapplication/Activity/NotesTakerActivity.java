package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.Models.Notes;
import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {
    EditText editText_title;
    EditText editText_notes;
    ImageView imageView_save;
    Notes notes;
    boolean isOldNote = false;

    @Override
    public void onBackPressed() {
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);

        editText_title = findViewById(R.id.editText_title);
        editText_notes = findViewById(R.id.editText_notes);
        imageView_save = findViewById(R.id.imageView_save);

        notes = new Notes();
        try {
            notes = (Notes) getIntent().getSerializableExtra("old_notes"); //(...) - каст
            editText_title.setText(notes.getTitle());
            editText_notes.setText(notes.getNote());
            isOldNote = true;// проверяем заметку на старость
        } catch (Exception e) {
            e.printStackTrace();
        }


        imageView_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = editText_title.getText().toString(); //получаем то, что в наиименовании заметки
                String description = editText_notes.getText().toString(); //получаем то, что в теле заметки

                if (description.isEmpty()) {
                    Toast.makeText(NotesTakerActivity.this, "please enter text", Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
                Date date = new Date();

                if (!isOldNote) {
                    notes = new Notes();
                }
                notes.setTitle(title);
                notes.setNote(description);
                notes.setDate(formater.format(date));

                Intent intent = new Intent();
                intent.putExtra("note", notes);//сохраняем данные при закрытии активити
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}