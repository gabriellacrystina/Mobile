package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

    /**
    public String insereEscola(String nome, String endereco, String telefone){
        String r ="";

        ContentValues valores;
        long result = 0;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        return r;
        //valores.put(DataBase.);
    }**/
}