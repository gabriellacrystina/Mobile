package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Jean Bruno on 05/03/2016.
 */
public class DAOVendedor {

    private SQLiteDatabase db;
    private DataBase banco;
    private Cursor cursor;

    public DAOVendedor(Context context) {
        banco = new DataBase(context);
    }

    public String inserir(String nome, String endereco, String telefone, String login, String senha) {

        ContentValues valores;
        long resultado;

        //getWritableDatabase é utilizado para informar ao banco que sera feita uma operaçao de escrita/leitura!!
        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(DataBase.VENDEDOR_NOME, nome);
        valores.put(DataBase.VENDEDOR_ENDERECO, endereco);
        valores.put(DataBase.VENDEDOR_TELEFONE, telefone);
        valores.put(DataBase.VENDEDOR_LOGIN, login);
        valores.put(DataBase.VENDEDOR_SENHA, senha);

        resultado = db.insert(DataBase.TABELA_VENDEDORES, null, valores);

        db.close();

        if(resultado == -1)
            return "Erro ao inserir registro.";
        else
            return "Regristro inserido com sucesso!!";


    }

    public Boolean validar(String login, String senha){
        Cursor cursor;
        String[] selectionArgs = new String[]{login, senha};

        //getReadableDatabase() oferece permissão de leitura na base.
        db = banco.getReadableDatabase();

        cursor = db.rawQuery("select _id from vendedores where login = ? and senha = ? limit 1;", selectionArgs);

        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }

/**
 *      //Montar um objeto vindo do banco
        if(cursor.moveToNext()){
            vendedor = new Vendedor(cursor.getString(cursor.getColumnIndex("nome")),
                                             cursor.getString(cursor.getColumnIndex("telefone")),
                                                     cursor.getString(cursor.getColumnIndex("login")),
                                                             cursor.getString(cursor.getColumnIndex("senha")));
            vendedor.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));

            System.out.println("CONTEÚDO DO CURSOR:" +cursor[0]['nome']);
        }


        if(vendedor == null)
            return false;
        else
            return true;  */
    }
}