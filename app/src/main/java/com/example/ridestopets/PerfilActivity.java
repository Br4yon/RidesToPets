package com.example.ridestopets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.ridestopets.Controllers.Users;
import com.example.ridestopets.Models.Conexao;
import com.example.ridestopets.Models.UsersDao;

public class PerfilActivity extends AppCompatActivity {

    private EditText editName, editTelefone, editEmail, editSenha;
    private UsersDao dao;
    private Conexao conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        editName = (EditText) findViewById(R.id.editName);
        editTelefone = (EditText) findViewById(R.id.editIdade);
        editEmail = (EditText) findViewById(R.id.editTamanho);
        editSenha = (EditText) findViewById(R.id.editData);

        conexao = new Conexao(this);
        dao = new UsersDao();
        dao.setConexao(conexao);

//        a contagem do proximo numero !!!
        int id = 14;
        perfil(id);

    }

    public void perfil(int id){
        Users userperfil = dao.perfil(id);
        editName.setText(userperfil.getNome());
        editEmail.setText(userperfil.getEmail());
        editTelefone.setText(userperfil.getTelefone());
//        a.setNome(cursor.getString(0));
//        a.setCpf(cursor.getString(1));
//        a.setEmail(cursor.getString(2));
//        a.setEndereco(cursor.getString(3));
//        a.setData(cursor.getString(4));
//        a.setTelefone(cursor.getString(5));
//        a.setSenha(cursor.getString(6));
//        a.setIdade(cursor.getInt(7));
    }
}
