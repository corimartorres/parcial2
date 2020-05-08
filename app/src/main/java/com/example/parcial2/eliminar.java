package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class eliminar extends AppCompatActivity {

    UserController c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        c = new UserController(getApplicationContext());

        final EditText edtIdEliminar = findViewById(R.id.et_cedula_eliminar);
        Button btnEliminar = (Button) findViewById(R.id.btn_eliminar);
        final Button btnV = (Button) findViewById(R.id.btn_cancelar_eliminar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer eliminar = c.eliminar(edtIdEliminar.getText().toString());
                if (eliminar >0 ) {
                    Toast.makeText(eliminar.this, "Se elimino correctamente", Toast.LENGTH_SHORT);
                    Intent intent = new Intent(eliminar.this, listado.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(eliminar.this, "El campo Cédula es requerido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(eliminar.this, listado.class);
                startActivity(intent);
            }
        });
    }
}
