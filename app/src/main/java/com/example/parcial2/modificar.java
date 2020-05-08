package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class modificar extends AppCompatActivity {
    Spinner estrato, educacion;
    UserController c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        c = new UserController(getApplicationContext());

        Button btnActualizar = (Button)findViewById(R.id.btn_actualizar);
        final Button btnVolver = (Button) findViewById(R.id.btn_cancelar_act);
        final EditText edtNombre = findViewById(R.id.et_nombres);
        final EditText edtId = findViewById(R.id.et_idd);
        final EditText edtSalario = findViewById(R.id.et_salarios);
        estrato = findViewById(R.id.spinner_estratos);
        educacion = findViewById(R.id.spinner_niveles);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean actualizar = c.actualizar(edtNombre.getText().toString(), edtId.getText().toString(),
                        estrato.getSelectedItem().toString(),edtSalario.getText().toString(),educacion.getSelectedItem().toString());
                if (actualizar == true) {
                    Toast.makeText(modificar.this, "Se actualizo correctamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(modificar.this,listado.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(modificar.this, "ha ocurrido un error, intentalo mas tarde", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
