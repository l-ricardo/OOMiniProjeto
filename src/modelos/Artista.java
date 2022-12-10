package modelos;

public class Artista extends Pessoa {
    private String tipo; // Ex: Humorista, Jornalista, Entrevistador, etc...
    private boolean musico;
    private String instrumento;
    {
        musico = false;
    }

    // Construtores
    public Artista(String nome, char sexo, String tipo) {
        super(nome, sexo);
        this.tipo = tipo;
    }

    public Artista(String nome, char sexo, String tipo, boolean musico, String instrumento) {
        this(nome, sexo, tipo);
        this.musico = musico;
        this.instrumento = instrumento;
    }

    @Override
    public String toString() {
        if (tipo != null) {
            return tipo + " " + nome;
        }
        if (isMusico()) {
            return tipo + " " + nome + " tocando" + instrumento;
        }
        return nome;
    }

    // Gets e Sets
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isMusico() {
        return musico;
    }

    public void setMusico(boolean musico) {
        this.musico = musico;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

}
