package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class buscar extends AppCompatActivity {

    Button salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);


        salir = (Button) findViewById(R.id.btn_cancelar_buscar);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(buscar.this, listado.class);
                startActivity(intent);
            }
        });
    }
}
