package com.example.myapplication.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.Models.Notes;

@Database(entities = Notes.class, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    public abstract DAO dao();
    private static volatile RoomDB database;//static - говорит о том, что все методы и переменные принадлежат классу и обращаться к ним можно только через класс и в классе
    final private static String DataBase_Name = "NotesApp";

    public synchronized static RoomDB getInstance(Context context){//public - доступен в коде за пределами свего класса; synchronized - ключевое слово синхронизирующее действие потоков;
        if (database == null){ // проверяем есть ли уже созданная БД
            database = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, DataBase_Name) //создаем бд если БД не создана
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
}

/*Приведенный выше пример определяет абстрактный класс, содержащий 1 таблицу Notes.class
    -Создан объект класса DAO, содержащий 5 запросов
    -version = 1, версия БД по умолчанию с еденички
    -если будет создана БД version = 2,3,...  При exportSchema = true автоматически экспаортирует данные из БД version = 1

    -Модификатор доступа volatile сообщает компилятору, что модифицируемая им переменная может быть изменена в других частях программы.
    Одна из таких ситуаций возникает в многопоточных программах, где иногда в двух
    или больше потоках исполнения разделяется общая переменная.
 */

