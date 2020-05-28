package com.example.ridestopets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadUserActivity extends AppCompatActivity {

//    private Session session;
    private EditText editName, editTelefone, editEmail, editSenha, editConfirm;
    private Button btnCadastrar;

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
        editConfirm = (EditText) findViewById(R.id.editConfirm);

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
                    }else if(editConfirm.getText().toString().isEmpty()) {
                        Toast.makeText(CadUserActivity.this, "campo CONFIRMAÇÃO SENHA não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                    }else {

//                        session = new Session();

                        // evento de direcionando a outra pagina
                        Intent intent = new Intent(CadUserActivity.this, PerfilActivity.class);

//                        session.setNome(editName.getText().toString());
//                        session.setTelefone(editTelefone.getText().toString());
//                        session.setEmail(editEmail.getText().toString());
//                        session.setSenha(editSenha.getText().toString());


                            intent.putExtra("name", editName.getText().toString());
                            intent.putExtra("telefone", editTelefone.getText().toString());
                            intent.putExtra("email", editEmail.getText().toString());
                            intent.putExtra("senha", editSenha.getText().toString());
                        startActivity(intent);

//                        // Toast.makeText escreve na tela(tipo pop-up) por um determinado tempo
//                        Toast.makeText(CadUserActivity.this, "Confirmação de Senha invalido", Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }
}
