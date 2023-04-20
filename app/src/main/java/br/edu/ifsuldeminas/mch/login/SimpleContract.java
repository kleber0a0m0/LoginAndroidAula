package br.edu.ifsuldeminas.mch.login;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SimpleContract extends ActivityResultContract<String,String>{

    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, String usuario) {
        Intent intent =  new Intent(context, WelcomeActivity.class);
        intent.putExtra("USER", usuario);
        return intent;
    }

    @Override
    public String parseResult(int resultCode, @Nullable Intent intent) {
        if(resultCode == Activity.RESULT_OK && intent != null){
            String retorno = intent.getStringExtra("resultado");
            return retorno;
        }else{
            return "";
        }
    }
}