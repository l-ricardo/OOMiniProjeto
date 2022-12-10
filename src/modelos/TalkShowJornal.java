package modelos;

import java.util.Arrays;

public class TalkShowJornal extends Programa {
    private Artista[] artistas;

    // Construtor
    public TalkShowJornal(String nome, Canal canal) {
        super(nome, canal);
    }

    public TalkShowJornal(String nome, Horario[] horarios, Canal canal, Artista[] artistas) {
        super(nome, horarios, canal);
        this.artistas = artistas;
    }

    @Override
    public String toString() {
        return "\n################################ " + getNome() + " ################################" +
                "\n" + getCanal() +
                "\nHorarios: " + Arrays.toString(getHorarios()) +
                "\nApresentando: " + Arrays.toString(artistas);
    }

    // Gets e Sets
    public Artista[] getArtistas() {
        return artistas;
    }

    public void setArtistas(Artista... artistas) {
        this.artistas = artistas;
    }

}
