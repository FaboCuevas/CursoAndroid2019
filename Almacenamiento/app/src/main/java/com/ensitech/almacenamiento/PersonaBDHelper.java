package com.ensitech.almacenamiento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PersonaBDHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String BD_NAME = "Personas.db";

    public PersonaBDHelper(@Nullable Context context) {
        super(context, BD_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            "CREATE TABLE " + PersonaContract.PersonaEntry.TABLE_NAME + " ("
                + PersonaContract.PersonaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PersonaContract.PersonaEntry.NOMBRE + " TEXT NOT NULL,"
                + PersonaContract.PersonaEntry.APELLIDO + " TEXT NOT NULL,"
                + PersonaContract.PersonaEntry.EDAD + " INTEGER NOT NULL,"
                + PersonaContract.PersonaEntry.GENERO + " TEXT NOT NULL,"
                + PersonaContract.PersonaEntry.FOTOGRAFIA + " TEXT NOT NULL,"
                + PersonaContract.PersonaEntry.CORREO + " TEXT NOT NULL"
            +")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void insertarPersona(Persona persona){
        SQLiteDatabase db = getReadableDatabase();
        //Contenedor de valores
        ContentValues contenedor = new ContentValues();
        contenedor.put(PersonaContract.PersonaEntry.NOMBRE, persona.getNombre());
        contenedor.put(PersonaContract.PersonaEntry.APELLIDO, persona.getApellido());
        contenedor.put(PersonaContract.PersonaEntry.EDAD, persona.getEdad());
        contenedor.put(PersonaContract.PersonaEntry.GENERO, persona.getGenero());
        contenedor.put(PersonaContract.PersonaEntry.FOTOGRAFIA, "");
        contenedor.put(PersonaContract.PersonaEntry.CORREO, persona.getCorreo());
        //Inserta en BD
        db.insert(PersonaContract.PersonaEntry.TABLE_NAME, null, contenedor);
    }

    public List<Persona> obtenerPersonas(){
        List<Persona> personas = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + PersonaContract.PersonaEntry.TABLE_NAME, null);
        if(cursor != null){
            cursor.moveToFirst();
            while (cursor.moveToNext()){
                Persona persona = new Persona();
                persona.setNombre(
                        cursor.getString(
                                cursor.getColumnIndex(
                                        PersonaContract.PersonaEntry.NOMBRE)));
                personas.add(persona);
            }
        }
        return personas;
    }
}
