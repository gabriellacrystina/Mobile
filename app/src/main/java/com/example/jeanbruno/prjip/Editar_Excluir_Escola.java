package com.example.jeanbruno.prjip;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import BD.DAOEscola;
import BD.DataBase;

public class Editar_Excluir_Escola extends AppCompatActivity {

    EditText nome;
    EditText endereco;
    EditText telefone;
    DAOEscola daoEscola;
    String codigo;
    Button btnAlterar;
    Button btnExcluir;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar__excluir__escola);

        btnExcluir = (Button)findViewById(R.id.btnExcluirEscola);

        codigo = this.getIntent().getStringExtra("codigo");

        daoEscola = new DAOEscola(getBaseContext());

        nome = (EditText)findViewById(R.id.editText4);
        endereco = (EditText)findViewById(R.id.editText5);
        telefone = (EditText)findViewById(R.id.editText6);

        btnAlterar = (Button)findViewById(R.id.btnEditarEscola);
        cursor = daoEscola.carregaDadoById(Integer.parseInt(codigo));

        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(DataBase.ESCOLA_NOME)));
        endereco.setText(cursor.getString(cursor.getColumnIndexOrThrow(DataBase.ESCOLA_ENDERECO)));
        telefone.setText(cursor.getString(cursor.getColumnIndexOrThrow(DataBase.ESCOLA_TELEFONE)));

    }

    public void botaoEditarEscola(View view){
        String resultado;

        EditText nomeEditado;
        EditText enderecoEditado;
        EditText telefoneEditado;

        nomeEditado = (EditText)findViewById(R.id.editText4);
        enderecoEditado = (EditText)findViewById(R.id.editText5);
        telefoneEditado = (EditText)findViewById(R.id.editText6);

        String nomeString = nomeEditado.getText().toString();
        String enderecoString = enderecoEditado.getText().toString();
        String telefoneString = telefoneEditado.getText().toString();


        resultado = daoEscola.alterar(Integer.parseInt(codigo),nomeString, enderecoString, telefoneString );
        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Editar_Excluir_Escola.this, ListaEscolasActivity.class);
        startActivity(intent);
    }

    public void botaoExcluirEscola(View view){
        String resultado;
        resultado = daoEscola.excluir(Integer.parseInt(codigo));

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Editar_Excluir_Escola.this, ListaEscolasActivity.class);
        startActivity(intent);
    }
}
