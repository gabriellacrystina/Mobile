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

    public String alterar(int id, String nome, String endereco, String telefone){
        long r;
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();
        where = DataBase.ESCOLA_ID + " = " + id;
        valores = new ContentValues();

        valores.put(DataBase.ESCOLA_NOME, nome);
        valores.put(DataBase.ESCOLA_ENDERECO, endereco);
        valores.put(DataBase.ESCOLA_TELEFONE, telefone);

        r = db.update(DataBase.TABELA_ESCOLAS, valores, where, null);
        db.close();

        if(r == -1)
            return "Erro ao alterar registro.";
        else
            return "Regristro alterado com sucesso!!";
    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos = {banco.ESCOLA_ID, banco.ESCOLA_NOME};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA_ESCOLAS, campos, null, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return  cursor;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos = {banco.ESCOLA_ID, banco.ESCOLA_NOME, banco.ESCOLA_ENDERECO, banco.ESCOLA_TELEFONE};
        String where = banco.ESCOLA_ID + " = " + id;
        db = banco.getReadableDatabase();
        cursor = db.query(DataBase.TABELA_ESCOLAS, campos, where, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return  cursor;
    }

    public String excluir(int id){
        long resultado;
        String where = DataBase.ESCOLA_ID + " = " + id;
        db = banco.getReadableDatabase();
        resultado = db.delete(DataBase.TABELA_ESCOLAS, where, null);
        db.close();

        if(resultado == -1)
            return "Erro ao excluir o registro.";
        else
            return "Regristro excluido com sucesso!!";
    }
}