package br.edu.ifsuldeminas.mch.login;

import android.view.View;
import android.widget.Toast;

public class FogotPW implements View.OnClickListener {
    @Override
    public void onClick(View v){
        Toast toast = Toast.makeText(v.getContext(),
                R.string.esqueci_senha_clicado, Toast.LENGTH_SHORT);

        toast.show();
    }
}
