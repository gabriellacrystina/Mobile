package model;

/**
 * Created by Jean Bruno on 05/03/2016.
 */
public class Pessoa {

    private String nome;
    private String endereco;
    private String telefone;


    public Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

}
