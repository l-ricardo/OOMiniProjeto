package model;

/**
 * Uma classe que representa uma pessoa real.
 */
public class Pessoa {
    protected String nome;
    protected char sexo;

    // Construtores
    /**
     * Contrutor que recebe o nome e o sexo de uma pessoa.
     * 
     * @param nome Nome da pessoa
     * @param sexo Char com a sigla (letra inicial) do sexo da pessoa
     */
    public Pessoa(String nome, char sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    // Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
