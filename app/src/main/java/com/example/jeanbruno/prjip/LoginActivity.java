package com.example.jeanbruno.prjip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import BD.BancoController;

public class LoginActivity extends AppCompatActivity {

    Button btnAcessar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnAcessar = (Button)findViewById(R.id.btnAcessar);

    }

    public void onClickAcessar(View view){
        String permissao;
        BancoController bc = new BancoController(getBaseContext());

        EditText nome = (EditText)findViewById(R.id.txtNomeLogin);
        EditText senha = (EditText)findViewById(R.id.txtSenhaLogin);

        String nomeString = nome.getText().toString();
        String senhaString = senha.getText().toString();

    }
}
