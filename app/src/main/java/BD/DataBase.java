package BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jean Bruno on 05/03/2016.
 */
public class DataBase extends SQLiteOpenHelper {
    //Classe responsável pela criaçao do banco e pelo versionamento do mesmo

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "vendedores";
    public static final String ID = "_id ";
    public static final String NOME = "nome";
    public static final String ENDERECO = "endereco";
    public static final String TELEFONE = "telefone";
    public static final String LOGIN = "login";
    public static final String SENHA = "senha";
    public static final int VERSAO = 1;


    public DataBase(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQLiteDatabase é a classe que contem métodos de manipulacao de dados no banco;
        String sql = " CREATE TABLE vendedores (_id integer primary key autoincrement, NOME  text, ENDERECO  text, TELEFONE  text, LOGIN  text, SENHA   text)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(db);
    }

}
