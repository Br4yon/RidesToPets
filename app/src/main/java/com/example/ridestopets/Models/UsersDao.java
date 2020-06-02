package com.example.ridestopets.Models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ridestopets.Controllers.Users;

public class UsersDao {

//        private int id, idade;
//    private String nome,cpf,email,endereco,telefone,senha , data;

    private Conexao conexao;
    private SQLiteDatabase banco;
    private String nome = "nome", cpf = "cpf" , email = "email" , endereco = "endereco";
    private String  data = "data", telefone = "telefone", senha = "senha";
    private String idade = "idade";
    private String nome_tabela = "tb_users";


    public void setConexao(Conexao con){
        conexao = con;
        banco   = conexao.getWritableDatabase();

    }

    public long inserir(Users users){
        ContentValues values = new ContentValues();
        values.put(nome, users.getNome());
        values.put(cpf, users.getCpf());
        values.put(email, users.getEmail());
        values.put(endereco, users.getEndereco());
        values.put(data, users.getData());
        values.put(telefone, users.getTelefone());
        values.put(senha, users.getSenha());
        values.put(idade, users.getIdade());
        return banco.insert(nome_tabela, null, values);
    }


    public Users consultar(int id){
        Users a = new Users();
        String querry = "SELECT " + nome + ", " + cpf + " , " + email + " , " + endereco + "," + data +
                ", " + telefone + " , " + senha + " , " + idade + " FROM " + nome_tabela + " WHERE " +
                "email=" + email + " AND " +
                "senha=" + senha;

        Cursor cursor = banco.rawQuery(querry,null);

        while(cursor.moveToNext()){
            a.setNome(cursor.getString(0));
            a.setCpf(cursor.getString(1));
            a.setTelefone(cursor.getString(2));
        }

        return a;
    }
}

