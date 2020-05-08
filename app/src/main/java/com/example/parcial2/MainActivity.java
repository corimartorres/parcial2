package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText cedula, nombre, salario;
    Spinner estrato, educacion;
    Button guardar, listar;

    Usuario user;
    UserController uc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.et_nombre);
        cedula = findViewById(R.id.et_cedula);
        salario = findViewById(R.id.et_salario);
        estrato = (Spinner) findViewById(R.id.spinner_estrato);
        educacion = findViewById(R.id.spinner_nivel);
        guardar = findViewById(R.id.btn_registrar);
        listar = findViewById(R.id.btn_listar);

        uc = new UserController(getApplicationContext());

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new Usuario(nombre.getText().toString(), cedula.getText().toString(), estrato.getSelectedItem().toString(),
                        salario.getText().toString(), educacion.getSelectedItem().toString());
                Toast.makeText(getApplicationContext(), user.identificacion,Toast.LENGTH_SHORT).show();
                if(!uc.buscarUser(user.identificacion)) {
                    Log.d("Buscar", "No encontrado");
                    long id = uc.agregarUsuario(user);
                    Toast.makeText(getApplicationContext(), "Usuario registrado", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.d("Buscar", "encontrado");
                    Toast.makeText(getApplicationContext(),"Usuario ya esta registrado",Toast.LENGTH_SHORT).show();
                }
            }
        });
        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),listado.class);
                startActivity(i);
            }
        });
    }
}
