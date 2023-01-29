package model;

/**
 * Classe que modela uma pessoa real.
 */
public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private char sexo;

    // -------------------------------- Contrutores --------------------------------
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

    // -------------------------------- Gets e Sets --------------------------------
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

    // ---------------------------- Metodos Auxiliares ----------------------------
    /**
     * Esse override ensina a biblioteca java.util qual atributo de pessoa deve
     * ser usado na comparação entre pessoas. Possibilita o uso do método
     * Collections.sort() para ordernar pessoas alfabeticamente.
     * 
     * @param outraPessoa A outra pessoa ao qual será feita a comparação
     * @return O nome da pessoa
     */
    @Override
    public int compareTo(Pessoa outraPessoa) {
        return this.nome.compareTo(outraPessoa.nome);
    }

    // --------------------------------- toString ---------------------------------
    @Override
    public String toString() {
        return nome;
    }
}