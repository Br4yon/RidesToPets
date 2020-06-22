package com.example.ridestopets.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Conexao extends SQLiteOpenHelper {
    private static final String name = "banco6.db";
    private static final int version = 1;

    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        ###   atualizar tabela para Users(tipo : C or H)
        db.execSQL("create table tb_users(id integer primary key autoincrement," +
                "nome varchar(50) , idade varchar(3) , cpf varchar(50) , telefone varchar(50) , email varchar(50) , endereco varchar(50) , date varchar(20) , senha varchar(50))");

//        try {
//
//        }catch(Exception e) {
//            Toast.makeText( , e.getMessage(), Toast.LENGTH_LONG).show();
//        }
//        ###   peso?   ###
        db.execSQL("create table tb_pets(id integer primary key autoincrement," +
                "nome varchar(50), raca varchar(50), especie varchar(50), idade varchar(2), tamanho varchar(10), date varchar(20), idPai integer)");

//        ###   tb_transações   ###
//        db.execSQL("create table tb_transacoes(id integer primary key autoincrement," +
//                "nome varchar(50), raca varchar(50), especie varchar(50), idade varchar(2), tamanho char(1) , peso float(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
