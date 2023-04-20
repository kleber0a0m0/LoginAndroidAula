package br.edu.ifsuldeminas.mch.login;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String USUARIO = "Kleber";
    private static final String SENHA = "1";

    private ActivityResultLauncher<String> startActivitWelcome = registerForActivityResult(
            new SimpleContract(), new ActivityResultCallback<String>() {
                @Override
                public void onActivityResult(String result) {
                    if(result.equals("")){
                        Toast t = Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT);
                        t.show();
                    }

                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextUsuario = findViewById(R.id.editTextUser);
                String nomeUsuario = editTextUsuario.getText().toString().trim();

                EditText editTextPW = findViewById(R.id.editTextPW);
                String senha = editTextPW.getText().toString().trim();

                if (nomeUsuario.equals("") || senha.equals("")) {
                    //APAGAR INICIO
                    Intent intent = new Intent(getApplicationContext(),
                            WelcomeActivity.class);

                    intent.putExtra("USER", "Kleber");

                    startActivity(intent);
                    //APAGAR FIM

                    Toast.makeText(view.getContext(),
                            R.string.user_senha_vazio,
                            Toast.LENGTH_SHORT).show();

                    return;
                }

                if (USUARIO.equals(nomeUsuario) && SENHA.equals(senha)) {
                    Intent intent = new Intent(getApplicationContext(),
                            WelcomeActivity.class);

                    intent.putExtra("USER", nomeUsuario);

                    startActivity(intent);
                } else {
                    Toast.makeText(view.getContext(),
                            R.string.user_ou_senha_invalido,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button buttonForgotPW = findViewById(R.id.buttonForgotPW);
        buttonForgotPW.setOnClickListener(new FogotPW());
    }

    public void signIn(View v){
        Toast toast = Toast.makeText(v.getContext(),
                R.string.cadastrar_clicado, Toast.LENGTH_SHORT);

        toast.show();
    }
}