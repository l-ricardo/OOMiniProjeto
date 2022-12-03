package modelos;

import java.util.Arrays;

public class NovelaFilmeSerie extends Programa {
    private Personagem[] personagens;

    // Construtor
    public NovelaFilmeSerie(String nome, Canal canal) {
        super(nome, canal);
    }

    public NovelaFilmeSerie(String nome, Horario[] horarios, Canal canal, Personagem[] personagens) {
        super(nome, horarios, canal);
        this.personagens = personagens;
    }

    @Override
    public String toString() {
        return "\n################################ " + getNome() + " ################################" +
                "\n" + getCanal() +
                "\nHorarios: " + Arrays.toString(getHorarios()) +
                "\nEstrelando: " + Arrays.toString(personagens);
    }

    // Gets e Sets
    public Personagem[] getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Personagem... personagens) {
        this.personagens = personagens;
    }

}
