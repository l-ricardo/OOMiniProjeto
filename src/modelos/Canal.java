package modelos;

import java.util.Arrays;

public class Canal {
    String nome;
    int numero;
    Programa[] programas;

    // Construtor
    public Canal(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
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

    public void setProgramas(Programa... programas) {
        this.programas = programas;
    }

    @Override
    public String toString() {
        return "\n###################### Canal " + numero + ": " + nome+ " ######################\n" + Arrays.toString(programas);
    }

}