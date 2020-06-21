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

import com.example.ridestopets.Controllers.Users;
import com.example.ridestopets.Models.Conexao;
import com.example.ridestopets.Models.UsersDao;

public class LoginActivity extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 1;
    private static final String ANDROID = "USER";
    private EditText editEmail;
    private EditText editSenha;
    private Button btnEntrar,btnCadastrar;
    private UsersDao dao;
    private Conexao conexao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //adiciona nas variaveis o campo com o id setado
         btnEntrar = (Button) findViewById(R.id.btnEntrar);
         btnCadastrar = (Button) findViewById(R.id.btnCadastrarLogin);
         editEmail = (EditText) findViewById(R.id.editEmail);
         editSenha = (EditText) findViewById(R.id.editSenha);

        conexao = new Conexao(this);
        dao = new UsersDao();
        dao.setConexao(conexao);

         // evento de click no botao
        btnEntrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                String email = editEmail.getText().toString();
                String senha = editSenha.getText().toString();

                try {
                    // equals(variavel com as informações do banco)
                    Users userperfil = dao.login(email,senha);

                    if(editEmail.getText().toString().equals(userperfil.getEmail())
                    && editSenha.getText().toString().equals(userperfil.getSenha())){

                        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), ANDROID);
                        builder.setSmallIcon(R.drawable.ic_check_box_black_24dp);
                        builder.setContentText(userperfil.getNome()+" logo com sucesso !!! ");
                        builder.setContentTitle("Notificação temporaria");
                        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

                        Toast.makeText(LoginActivity.this, " ID : "+userperfil.getId(), Toast.LENGTH_SHORT).show();
                        // evento de direcionando a outra pagina
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.putExtra("id_user", userperfil.getId());
                        startActivity(intent);

                    }else{
                        // Toast.makeText escreve na tela(tipo pop-up) por um determinado tempo
                        Toast.makeText(LoginActivity.this, "Email ou Senha invalido", Toast.LENGTH_SHORT).show();}


                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }

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
