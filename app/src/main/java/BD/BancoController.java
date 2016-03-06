package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

/**
 * Created by Jean Bruno on 05/03/2016.
 */
public class BancoController {

    private SQLiteDatabase db;
    private DataBase banco;

    public BancoController(Context context){
        banco = new DataBase(context);
    }

    public String insertData(String nome, String endereco, String telefone, String login, String senha){
        ContentValues valores;
        //Eu trocaria o long por int(integer)!!!
        long result=0;

        db = banco.getWritableDatabase(); //getWritableDatabase é utilizado para informar ao banco que sera feita uma operaçao de escrita/leitura!!
        valores = new ContentValues();

        valores.put(DataBase.NOME, nome);
        valores.put(DataBase.ENDERECO,endereco);
        valores.put(DataBase.TELEFONE, telefone);
        valores.put(DataBase.LOGIN, login);
        valores.put(DataBase.SENHA, senha);
        db.close();


        if (result ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }
}
