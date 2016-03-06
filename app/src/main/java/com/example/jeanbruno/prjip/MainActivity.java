package com.example.jeanbruno.prjip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botaoCadastro;
    Button botaoEfetuarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoCadastro = (Button)findViewById(R.id.btnEfetuarCadastro);
        botaoEfetuarLogin = (Button)findViewById(R.id.btnEfetuarCadastro);

        //No evento clik do botao Cadastro é criado uma intencao de transicao de tela.
       botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intentCadastro = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intentCadastro);
            }
        });{
        }
    }

    public void onClickEfetuarLogin(View view){
        Intent intentLogin = new Intent(MainActivity.this, LoginActivity.class);
         startActivity(intentLogin);
        //teste
    }
}
