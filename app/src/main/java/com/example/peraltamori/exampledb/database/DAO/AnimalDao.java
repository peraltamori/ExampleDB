package com.example.peraltamori.exampledb.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.peraltamori.exampledb.database.ExampleDBDatabaseHelper;
import com.example.peraltamori.exampledb.model.Animal;

/**
 * Created by peraltamori on 13/05/17.
 */

public class AnimalDao {

    private static final String TAG = "AnimalDao";
    private SQLiteDatabase mSQLiteDatabase;

    public AnimalDao(Context context) {
        mSQLiteDatabase = new ExampleDBDatabaseHelper(context).getWritableDatabase();
    }

    public long insertarAnimal (Animal animal){
        return mSQLiteDatabase.insert(Animal.TABLE_NAME,null,
                convertAnimalToContentValues(animal));
    }

    private ContentValues convertAnimalToContentValues (Animal animal){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Animal.NOMBRE_FIELD, animal.getNombre());
        contentValues.put(Animal.TIPO_FIELD, animal.getTipo());
        return contentValues;
    }

}
