package com.example.parcial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

public class listado extends AppCompatActivity {

    UserController c;
    ListView listado;
    UsuarioCursorAdapter uca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listado = findViewById(R.id.listado);
        c = new UserController(getApplicationContext());

        Cursor cur = c.allUsers();

        UsuarioCursorAdapter uca = new UsuarioCursorAdapter(this,cur,0);
        listado.setAdapter(uca);
        uca.notifyDataSetChanged();

        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(listado.this, MainActivity.class);
            startActivity(intent);
        }

        int id = item.getItemId();
        if(id == R.id.btn_actualizar){
            Intent intent = new Intent(listado.this, modificar.class);
            startActivity(intent);
        }
        if(id == R.id.btn_eliminar){
            Intent intent = new Intent(listado.this, eliminar.class);
            startActivity(intent);
        }
        if (id == R.id.btn_buscar){
            Intent intent = new Intent(listado.this, buscar.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
