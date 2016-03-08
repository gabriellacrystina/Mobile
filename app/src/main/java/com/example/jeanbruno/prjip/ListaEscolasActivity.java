package com.example.jeanbruno.prjip;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ListaEscolasActivity extends ListActivity implements AdapterView.OnItemClickListener{

    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter sca;
    ListView listViewEscolas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_escolas);

        //Buscar do banco.
        bucarDados();

        //Setar o Adapter
        criarListagem();
    }

    public void bucarDados(){

        try{
            db = openOrCreateDatabase("banco.db", Context.MODE_PRIVATE, null);
            cursor = db.rawQuery("SELECT * FROM ESCOLAS", null);
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void criarListagem(){
        //Pega o listView que conterá os itens
        listViewEscolas = getListView();


        String[] from = {"_id","nome", "endereco", "telefone"};//Nomes dos campos da tabela
        int[] to = {R.id.txvSchollid,R.id.txvSchollName, R.id.txvSchollEnd, R.id.txvSchollPhone}; //campos do model

        sca = new SimpleCursorAdapter(getApplicationContext(), R.layout.model_listview_escola, cursor, from, to);

        listViewEscolas.setAdapter(sca);
        //habilita o click no item da lista
       //listViewEscolas.setOnClickListener((View.OnClickListener) this);
        //listViewEscolas.setAdapter(sca);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*
        * Cursor c = (SQLiteCursor) sca.getItem(position);
        * String nome = c.getString(c.getColumnIndex("nome"));
        * Toast...
        * */

        SQLiteCursor sqlCursor = (SQLiteCursor) sca.getItem(position);
        String nome = sqlCursor.getString(sqlCursor.getColumnIndex("nome"));

        Toast.makeText(getApplicationContext(), "Selecionou o nome: " + nome, Toast.LENGTH_SHORT).show();
    }
}