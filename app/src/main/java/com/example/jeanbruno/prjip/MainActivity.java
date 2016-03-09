package com.example.jeanbruno.prjip;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends ListActivity {

    /**
    Button botaoCadastro;
    Button botaoEfetuarLogin;
    **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        String[] menus = {"Efetuar Login", "Efetuar Cadastro"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, menus);

        setListAdapter(adapter);

        /**
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
         **/
    }
    /**
    public void onClickEfetuarLogin(View view){
        Intent intentLogin = new Intent(MainActivity.this, LoginActivity.class);
         startActivity(intentLogin);
        //teste
    }
     **/

    @Override
    protected void onListItemClick(ListView lv, View view, int position, long id ){
        super.onListItemClick(lv, view, position, id);

        switch (position){
            case 0:
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
                break;
            case 1:
                startActivity(new Intent(getBaseContext(), CadastroActivity.class));
                break;
            default:
                break;
        }

    }
}
