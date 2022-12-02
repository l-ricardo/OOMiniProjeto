package modelos;

public class Apresentador extends Pessoa {
    String tipo; //Ex: Humorista, Jornalista, Entrevistador, etc...

    // Construtores
    public Apresentador(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public Apresentador(String nome, char sexo, int idade, String tipo) {
        this(nome, sexo, idade);
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
