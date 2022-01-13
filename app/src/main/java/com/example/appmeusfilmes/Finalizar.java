package com.example.appmeusfilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Finalizar extends AppCompatActivity {

    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar);

        btnShare = findViewById(R.id.btnShare);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartilharCompra();
            }
        });
    }

    public void voltarInicio(View view){
        finish();
    }

    void compartilharCompra(){
        Intent share = new Intent();
        //Acao a ser realizada
        share.setAction(Intent.ACTION_SEND);
        //Extras
        share.putExtra(Intent.EXTRA_TEXT, "Venha assistir o filme E o vento levou comigo!");
        //Definir o tipo do dado que sera enviado (Mime Type)
        share.setType("text/plain");

        //Criar um seletor (para Intentes implicitas)
        Intent seletor = Intent.createChooser(share, "Selecione o app para compartilhar a mensagem");

        if (seletor.resolveActivity(getPackageManager()) != null) {
            startActivity(seletor);
        }


        /*  //Definir quem pode comprartilhar a informacao - Intent Explicita
        share.setPackage("com.whatsapp");
        //Inicializar intent
        try {
            startActivity(share);
        } catch (Exception e) {
            e.getMessage();
        }*/
    }
}