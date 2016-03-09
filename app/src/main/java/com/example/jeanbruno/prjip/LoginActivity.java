package com.example.jeanbruno.prjip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import BD.BancoController;

public class LoginActivity extends AppCompatActivity {

    Button btnAcessar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnAcessar = (Button)findViewById(R.id.btnAcessar);

    }

    /**
    public void onClickBtnAcessar(View view){

        Boolean permissao        ;

        BancoController bc = new BancoController(getBaseContext());

        EditText nome = (EditText)findViewById(R.id.txtNomeLogin);
        EditText senha = (EditText)findViewById(R.id.txtSenhaLogin);

        String nomeString = nome.getText().toString();
        String senhaString = senha.getText().toString();

        if(nomeString.length() == 0 || senhaString.length() == 0){
            Toast.makeText(getApplicationContext(), "Os campos login e senha são obrigatórios", Toast.LENGTH_LONG).show();
        }else{
            permissao = bc.validaUsuário(nomeString, senhaString);

            if(permissao == false){
                Toast.makeText(getApplicationContext(), "Login ou senha estão incorretos", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), "Acesso liberado!!", Toast.LENGTH_LONG).show();
                Intent intentListaEscolas = new Intent(LoginActivity.this, ListaEscolasActivity.class);
                startActivity(intentListaEscolas);
            }
        }
     **/


}
