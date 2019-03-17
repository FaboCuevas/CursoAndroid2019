package com.ensitech.adapters;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        Spinner spnPaises;
        Spinner spnPaises2;
        Spinner spnPaises3;
        String[] lista = {
            "España",
            "Brazil",
            "Italia",
            "Paraguay",
            "Indonesia"
        };
        List<Pais> paises = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        spnPaises = findViewById(R.id.spinner);
        spnPaises2 = findViewById(R.id.spinner_2);
        spnPaises3 = findViewById(R.id.spinner_3);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.lista_paises, android.R.layout.simple_list_item_1);
        spnPaises.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, lista);
        spnPaises2.setAdapter(adapter2);
        paises.add(new Pais(1,"CANADA","CA"));
        paises.add(new Pais(2, "CHINA","CH"));
        paises.add(new Pais(3, "JAPON","JP"));
        ArrayAdapter<Pais> adapter3 = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, paises);
        spnPaises3.setAdapter(adapter3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
