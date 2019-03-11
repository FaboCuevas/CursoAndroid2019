package com.ensitech.navegandoentrevistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TerceroActivity extends AppCompatActivity {

    Button btnIrCuarto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercero);
        btnIrCuarto = findViewById(R.id.ir_a_cuarto);
        btnIrCuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Actividad actual      //Actividad destino
                Intent intento = new Intent(TerceroActivity.this, CuartoActivity.class);
                startActivity(intento);
            }
        });
    }
}
