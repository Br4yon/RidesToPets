package com.example.ridestopets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.ridestopets.Controllers.Animal;
import com.example.ridestopets.Models.Conexao;
import com.example.ridestopets.Models.PetsDao;

public class PerfilPetActivity extends AppCompatActivity {

    private EditText editName, editIdade, editTamanho, editData;
    private PetsDao dao;
    private Conexao conexao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_pet);

        editName = (EditText) findViewById(R.id.editName);
        editIdade = (EditText) findViewById(R.id.editIdade);
        editTamanho = (EditText) findViewById(R.id.editTamanho);
        editData = (EditText) findViewById(R.id.editData);

        conexao = new Conexao(this);
        dao = new PetsDao();
        dao.setConexao(conexao);

        int id = 14;
        perfil(id);
    }

    public void perfil(int id){
        Animal perfilPet = dao.perfil(id);
        editName.setText(perfilPet.getNome());
        editIdade.setText(perfilPet.getIdade());
        editTamanho.setText(perfilPet.getTamanho());
        editData.setText(perfilPet.getData());

    }
}