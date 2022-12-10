package modelos;

public class Personagem extends Pessoa {
    private Pessoa ator;
    private boolean protagonista;
    {
        protagonista = false;
    }

    // Construtores
    public Personagem(String nome, char sexo, Pessoa ator) {
        super(nome, sexo);
        this.ator = ator;
    }

    public Personagem(String nome, char sexo, Pessoa ator, boolean protagonista) {
        this(nome, sexo, ator);
        this.protagonista = protagonista;
    }

    @Override
    public String toString() {
        if (ator != null) {
            return ator.toString() + " como " + nome;
        }
        return nome;
    }

    // Gets e Sets
    public Pessoa getAtor() {
        return ator;
    }

    public void setAtor(Pessoa ator) {
        this.ator = ator;
    }

    public boolean isProtagonista() {
        return protagonista;
    }

    public void setProtagonista(boolean protagonista) {
        this.protagonista = protagonista;
    }

}
