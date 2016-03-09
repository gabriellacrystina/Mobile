package com.example.jeanbruno.prjip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import BD.DAOEscola;

public class CadastroEscola extends AppCompatActivity {

    Button btnAdicionarEscola;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_escola);

        btnAdicionarEscola = (Button)findViewById(R.id.btnAdicionarEscola);

    }

    /**
    public void onClickButtonAdcionarEscola(View view){
        String resultado;
        DAOEscola daoEscola = new DAOEscola();

        EditText nomeEscola = (EditText)findViewById(R.id.txvSchollName);
        EditText enderecoEscola = (EditText)findViewById(R.id.txvSchollEnd);
        EditText telefoneEscola = (EditText)findViewById(R.id.txvSchollPhone);

        String nomeEscolaString = nomeEscola.getText().toString();
        String enderecoEscolaString = enderecoEscola.getText().toString();
        String telefoneEscolaString = telefoneEscola.getText().toString();

        resultado = daoEscola.insereEscola(nomeEscolaString, enderecoEscolaString, telefoneEscolaString);

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();
    }**/
}
