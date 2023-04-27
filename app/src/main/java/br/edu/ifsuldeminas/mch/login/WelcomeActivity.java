package br.edu.ifsuldeminas.mch.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

public class WelcomeActivity extends AppCompatActivity {

    private static final String TAG = "act.bem_vindo";
    private static final int FOTO_ACTIVITY = 1;
    private Intent intentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intentChamadora = getIntent();

        String nomeUsuario = intentChamadora.getStringExtra("USER");
        String mensagem = String.format(getString(R.string.mensagem_bem_vindo), nomeUsuario);

        View layout = findViewById(R.id.welcomeActivityID);
        Snackbar snackbar = Snackbar.make(layout, mensagem, Snackbar.LENGTH_LONG);
        snackbar.show();
        Log.w(TAG, "Método onCreate rodou!");

        Button tirarFoto = findViewById(R.id.buttonId);
        ImageView imageViewFoto = findViewById(R.id.imageViewId);

        tirarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tiraFotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(tiraFotoIntent, FOTO_ACTIVITY);
            }
        });
        intentResult = new Intent();
        intentResult.putExtra("resultado", "Usuário não tirou a foto");
        setResult(Activity.RESULT_OK,intentResult);

    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.w(TAG, "Método onStart rodou!");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FOTO_ACTIVITY && resultCode == RESULT_OK && data != null){
            Bundle extras = data.getExtras();

            Bitmap foto = (Bitmap) extras.get("data");

            ImageView imageView = findViewById(R.id.imageViewId);
            imageView.setImageBitmap(foto);
            intentResult.putExtra("resultado","Usuário ???????");
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

}