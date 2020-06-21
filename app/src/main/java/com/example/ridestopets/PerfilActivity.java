package com.example.ridestopets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ridestopets.Controllers.Users;
import com.example.ridestopets.Models.Conexao;
import com.example.ridestopets.Models.UsersDao;

public class PerfilActivity extends AppCompatActivity {

    private EditText editName, editTelefone, editEmail, editSenha;
    private Button btnAtualizar, btnExcluir;
    private UsersDao dao;
    private Conexao conexao;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        editName = (EditText) findViewById(R.id.editName);
        editTelefone = (EditText) findViewById(R.id.editTelefone);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editSenha = (EditText) findViewById(R.id.editSenha);

        btnAtualizar = (Button) findViewById(R.id.btnAtualizar);
        btnExcluir = (Button) findViewById(R.id.btnExcluir);

        conexao = new Conexao(this);
        dao = new UsersDao();
        dao.setConexao(conexao);

        Intent it = getIntent();
        id = it.getIntExtra("id_user" , 0);
        perfil(id);

        Toast.makeText(PerfilActivity.this, "ID : " + id, Toast.LENGTH_LONG).show();

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Atualizar();
            }
        });

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Excluir();
            }
        });

    }

    public void perfil(int id){
        Users userperfil = dao.perfil(id);
        editName.setText(userperfil.getNome());
        editTelefone.setText(userperfil.getTelefone());
        editEmail.setText(userperfil.getEmail());
        editSenha.setText(userperfil.getSenha());
//        a.setNome(cursor.getString(0));
//        a.setCpf(cursor.getString(1));
//        a.setEmail(cursor.getString(2));
//        a.setEndereco(cursor.getString(3));
//        a.setData(cursor.getString(4));
//        a.setTelefone(cursor.getString(5));
//        a.setSenha(cursor.getString(6));
//        a.setIdade(cursor.getInt(7));
    }

    public void Atualizar(){

        try {
            Users a = new Users();
            a.setNome(editName.getText().toString());
            a.setTelefone(editTelefone.getText().toString());
            a.setEmail(editEmail.getText().toString());
            a.setSenha(editSenha.getText().toString());
            a.setId(Integer.parseInt(String.valueOf(id)));
            dao.atualizar(a);
            Toast.makeText(this, "Usuario atualizado com sucesso !!! ", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }

    public void Excluir(){
        try {
//            a.setId(Integer.parseInt(String.valueOf(id)));
            dao.remover(String.valueOf(id));
            Toast.makeText(this, "removido com sucesso!", Toast.LENGTH_LONG).show();
            Intent exit = new Intent(this,LoginActivity.class);
            startActivity(exit);

        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
