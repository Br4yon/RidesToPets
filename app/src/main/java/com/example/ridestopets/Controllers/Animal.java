package com.example.ridestopets.Controllers;

import java.io.Serializable;

public class Animal implements Serializable {

    private int id;
    private int idPai;
    private String nome,especie,raca, idade, tamanho, data ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPai() {
        return idPai;
    }

    public void setIdPai(int idPai) {
        this.idPai = idPai;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}