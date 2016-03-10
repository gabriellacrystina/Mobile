package com.example.jeanbruno.prjip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import BD.DAOEscola;

public class CadastroEscola extends AppCompatActivity {

    Button btnCadastrarEscola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_escola);

        btnCadastrarEscola = (Button)findViewById(R.id.btnCadastrarEscola);

    }

    public void BotaoCadastrarEscola(View view){
        String resultado;
        DAOEscola daoEscola = new DAOEscola(getBaseContext());

        EditText nomeEscola = (EditText)findViewById(R.id.editText4);
        EditText enderecoEscola = (EditText)findViewById(R.id.editText5);
        EditText telefoneEscola = (EditText)findViewById(R.id.editText6);

        String nomeEscolaString = nomeEscola.getText().toString();
        String enderecoEscolaString = enderecoEscola.getText().toString();
        String telefoneEscolaString = telefoneEscola.getText().toString();

        resultado = daoEscola.inserir(nomeEscolaString, enderecoEscolaString, telefoneEscolaString);

        nomeEscola.setText("");
        enderecoEscola.setText("");
        telefoneEscola.setText("");

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();
    }
}
