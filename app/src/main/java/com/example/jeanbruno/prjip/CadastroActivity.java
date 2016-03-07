package com.example.jeanbruno.prjip;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import BD.BancoController;

public class CadastroActivity extends Activity {

    Button btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCadastro = (Button)findViewById(R.id.btnCadastrar);
    }

    public void buttonOnClick(View v){
        String resultado;

        BancoController bc = new BancoController(getBaseContext());

        //Capturando o conteúdo dos EditTexts
        EditText nome = (EditText)findViewById(R.id.txtNomeLogin);
        EditText endereco = (EditText)findViewById(R.id.txtEndereco);
        EditText telefone = (EditText)findViewById(R.id.txtTelefone);
        EditText login = (EditText)findViewById(R.id.txtLogin);
        EditText senha = (EditText)findViewById(R.id.txtSenhaLogin);

        //Transformando o conteúdo capturado em string
        String nomeString = nome.getText().toString();
        String enderecoString = endereco.getText().toString();
        String telefoneString = telefone.getText().toString();
        String loginString = login.getText().toString();
        String senhaString = senha.getText().toString();

        resultado = bc.insertData(nomeString, enderecoString, telefoneString, loginString, senhaString);

        //Toast mostra na tela o retorno da string resultado.
        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
    }
}
