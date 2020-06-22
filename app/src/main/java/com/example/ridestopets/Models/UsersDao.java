package com.example.ridestopets.Models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ridestopets.Controllers.Users;

public class UsersDao {

    private Conexao conexao;
    private SQLiteDatabase banco;
    private String id = "id";
    private String nome = "nome";
    private String cpf = "cpf" ;
    private String email = "email";
    private String endereco = "endereco";
    private String date = "date";
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
        values.put(date, users.getData());
        values.put(senha, users.getSenha());
        return banco.insert(nome_tabela, null, values);
    }

    public Users login(String mail,String pass){
        Users a = new Users();
        String querry = "SELECT " + id + " , " + email + " , " + senha + ", " + nome + " FROM " + nome_tabela + " WHERE " +
                "email='" + mail + "' AND " +
                "senha='" + pass+"'";

        Cursor cursor = banco.rawQuery(querry,null);

        while(cursor.moveToNext()){
            a.setId(cursor.getInt(0));
            a.setEmail(cursor.getString(1));
            a.setSenha(cursor.getString(2));
            a.setNome(cursor.getString(3));
//            a.setCpf(cursor.getString(1));
//            a.setTelefone(cursor.getString(2));
        }

        return a;
    }

    public Users perfil(int id){
        Users a = new Users();
        String querry = "SELECT " + nome + " , " + email + " , " + telefone + " , " + senha + " FROM " + nome_tabela + " WHERE id=" + id;
        Cursor cursor = banco.rawQuery(querry,null);

        while(cursor.moveToNext()){
            a.setNome(cursor.getString(0));
//            a.setCpf(cursor.getString(1));
            a.setEmail(cursor.getString(1));
//            a.setData(cursor.getString(4));
            a.setTelefone(cursor.getString(2));
            a.setSenha(cursor.getString(3));
//            a.setEndereco(cursor.getString(4));
//            a.setIdade(cursor.getInt(7));
        }

        return a;
    }

    public void atualizar(Users user){

        ContentValues cv = new ContentValues();
        cv.put(nome, user.getNome());
        cv.put(telefone, user.getTelefone());
        cv.put(email, user.getEmail());
        cv.put(senha, user.getSenha());
        banco.update(nome_tabela, cv, "id = ?", new String[]{String.valueOf(user.getId())} );

    }

    public void remover(String id){
        banco.delete(nome_tabela, "id = ?", new String[]{id});
    }

}

