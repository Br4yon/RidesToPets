package com.example.ridestopets.Models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ridestopets.Controllers.Users;

public class UsersDao {

    private Conexao conexao;
    private SQLiteDatabase banco;
    private String nome = "nome";
    private String cpf = "cpf" ;
    private String email = "email";
    private String endereco = "endereco";
    private String data = "data";
    private String telefone = "telefone";
    private String senha = "senha";
    private String idade = "idade";
    private String nome_tabela = "tb_users";

    public UsersDao() {
    }

    public void setConexao(Conexao con){
        conexao = con;
        banco   = conexao.getWritableDatabase();
    }

    public long inserir(Users users){
        ContentValues values = new ContentValues();
        values.put(nome, users.getNome());
        values.put(idade, users.getIdade());
        values.put(cpf, users.getCpf());
        values.put(telefone, users.getTelefone());
        values.put(email, users.getEmail());
        values.put(endereco, users.getEndereco());
//        values.put(data, users.getData());
        values.put(senha, users.getSenha());
        return banco.insert(nome_tabela, null, values);
    }

    public Users login(String email,String senha){
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

    public Users perfil(int id){
        Users a = new Users();
        String querry = "SELECT " + nome + " , " + email + " , " + telefone + " FROM " + nome_tabela + " WHERE id=" + id;
        Cursor cursor = banco.rawQuery(querry,null);

        while(cursor.moveToNext()){
            a.setNome(cursor.getString(0));
//            a.setCpf(cursor.getString(1));
            a.setEmail(cursor.getString(1));
//            a.setEndereco(cursor.getString(3));
//            a.setData(cursor.getString(4));
            a.setTelefone(cursor.getString(2));
//            a.setSenha(cursor.getString(6));
//            a.setIdade(cursor.getInt(7));
        }

        return a;
    }

}

