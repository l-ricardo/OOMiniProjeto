package modelos;

public class Apresentador {
    String nome;
    char sexo;

    // Construtores
    public Apresentador(String nome, char sexo) {
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
