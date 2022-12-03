package modelos;

public class Apresentador extends Pessoa {
    String tipo; //Ex: Humorista, Jornalista, Entrevistador, etc...

    // Construtores
    public Apresentador(String nome, char sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public Apresentador(String nome, char sexo, String tipo) {
        this(nome, sexo);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        if (tipo != null) {
            return  tipo + " " + nome;
        }
        return nome;
    }

    // Gets e Sets
    public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }

}
