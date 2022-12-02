package modelos;

import java.util.Arrays;

public class TalkShowJornal extends Programa {
    Apresentador[] apresentadores;

    // Construtor
    public TalkShowJornal(String nome, Horario[] horarios, Canal canal, Apresentador[] apresentadores) {
        super(nome, horarios, canal);
        this.apresentadores = apresentadores;
    }

    @Override
    public String toString() {
        return "------------------" + nome + "------------------" +
                "\nApresentando " + Arrays.toString(apresentadores) +
                "\nNos horarios: " + Arrays.toString(horarios) + "\n";
    }

    // Gets e Sets
    public Apresentador[] getApresentadores() {
        return apresentadores;
    }

    public void setApresentadores(Apresentador... apresentadores) {
        this.apresentadores = apresentadores;
    }

}
