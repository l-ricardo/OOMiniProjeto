package model;

import java.util.ArrayList;

/**
 * Uma classe que estende programa e que pode representar qualquer tipo de
 * Novela, Serie, Filme ou obra de ficção, que sera composta por pessoas
 * ficticias.
 */
public class NovelaFilmeSerie extends Programa {

    private ArrayList<Personagem> personagens = new ArrayList<>();
    private boolean animado;
    private int nTemporadas;
    private int nTotalEpisodios;
    {
        animado = false;
    }

    /**
     * Construtor que recebe o nome de uma obra de ficção, os dias da semana que a
     * obra é transmitida, o horário de exibição, a duração da cada episódio, a
     * classificação indicativa, os personagens que aparecem, o numero de
     * temporadas, e o numero de episódios.
     * 
     * @param nome                    Nome da obra de ficção
     * @param dias                    ArrayList de inteiros que representa os dias
     *                                da semana que a obra de ficção é transmitido
     *                                (1 para Domingo até 7 para Sábado)
     * @param horario                 Horário de exibição da obra de ficção
     * @param duracaoMin              Duração da obra de cada episódio em minutos
     * @param classificacaoIndicativa Classificação indicativa da obra de ficção (0
     *                                para classificacao livre)
     * @param personagens             ArrayList de pessoas ficticias (Personagens)
     *                                que fazem parte de tal obra
     * @param nTemporadas             Numero de temporadas que tem a obra, 0 caso
     *                                seja filme e 1 caso seja novela
     * @param nTotalEpisodios         Numero de episódios que tem a obra, caso tenha
     *                                mais de uma temporada esse numero representa a
     *                                soma de episódios que teve em cada temporada
     * 
     */
    public NovelaFilmeSerie(String nome, ArrayList<Integer> dias, String horario,
            int duracaoMin, int classificacaoIndicativa, ArrayList<Personagem> personagens,
            int nTemporadas, int nTotalEpisodios) {
        super(nome, dias, horario, duracaoMin, classificacaoIndicativa);
        this.personagens = personagens;
        this.nTemporadas = nTemporadas;
        this.nTotalEpisodios = nTotalEpisodios;
    }

    // Outros métodos
    public void listarPersonagens() {
        listarPersonagens(false);
    }

    public void listarPersonagens(boolean apenasProtagonistas) {
        String result = "";
        for (Personagem personagem : personagens) {
            if (apenasProtagonistas) {
                result += personagem.isProtagonista() ? personagem.toString() + "\n" : "";
            } else {
                result += personagem.toString() + "\n";
            }
        }
        System.out.println(result);
    }

    // Gets e Sets
    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(ArrayList<Personagem> personagens) {
        this.personagens = personagens;
    }

    public boolean isAnimado() {
        return animado;
    }

    public void setAnimado(boolean animado) {
        this.animado = animado;
    }

    public int getnTemporadas() {
        return nTemporadas;
    }

    public void setnTemporadas(int nTemporadas) {
        this.nTemporadas = nTemporadas;
    }

    public int getnTotalEpisodios() {
        return nTotalEpisodios;
    }

    public void setnTotalEpisodios(int nTotalEpisodios) {
        this.nTotalEpisodios = nTotalEpisodios;
    }

    @Override
    public String toString() {
        // String result = "========================================\n"
        // + getNome() + " (" + getClassificacaoIndicativa() + ")\n"
        // + nTotalEpisodios + " episódios divididos em " + nTemporadas + "
        // temporadas\n"
        // + getDescricao() + "\n"
        // + "--------------- Horários ----------------\n";
        // for (Horario horario : getHorarios()) {
        // result += horario.toString() + "\n";
        // }
        // result += "-------------- Estrelando ---------------\n";
        // for (Personagem personagem : personagens) {
        // result += personagem.toString() + "\n";
        // }
        // result += "========================================";
        // if (isFavorito()) {
        // result = result.replace('=', '*');
        // }
        String result = getNome();
        return result;
    }
}
