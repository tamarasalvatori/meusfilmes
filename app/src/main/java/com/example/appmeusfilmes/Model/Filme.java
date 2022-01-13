package com.example.appmeusfilmes.Model;

import java.io.Serializable;

public class Filme implements Serializable {
    String titulo;
    double preco;
    boolean lifeTime;
    String validade;

    public Filme(String titulo, double preco, boolean lifeTime) {
        this.titulo = titulo;
        this.preco = preco;
        this.lifeTime = lifeTime;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(boolean lifeTime) {
        this.lifeTime = lifeTime;
    }

    public String getValidade() {
        if(lifeTime){
            return "Você pode ver este filme sempre que quiser";
        }else {
            return "Você tem 7 dias para ver este filme";
        }
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}
