package modelos;

public class Personagem extends Pessoa {
    private String ator;

    // Construtores
    public Personagem(String nome, char sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public Personagem(String nome, char sexo, String ator) {
        this(nome, sexo);
        this.ator = ator;
    }

    @Override
    public String toString() {
        if (ator != null) {
            return ator + " como " + nome;
        }
        return nome;
    }

    // Gets e Sets
    public String getAtor() {
        return ator;
    }

    public void setAtor(String ator) {
        this.ator = ator;
    }

}
