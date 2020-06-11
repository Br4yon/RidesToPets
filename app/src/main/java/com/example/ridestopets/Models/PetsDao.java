package com.example.ridestopets.Models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ridestopets.Controllers.Animal;

public class PetsDao {

    private Conexao conexao;
    private SQLiteDatabase banco;
    private String nome = "nome";
    private String especie = "especie";
    private String raca = "raca";
    private String idade = "idade";
    private String tamanho = "tamanho";
    private String data = "data";
    private String nome_tabela = "tb_users";

    public PetsDao() {
    }

    public void setConexao(Conexao con){
        conexao = con;
        banco   = conexao.getWritableDatabase();
    }

    public long inserir(Animal pets){
        ContentValues values = new ContentValues();
        values.put(especie, pets.getEspecie());
        values.put(nome, pets.getNome());
        values.put(idade, pets.getIdade());
        values.put(raca, pets.getRaca());
        values.put(tamanho, pets.getTamanho());
        values.put(data, pets.getData());

        return banco.insert(nome_tabela, null, values);
    }

    public Animal perfil(int id){
        Animal a = new Animal();
        String querry = "SELECT " + especie + " , " + nome + " , " + idade + " , " + raca + ", "+ tamanho +", "+ data +" FROM " + nome_tabela + " WHERE id=" + id;
        Cursor cursor = banco.rawQuery(querry,null);

        while(cursor.moveToNext()){
            a.setNome(cursor.getString(0));
            a.setIdade(cursor.getString(1));
            a.setTamanho(cursor.getString(2));
            a.setData(cursor.getString(3));

        }

        return a;
    }

}

