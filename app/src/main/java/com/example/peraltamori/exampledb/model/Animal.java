package com.example.peraltamori.exampledb.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by peraltamori on 13/05/17.
 */

public class Animal implements Parcelable {

    public static final String TABLE_NAME = "Animal";
    public static final String ID_FIELD = "id";
    public static final String NOMBRE_FIELD = "nombre";
    public static final String TIPO_FIELD = "tipo";

    private Integer id;
    private String nombre;
    private String tipo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.nombre);
        dest.writeString(this.tipo);
    }

    public Animal() {
    }

    protected Animal(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.nombre = in.readString();
        this.tipo = in.readString();
    }

    public static final Parcelable.Creator<Animal> CREATOR = new Parcelable.Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel source) {
            return new Animal(source);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };
}
