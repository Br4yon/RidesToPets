package controler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ridestopets.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editSenha;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //adiciona nas variaveis o campo com o id setado
         btnEntrar = (Button) findViewById(R.id.btnEntrar);
         editEmail = (EditText) findViewById(R.id.editEmail);
         editSenha = (EditText) findViewById(R.id.editSenha);

         // evento de click no botao
        btnEntrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                // equals(variavel com as informações do banco)
                if(editEmail.getText().toString().equals("admin")
                && editSenha.getText().toString().equals("admin")){
                    // evento de direcionando a outra pagina
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);

                }else
                    // Toast.makeText escreve na tela(tipo pop-up) por um determinado tempo
                    Toast.makeText(LoginActivity.this, "Email ou Senha invalido", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
