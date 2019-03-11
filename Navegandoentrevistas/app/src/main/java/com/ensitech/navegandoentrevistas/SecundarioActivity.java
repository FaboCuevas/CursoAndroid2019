package com.ensitech.navegandoentrevistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecundarioActivity extends AppCompatActivity {

    Button btnIrCuarto;
    TextView textTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundario);
        btnIrCuarto = findViewById(R.id.ir_a_cuarto);
        textTitulo = findViewById(R.id.titulo);
        btnIrCuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Actividad actual      //Actividad destino
                Intent intento = new Intent(SecundarioActivity.this, CuartoActivity.class);
                startActivity(intento);
            }
        });
        if(getIntent().getExtras() != null){
            String valor = getIntent().getExtras().get("padre").toString();
            textTitulo.setText(valor);
        }
    }
}
