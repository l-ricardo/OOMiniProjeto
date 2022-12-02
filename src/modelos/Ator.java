package modelos;

public class Ator extends Pessoa {
    String personagemAtual;

    // Construtores
    public Ator(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public Ator(String nome, char sexo, int idade, String personagemAtual) {
        this(nome, sexo, idade);
        this.personagemAtual = personagemAtual;
    }

    @Override
    public String toString() {
        if (personagemAtual != null) {
            return nome + " no papel de " + personagemAtual;
        }
        return nome;
    }

    // Gets e Sets
    public String getPersonagemAtual() {
        return personagemAtual;
    }

    public void setPersonagemAtual(String personagemAtual) {
        this.personagemAtual = personagemAtual;
    }

}
