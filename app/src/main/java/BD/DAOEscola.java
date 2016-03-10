package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

/**
 * Created by Jean Bruno on 07/03/2016.
 */
public class DAOEscola {

    private SQLiteDatabase db;
    private DataBase banco;
    private Cursor cursor;

    public DAOEscola(Context context){
        banco = new DataBase(context);
    }


    public String inserir(String nome, String endereco, String telefone){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(DataBase.ESCOLA_NOME, nome);
        valores.put(DataBase.ESCOLA_ENDERECO, endereco);
        valores.put(DataBase.ESCOLA_TELEFONE, telefone);

        resultado = db.insert(DataBase.TABELA_ESCOLAS, null, valores);
        db.close();

        if(resultado == -1)
            return "Erro ao inserir registro.";
        else
            return "Regristro inserido com sucesso!!";
    }
}