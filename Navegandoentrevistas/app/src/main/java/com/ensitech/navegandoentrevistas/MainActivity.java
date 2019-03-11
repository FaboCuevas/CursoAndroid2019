package com.ensitech.navegandoentrevistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnIrSecundario;
    Button btnIrTercero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIrSecundario = findViewById(R.id.ir_secundario);
        btnIrSecundario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                                    //Actividad actual      //Actividad destino
                Intent intento = new Intent(MainActivity.this, SecundarioActivity.class);
                intento.putExtra("padre", "MainActivity");
                startActivity(intento);
            }
        });
        btnIrTercero = findViewById(R.id.ir_a_tercero);
        btnIrTercero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Actividad actual      //Actividad destino
                Intent intento = new Intent(MainActivity.this, TerceroActivity.class);
                startActivity(intento);
            }
        });
    }
}

/*
//EN el padre
Intent intento = new Intent(MainActivity.this, SecundarioActivity.class);
intento.putExtra("padre", "MainActivity");
startActivity(intento);

//En el hijo
if(getIntent().getExtras() != null){
    String valor = getIntent().getExtras().get("padre").toString();
    textTitulo.setText(valor);
}*/

