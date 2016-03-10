package com.example.jeanbruno.prjip;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import BD.DAOEscola;
import BD.DataBase;

public class ListaEscolasActivity extends Activity{

    private ListView listViewEscolas;
    SQLiteDatabase db;
    /**
    Cursor cursor;
    SimpleCursorAdapter sca;
    **/
     Button btnAdicionarEscola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_escolas);

        DAOEscola daoEscola = new DAOEscola(getBaseContext());
        Cursor cursor = daoEscola.carregaDados();

        String[] nomeCampos = new String[]{DataBase.ESCOLA_ID, DataBase.ESCOLA_NOME};
        int[] idViews = new int[]{R.id.txvSchollid,R.id.txvSchollName};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.model_listview_escola, cursor, nomeCampos, idViews, 0);

        listViewEscolas = (ListView)findViewById(R.id.listView);
        listViewEscolas.setAdapter(adapter);

        /**
        //Buscar do banco.
        bucarDados();

        //Setar o Adapter
        criarListagem();

        btnAdicionarEscola = (Button)findViewById(R.id.btnAdicionarEscola);**/
    }

    /**
    public void bucarDados(){

        try{
            db = openOrCreateDatabase("banco.db", Context.MODE_PRIVATE, null);
            cursor = db.rawQuery("SELECT _id, nome FROM ESCOLAS", null);
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void criarListagem(){
        //Pega o listView que conterá os itens
        listViewEscolas = getListView();

        String[] from = {"_id","nome"};//Nomes dos campos da tabela
        int[] to = {R.id.txvSchollid,R.id.txvSchollName}; //campos do model

        sca = new SimpleCursorAdapter(getApplicationContext(), R.layout.model_listview_escola, cursor, from, to);


        listViewEscolas.setAdapter(sca);

        /** trecho de código que faz dar erro em tempo de execução
        //habilita o click no item da lista
        listViewEscolas.setOnClickListener((View.OnClickListener) this);
        listViewEscolas.setAdapter(sca);
    }
     **/
    /**
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*
        * Cursor c = (SQLiteCursor) sca.getItem(position);
        * String nome = c.getString(c.getColumnIndex("nome"));
        * Toast...
        * */

        /**
        SQLiteCursor sqlCursor = (SQLiteCursor) sca.getItem(position);
        String nome = sqlCursor.getString(sqlCursor.getColumnIndex("nome"));

        Toast.makeText(getApplicationContext(), "Selecionou o nome: " + nome, Toast.LENGTH_SHORT).show();
    }
    **/

    public void onClickAdicionarEscola(View view){
        Intent intentAdiconarEscola = new Intent(ListaEscolasActivity.this, CadastroEscola.class);
        startActivity(intentAdiconarEscola);
    }
}