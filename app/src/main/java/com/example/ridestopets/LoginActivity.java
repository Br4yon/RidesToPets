package com.example.ridestopets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 1;
    private static final String ANDROID = "USER";
    private EditText editEmail;
    private EditText editSenha;
    private Button btnEntrar,btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //adiciona nas variaveis o campo com o id setado
         btnEntrar = (Button) findViewById(R.id.btnCadPet);
         btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
         editEmail = (EditText) findViewById(R.id.editTamanho);
         editSenha = (EditText) findViewById(R.id.editData);

         // evento de click no botao
        btnEntrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                // equals(variavel com as informações do banco)
                if(editEmail.getText().toString().equals("admin")
                && editSenha.getText().toString().equals("admin")){
                    // evento de direcionando a outra pagina
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), ANDROID);
                    builder.setSmallIcon(R.drawable.ic_check_box_black_24dp);
                    builder.setContentText("você logo com sucesso !!! ");
                    builder.setContentTitle("Notificação temporaria");
                    builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                    NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                    notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

                }else
                    // Toast.makeText escreve na tela(tipo pop-up) por um determinado tempo
                    Toast.makeText(LoginActivity.this, "Email ou Senha invalido", Toast.LENGTH_SHORT).show();

            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentCad = new Intent(LoginActivity.this, CadUserActivity.class);
                startActivity(intentCad);
                }

            });
        }

}
