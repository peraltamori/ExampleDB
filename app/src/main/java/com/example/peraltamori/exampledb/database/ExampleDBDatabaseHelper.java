package com.example.peraltamori.exampledb.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.peraltamori.exampledb.model.Animal;

/**
 * Created by peraltamori on 13/05/17.
 */

public class ExampleDBDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "mydbpractica.db";
    private static final Integer DB_VERSION = 1;

    private final StringBuffer SQL_CREATE_TABLE_ANIMAL = new StringBuffer()
            .append("CREATE TABLE IF NOT EXISTS "+ Animal.TABLE_NAME+"( ")
            .append(Animal.ID_FIELD+" INTEGER PRIMARY KEY AUTOINCREMENT, ")
            .append(Animal.NOMBRE_FIELD+" TEXT, ")
            .append(Animal.TIPO_FIELD+" TEXT )");

    private final StringBuffer SQL_DELETE_TABLE_ANIMAL = new StringBuffer()
            .append("DROP TABLE IF EXISTS " + Animal.TABLE_NAME);

    public ExampleDBDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE_ANIMAL.toString());
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE_ANIMAL.toString());
        onCreate(db);
    }
}
