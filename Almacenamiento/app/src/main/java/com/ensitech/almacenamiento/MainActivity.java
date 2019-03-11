package com.ensitech.almacenamiento;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnGuardar;
    Button btnMostrar;
    TextView lblMostrar;
    EditText txtNombre;
    EditText txtApellido;
    EditText txtEdad;
    EditText txtCorreo;
    RadioGroup rdgGenero;

    Persona persona;
    PersonaBDHelper personaBDHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persona = new Persona();
        personaBDHelper = new PersonaBDHelper(this);
        btnMostrar = findViewById(R.id.boton_mostrar);
        lblMostrar = findViewById(R.id.lista_personas);
        btnGuardar = findViewById(R.id.boton_guardar);
        txtNombre = findViewById(R.id.nombre);
        txtApellido = findViewById(R.id.apellido);
        txtEdad = findViewById(R.id.edad);
        txtCorreo = findViewById(R.id.correo);
        rdgGenero = findViewById(R.id.genero);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNombre.getText().toString().equals("")){
                    txtNombre.setError("Campo requerido");
                    return;
                }
                if (txtApellido.getText().toString().equals("")){
                    txtApellido.setError("Campo requerido");
                    return;
                }
                if (txtEdad.getText().toString().equals("")){
                    txtEdad.setError("Campo requerido");
                    return;
                }
                if (txtCorreo.getText().toString().equals("")){
                    txtCorreo.setError("Campo requerido");
                    return;
                }
                String nombre = txtNombre.getText().toString();
                String apellido = txtApellido.getText().toString();
                int edad = Integer.valueOf(txtEdad.getText().toString());
                String correo = txtCorreo.getText().toString();
                //Obtener género seleccionado
                int idSeleccionado = rdgGenero.getCheckedRadioButtonId();
                if(idSeleccionado != R.id.genero_hombre && idSeleccionado != R.id.genero_mujer){
                    Toast.makeText(MainActivity.this,"Debes seleccionar tu genero", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton seleccionado = rdgGenero.findViewById(idSeleccionado);
                String genero = seleccionado.getText().toString();

                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEdad(edad);
                persona.setCorreo(correo);
                persona.setGenero(genero);

                personaBDHelper.insertarPersona(persona);
            }
        });
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblMostrar.setText("");
                List<Persona> personas = personaBDHelper.obtenerPersonas();
                for (Persona persona: personas) {
                    String textoActual = lblMostrar.getText().toString();
                    textoActual = textoActual + "\n" + persona.getNombre();
                    lblMostrar.setText(textoActual);
                }
            }
        });
    }
}
