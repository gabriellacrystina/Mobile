package BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jean Bruno on 05/03/2016.
 */
public class DataBase extends SQLiteOpenHelper {
    //Classe responsável pela criaçao do banco e pelo versionamento do mesmo

    //Informação da Base de dados
    protected static final String NOME_BANCO = "banco.db";
    protected static final int VERSAO = 1;

    //Nome das tabelas
    protected static final String TABELA_ESCOLAS = "escolas";
    protected static final String TABELA_VENDEDORES = "vendedores";

    //Campos da tabela vendedores
    protected static final String VENDEDOR_ID = "_id ";
    protected static final String VENDEDOR_NOME = "nome";
    protected static final String VENDEDOR_ENDERECO = "endereco";
    protected static final String VENDEDOR_TELEFONE = "telefone";
    protected static final String VENDEDOR_LOGIN = "login";
    protected static final String VENDEDOR_SENHA = "senha";

    //Campos da tabela escolas
    protected static final String ESCOLA_ID = "_id ";
    protected static final String ESCOLA_NOME = "nome";
    protected static final String ESCOLA_ENDERECO = "endereco";
    protected static final String ESCOLA_TELEFONE = "telefone";

    public DataBase(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    /** Called when the databases connection is being configured.
     Configure database settings for things like foreign key support, write-ahead logging, etc.

    @Override
    public void onConfigure(SQLiteDatabase db){
        super.onConfigure(db);
        //db.setForeignKeyConstraintsEnabled(true);
    }**/

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_VENDEDORES_TABLE = "CREATE TABLE " + TABELA_VENDEDORES +
                " ( " +
                VENDEDOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                VENDEDOR_NOME + " TEXT, " +
                VENDEDOR_ENDERECO + " TEXT, " +
                VENDEDOR_TELEFONE + " TEXT, " +
                VENDEDOR_LOGIN + " TEXT, " +
                VENDEDOR_SENHA +
                " ) ";

        String CREATE_ESCOLAS_TABLE = "CREATE TABLE " + TABELA_ESCOLAS +
                " ( " +
                ESCOLA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ESCOLA_NOME + " TEXT, " +
                ESCOLA_ENDERECO + " TEXT, " +
                ESCOLA_TELEFONE + " TEXT, " +
                " ) ";

        db.execSQL(CREATE_VENDEDORES_TABLE);
        db.execSQL(CREATE_VENDEDORES_TABLE);
    }

    //Called when the database needs to be upgraded
    //This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    //but the DATABASE_VERSION is different than the version of the that exists on disk.

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Simplest implementation is to drop all old tables and recreate them
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_VENDEDORES);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_ESCOLAS);
        onCreate(db);
    }
}
