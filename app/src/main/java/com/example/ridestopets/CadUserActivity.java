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

public class CadUserActivity extends AppCompatActivity {

    private EditText editName, editTelefone, editEmail, editSenha, editData , editIdade,editCpf , editEndereco;

    private Button btnCadastrar;
    private UsersDao dao;
    private Conexao conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_user);

        //adiciona nas variaveis o campo com o id setado
        btnCadastrar = (Button) findViewById(R.id.btnEntrar);
        editName = (EditText) findViewById(R.id.editName);
        editTelefone = (EditText) findViewById(R.id.editTelefone);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editSenha = (EditText) findViewById(R.id.editSenha);
        editData = (EditText) findViewById(R.id.editData);
        editIdade = (EditText) findViewById(R.id.editIdade);
        editCpf = (EditText) findViewById(R.id.editCpf);
        editEndereco = (EditText) findViewById(R.id.editEndereco);

        conexao = new Conexao(this);
        dao = new UsersDao();
        dao.setConexao(conexao);

        // evento de click no botao
        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                    // equals(variavel com as informações do banco)
                    if(editName.getText().toString().isEmpty()) {
                        Toast.makeText(CadUserActivity.this, "campo NOME não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                    }else if(editTelefone.getText().toString().isEmpty()) {
                        Toast.makeText(CadUserActivity.this, "campo TELEFONE não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                    }else if(editEmail.getText().toString().isEmpty()) {
                        Toast.makeText(CadUserActivity.this, "campo EMAIL não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                    }else if(editSenha.getText().toString().isEmpty()) {
                        Toast.makeText(CadUserActivity.this, "campo SENHA não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                    }else if(editData.getText().toString().isEmpty()) {
                        Toast.makeText(CadUserActivity.this, "campo DATA não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                    }else if(editIdade.getText().toString().isEmpty()) {
                        Toast.makeText(CadUserActivity.this, "campo IDADE não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                    }else if(editCpf.getText().toString().isEmpty()) {
                        Toast.makeText(CadUserActivity.this, "campo CPF não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                    }else if(editEndereco.getText().toString().isEmpty()) {
                        Toast.makeText(CadUserActivity.this, "campo ENDEREÇO não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                    }else {

                        // evento de direcionando a outra pagina
                        Intent intent = new Intent(CadUserActivity.this, PerfilActivity.class);

                        editName = (EditText) findViewById(R.id.editName);
                        editTelefone = (EditText) findViewById(R.id.editTelefone);
                        editEmail = (EditText) findViewById(R.id.editEmail);
                        editSenha = (EditText) findViewById(R.id.editSenha);
                        editData = (EditText) findViewById(R.id.editData);
                        editIdade = (EditText) findViewById(R.id.editIdade);
                        editCpf = (EditText) findViewById(R.id.editCpf);
                        editEndereco = (EditText) findViewById(R.id.editEndereco);

                            Users u = new Users();
                            u.setNome(editName.getText().toString());
                            u.setTelefone(editTelefone.getText().toString());
                            u.setEmail(editEmail.getText().toString());
                            u.setSenha(editSenha.getText().toString());
                            u.setData(editData.getText().toString());
                            u.setIdade(Integer.parseInt(editIdade.getText().toString()));
                            u.setCpf(editCpf.getText().toString());
                            u.setEndereco(editEndereco.getText().toString());
                            dao.inserir(u);


                    }

            }
        });

    }
}

//                            long id = dao.inserir(u);
//                            Toast.makeText(this, "Aluno com id: " + id, Toast.LENGTH_LONG).show();
//                            intent.putExtra("name", editName.getText().toString());
//                            intent.putExtra("telefone", editTelefone.getText().toString());
//                            intent.putExtra("email", editEmail.getText().toString());
//                            intent.putExtra("senha", editSenha.getText().toString());
//                        startActivity(intent);
//                        // Toast.makeText escreve na tela(tipo pop-up) por um determinado tempo
//                        Toast.makeText(CadUserActivity.this, "Confirmação de Senha invalido", Toast.LENGTH_SHORT).show();
