package com.example.ridestopets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ridestopets.Controllers.Animal;
import com.example.ridestopets.Models.Conexao;
import com.example.ridestopets.Models.PetsDao;

public class CadPetsActivity extends AppCompatActivity {

    private EditText editEspecie, editName, editIdade, editRaca, editData, editTamanho;
    private Button btnCadPet;
    private PetsDao dao;
    private Conexao conexao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_pets);

        editEspecie = (EditText) findViewById(R.id.editEspecie);
        editName = (EditText) findViewById(R.id.editName);
        editIdade = (EditText) findViewById(R.id.editIdade);
        editRaca = (EditText) findViewById(R.id.editRaca);
        editData = (EditText) findViewById(R.id.editData);
        editTamanho = (EditText) findViewById(R.id.editTamanho);
        btnCadPet = (Button) findViewById(R.id.btnCadPet);


        conexao = new Conexao(this);
        dao = new PetsDao();
        dao.setConexao(conexao);

        // evento de click no botao
        btnCadPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editName.getText().toString().isEmpty()) {
                    Toast.makeText(CadPetsActivity.this, "campo NOME não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                }else if(editEspecie.getText().toString().isEmpty()) {
                    Toast.makeText(CadPetsActivity.this, "campo ESPECIE não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                }else if(editIdade.getText().toString().isEmpty()) {
                    Toast.makeText(CadPetsActivity.this, "campo IDADE não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                }else if(editRaca.getText().toString().isEmpty()) {
                    Toast.makeText(CadPetsActivity.this, "campo RAÇA não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                }else if(editData.getText().toString().isEmpty()) {
                    Toast.makeText(CadPetsActivity.this, "campo DATA não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                }else if(editTamanho.getText().toString().isEmpty()) {
                    Toast.makeText(CadPetsActivity.this, "campo TAMANHO não pode ser vazio !!! ", Toast.LENGTH_SHORT).show();
                }else {

                    salvar();
//                        Intent intent = new Intent(CadUserActivity.this, PerfilActivity.class);
                }

            }
        });

    }

        public void salvar(){
        Animal a = new Animal();
        a.setEspecie(editEspecie.getText().toString());
        a.setNome(editName.getText().toString());
        a.setIdade(editIdade.getText().toString());
        a.setRaca(editRaca.getText().toString());
        a.setTamanho(editTamanho.getText().toString());
        a.setData(editData.getText().toString());
        long id = dao.inserir(a);

        Toast.makeText(CadPetsActivity.this, "Cadastrado com Sucesso" +id, Toast.LENGTH_SHORT).show();
    }
}