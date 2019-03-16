package com.ensitech.almacenamiento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView txtNombre;
    TextView txtApellido;
    TextView txtCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        txtNombre = findViewById(R.id.nombre);
        txtApellido = findViewById(R.id.apellido);
        txtCorreo = findViewById(R.id.correo);

        /*
        String nombre = SharedPreferenceHelper.sharedPreferences.getString("NOMBRE_PERSONA", "NA");
        String apellido = SharedPreferenceHelper.sharedPreferences.getString("APELLIDO_PERSONA", "");
        String correo = SharedPreferenceHelper.sharedPreferences.getString("CORREO_PERSONA", "");
        */
        String nombre = PersonaInstance.getInstance().getPersona().getNombre();
        String apellido = PersonaInstance.getInstance().getPersona().getApellido();
        String correo = PersonaInstance.getInstance().getPersona().getCorreo();

        txtNombre.setText(nombre);
        txtApellido.setText(apellido);
        txtCorreo.setText(correo);
    }
}
