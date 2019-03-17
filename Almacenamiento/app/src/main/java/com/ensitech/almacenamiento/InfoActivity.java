package com.ensitech.almacenamiento;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Comparator;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    ListView listView;
    PersonaBDHelper personaBDHelper;
    List<Persona> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        listView = findViewById(R.id.list_view);
        personaBDHelper = new PersonaBDHelper(this);
        personas = personaBDHelper.obtenerPersonas();
        personas.sort(new Comparator<Persona>() {
            @Override
            public int compare(Persona persona, Persona t1) {
                return persona.getEdad() - t1.getEdad();
            }
        });
        ArrayAdapter<Persona> adapter = new ArrayAdapter<Persona>(this,
                0, personas){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.persona_list_item, null, false);
                }
                ImageView icono = convertView.findViewById(R.id.icono);
                TextView nombre = convertView.findViewById(R.id.nombre);
                TextView edad = convertView.findViewById(R.id.edad);
                Persona persona = personas.get(position);
                if(persona.getGenero().equals("Mujer")){
                    icono.setImageResource(R.drawable.ic_women_sign);
                }else{
                    icono.setImageResource(R.drawable.ic_male_sign);
                }
                nombre.setText(persona.toString());
                edad.setText("" + persona.getEdad());
                return convertView;
            }
        };
        listView.setAdapter(adapter);
    }
}
