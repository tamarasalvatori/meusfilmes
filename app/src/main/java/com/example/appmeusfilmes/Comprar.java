package com.example.appmeusfilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmeusfilmes.Model.Filme;

import org.w3c.dom.Text;

public class Comprar extends AppCompatActivity {

    TextView txtTitulo, txtPreco, txtValidade;
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtPreco = findViewById(R.id.txtPreco);
        txtValidade = findViewById(R.id.txtValidade);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        Bundle dados = getIntent().getExtras();

        Filme movie = (Filme) dados.getSerializable("compraObj");

        txtTitulo.setText(movie.getTitulo());
        txtPreco.setText(String.format("$: %.2f", movie.getPreco()));
        txtValidade.setText(movie.getValidade());

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(getApplicationContext(), Finalizar.class);
                    startActivity(i);
                }catch (ActivityNotFoundException activityNotFound){
                    Toast.makeText(getApplicationContext(),"Erro ao realizar a compra. Pedimos desculpas pelo transtorno.", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Erro ao processar a compra. Tente novamente mais tarde.", Toast.LENGTH_SHORT).show();
                } finally {
                    finish();
                }
            }
        });
    }

    public void voltar(View v){
        finish();
    }
}