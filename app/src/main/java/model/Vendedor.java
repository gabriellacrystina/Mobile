package model;

/**
 * Created by Jean Bruno on 05/03/2016.
 */
public class Vendedor extends Pessoa {

    private String login;
    private String senha;

    public Vendedor(String nome, String telefone, String login, String senha) {
        super(nome, telefone);
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
