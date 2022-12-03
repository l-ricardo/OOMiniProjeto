package modelos;

import java.util.Arrays;

public class TalkShowJornal extends Programa {
    private Apresentador[] apresentadores;

    // Construtor
    public TalkShowJornal(String nome, Canal canal) {
        super(nome, canal);
    }

    public TalkShowJornal(String nome, Horario[] horarios, Canal canal, Apresentador[] apresentadores) {
        super(nome, horarios, canal);
        this.apresentadores = apresentadores;
    }

    @Override
    public String toString() {
        return "\n################################ " + getNome() + " ################################" +
                "\n" + getCanal() +
                "\nHorarios: " + Arrays.toString(getHorarios()) +
                "\nApresentando: " + Arrays.toString(apresentadores);
    }

    // Gets e Sets
    public Apresentador[] getApresentadores() {
        return apresentadores;
    }

    public void setApresentadores(Apresentador... apresentadores) {
        this.apresentadores = apresentadores;
    }

}
