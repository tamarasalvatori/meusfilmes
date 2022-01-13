package com.example.appmeusfilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appmeusfilmes.Model.Filme;

public class MainActivity extends AppCompatActivity {

    Button btnComprar, btnAlugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnComprar = findViewById(R.id.btnComprar);
        btnAlugar = findViewById(R.id.btnAlugar);

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityComprar(true);
            }
        });
    }

    public void abrirActivityComprar(boolean islifetime) {
     /* Intent intent = new Intent(getApplicationContext(), Comprar.class);
        intent.putExtra("compra", "E o vento levou");
        intent.putExtra("precoCompra", 9.90);
        startActivity(intent);*/

        Intent intent = new Intent(getApplicationContext(), Comprar.class);
        Filme filme = new Filme("E o vento levou", 9.90, true);
        intent.putExtra("compraObj", filme);

        startActivity(intent);
    }
}