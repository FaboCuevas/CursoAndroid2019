package com.ensitech.almacenamiento;

import android.provider.BaseColumns;

public class PersonaContract {

    public static abstract class PersonaEntry implements BaseColumns{
        public static final String TABLE_NAME = "person";

        public static final String NOMBRE = "nombre";
        public static final String APELLIDO = "apellido";
        public static final String EDAD = "edad";
        public static final String GENERO = "genero";
        public static final String FOTOGRAFIA = "fotografia";
        public static final String CORREO = "correo";
    }
}
