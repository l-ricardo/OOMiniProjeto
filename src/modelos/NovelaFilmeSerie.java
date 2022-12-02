package modelos;

import java.util.Arrays;

public class NovelaFilmeSerie extends Programa {
    Ator[] atores;

    // Construtor
    public NovelaFilmeSerie(String nome, Horario[] horarios, Canal canal, Ator[] atores) {
        super(nome, horarios, canal);
        this.atores = atores;
    }

    @Override
    public String toString() {
        return "------------------" + nome + "------------------" +
                "\nNos horarios: " + Arrays.toString(horarios) + "\n" +
                "\nEstrelando " + Arrays.toString(atores);
    }

    // Gets e Sets
    public Ator[] getAtores() {
        return atores;
    }

    public void setAtores(Ator... atores) {
        this.atores = atores;
    }

}
