package com.example.ridestopets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    private TextView editName, editTelefone, editEmail, editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        editName = (TextView) findViewById(R.id.editName);
        editTelefone = (TextView) findViewById(R.id.editTelefone);
        editEmail = (TextView) findViewById(R.id.editEmail);
        editSenha = (TextView) findViewById(R.id.editSenha);

        Intent intent = getIntent();

//        Recuperei a string da outra activity
//        String name = intent.getStringExtra("name");

        editName.setText(intent.getStringExtra("name"));
        editTelefone.setText(intent.getStringExtra("telefone"));
        editEmail.setText(intent.getStringExtra("email"));
        editSenha.setText(intent.getStringExtra("senha"));


    }
}
