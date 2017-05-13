package com.example.peraltamori.exampledb.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.peraltamori.exampledb.R;
import com.example.peraltamori.exampledb.database.DAO.AnimalDao;
import com.example.peraltamori.exampledb.model.Animal;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnimalDao animalDao = new AnimalDao(this);

        Animal animal1 = new Animal();
        animal1.setNombre("Leon");
        animal1.setTipo("Carnivoro");

        Animal animal2 = new Animal();
        animal2.setNombre("Zebra");
        animal2.setTipo("Herbivoro");

        long estado = animalDao.insertarAnimal(animal1);
        long estado2 = animalDao.insertarAnimal(animal2);

        Log.d(TAG, "resultados del animal 1: "+estado);
        Log.d(TAG, "resultados del animal 2: "+estado2);
    }
}
