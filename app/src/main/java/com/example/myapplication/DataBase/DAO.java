package com.example.myapplication.DataBase;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Models.Checkboxes;
import com.example.myapplication.Models.Notes;

import java.util.List;

@Dao
public interface DAO {

//для заметок
    @Insert(onConflict = REPLACE)
    void insert(Notes notes);

    @Query("SELECT * FROM notes ORDER BY id DESC")
    List<Notes> getAll();

    @Query("UPDATE notes SET Title =:Title, Notes=:Notes WHERE ID =:ID")
        // поможет изменять Title и Notes
    void update(int ID, String Title, String Notes);

    @Delete
    void delete(Notes notes);

    @Query("UPDATE notes SET Pinned =:pin WHERE ID =:id")
    void pin(int id, boolean pin);


    //для Задач (чекбоксов)
    @Insert(onConflict = REPLACE)
    void insertCheckbox(Checkboxes checkboxes);

    @Query("SELECT * FROM checkboxes ORDER BY ID DESC")
    List<Checkboxes> getAllCheckboxes();

    @Query("UPDATE checkboxes SET Text =:Text WHERE ID =:ID")
    void updateCheckbox(int ID, String Text);

    @Delete
    void deleteCheckbox(Checkboxes checkboxes);
}

/* Использование классов Dao позволит вам абстрагировать взаимодействие с базой данных на более логичном уровне,
который будет намного проще имитировать в тестах (по сравнению с выполнением прямых SQL-запросов).
Он также автоматически выполняет преобразование из Cursor в классы данных вашего приложения,
поэтому вам не нужно иметь дело с API-интерфейсами базы данных более низкого уровня для большей части вашего доступа к данным.
 */