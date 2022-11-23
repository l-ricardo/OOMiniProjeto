package modelos;

import java.util.Arrays;

public class Canal {
    String nome;
    int numero;
    Programa[] programas;

    // Construtor
    public Canal(String nome, int numero, Programa[] programas) {
        this.nome = nome;
        this.numero = numero;
        this.programas = programas;
    }

    // Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Programa[] getProgramas() {
        return programas;
    }

    public void setProgramas(Programa[] programas) {
        this.programas = programas;
    }

    @Override
    public String toString() {
        return "Canal [nome=" + nome + ", numero=" + numero + ", programas=" + Arrays.toString(programas) + "]";
    }

}