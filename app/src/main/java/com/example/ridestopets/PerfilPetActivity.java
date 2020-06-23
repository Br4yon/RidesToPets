package com.example.ridestopets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ridestopets.Controllers.Animal;
import com.example.ridestopets.Models.Conexao;
import com.example.ridestopets.Models.PetsDao;

public class PerfilPetActivity extends AppCompatActivity {

    private EditText editName, editIdade, editTamanho, editData;
    private PetsDao dao;
    private Conexao conexao;
    private Button btnExcluirPet;

    int idpet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_pet);

        editName = (EditText) findViewById(R.id.editName);
        editIdade = (EditText) findViewById(R.id.editIdade);
        editTamanho = (EditText) findViewById(R.id.editTamanho);
        editData = (EditText) findViewById(R.id.editData);
        btnExcluirPet = (Button) findViewById(R.id.btnExcluirPet);

        conexao = new Conexao(this);
        dao = new PetsDao();
        dao.setConexao(conexao);

        Intent it = getIntent();
        idpet = it.getIntExtra("id_pet" , 0);
        perfil(idpet);

        Toast.makeText(this, idpet + String.valueOf(idpet), Toast.LENGTH_LONG).show();

        btnExcluirPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Excluir();
            }
        });
    }

    public void perfil(int idpet){
        Animal perfilPet = dao.perfil(idpet);
        editName.setText(perfilPet.getNome());
        editIdade.setText(perfilPet.getIdade());
        editTamanho.setText(perfilPet.getTamanho());
        editData.setText(perfilPet.getData());
    }

    public void Excluir(){
        try {
            dao.remover(String.valueOf(idpet));
            Toast.makeText(this, "Pet removido com sucesso!", Toast.LENGTH_LONG).show();
            Intent excluirPet = new Intent(this,HomeActivity.class);
            startActivity(excluirPet);

        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}