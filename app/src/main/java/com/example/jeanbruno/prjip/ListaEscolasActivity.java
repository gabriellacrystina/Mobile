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
    Cursor cursor;
    Button btnAdicionarEscola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_escolas);

        DAOEscola daoEscola = new DAOEscola(getBaseContext());
        cursor = daoEscola.carregaDados();

        String[] nomeCampos = new String[]{DataBase.ESCOLA_ID, DataBase.ESCOLA_NOME};
        int[] idViews = new int[]{R.id.txvSchollid, R.id.txvSchollName};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.model_listview_escola, cursor, nomeCampos, idViews, 0);

        listViewEscolas = (ListView) findViewById(R.id.listView);
        listViewEscolas.setAdapter(adapter);

        listViewEscolas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(DataBase.ESCOLA_ID));
                Intent intent = new Intent(ListaEscolasActivity.this, Editar_Excluir_Escola.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
    public void onClickAdicionarEscola(View view){
        Intent intentAdiconarEscola = new Intent(ListaEscolasActivity.this, CadastroEscola.class);
        startActivity(intentAdiconarEscola);
    }
}