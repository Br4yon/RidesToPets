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

public class CadPetsActivity extends AppCompatActivity {

    private EditText editEspecie, editName, editIdade, editRaca, editData, editTamanho;
    private Button btnCadPet;
    private PetsDao dao;
    private Conexao conexao;
    private int pai;
    int idpet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_pets);
        conexao = new Conexao(this);
        dao = new PetsDao();
        dao.setConexao(conexao);

        editEspecie = (EditText) findViewById(R.id.editEspecie);
        editName = (EditText) findViewById(R.id.editName);
        editIdade = (EditText) findViewById(R.id.editIdade);
        editRaca = (EditText) findViewById(R.id.editRaca);
        editData = (EditText) findViewById(R.id.editData);
        editTamanho = (EditText) findViewById(R.id.editTamanho);
        btnCadPet = (Button) findViewById(R.id.btnCadPet);

//        try {
//            Intent IntentIdPai = getIntent();
//            pai = IntentIdPai.getIntExtra("id_user" , 0);
//            Toast.makeText(CadPetsActivity.this, String.valueOf(pai), Toast.LENGTH_SHORT).show();
//
//        }catch(Exception e) {
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
//        }

        btnCadPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cadPet();
//                Toast.makeText(CadPetsActivity.this, "cadastrado com sucesso!!", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void cadPet() {
        try {
            Intent IntentIdPai = getIntent();
            pai = IntentIdPai.getIntExtra("id_user" , 0);

            Animal pet = new Animal();
            pet.setEspecie(editEspecie.getText().toString());
            pet.setNome(editName.getText().toString());
            pet.setIdade(editIdade.getText().toString());
            pet.setRaca(editRaca.getText().toString());
            pet.setTamanho(editTamanho.getText().toString());
            pet.setData(editData.getText().toString());
            pet.setIdPai(pai);

            idpet = (int) dao.inserirPet(pet);

            Toast.makeText(CadPetsActivity.this,
                    editEspecie.getText().toString() +
                    editName.getText().toString()+
                    editIdade.getText().toString()+
                    editRaca.getText().toString()+
                    editTamanho.getText().toString()+
                    editData.getText().toString(), Toast.LENGTH_SHORT).show();

            Toast.makeText(CadPetsActivity.this, "Cadastrado com Sucesso !!! " + idpet, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(CadPetsActivity.this, PerfilPetActivity.class);
            intent.putExtra("id_pet", idpet);
            intent.putExtra("id_user", pai);
            startActivity(intent);

        } catch (Exception e)
        {
            Toast.makeText(CadPetsActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}