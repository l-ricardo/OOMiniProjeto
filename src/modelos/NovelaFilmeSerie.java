package modelos;

public class NovelaFilmeSerie extends Programa {
    private Personagem[] personagens;
    private boolean animado;
    private int nTemporadas;
    private int nTotalEpisodios;
    {
        animado = false;
    }

    // Construtores
    public NovelaFilmeSerie(String nome, Horario[] horarios, int classificacaoIndicativa, Personagem[] personagens,
            int nTemporadas, int nTotalEpisodios) {
        super(nome, horarios, classificacaoIndicativa);
        this.personagens = personagens;
        this.nTemporadas = nTemporadas;
        this.nTotalEpisodios = nTotalEpisodios;
    }

    public NovelaFilmeSerie(String nome, Horario[] horarios, int classificacaoIndicativa, String descricao,
            Personagem[] personagens, int nTemporadas, int nTotalEpisodios) {
        this(nome, horarios, classificacaoIndicativa, personagens, nTemporadas, nTotalEpisodios);
        setDescricao(descricao);
    }

    @Override
    public String toString() {
        String result = "========================================\n"
                + getNome() + " (" + getClassificacaoIndicativa() + ")\n"
                + nTotalEpisodios + " episódios divididos em " + nTemporadas + " temporadas\n"
                + getDescricao() + "\n"
                + "--------------- Horários ----------------\n";
        for (Horario horario : getHorarios()) {
            result += horario.toString() + "\n";
        }
        result += "-------------- Estrelando ---------------\n";
        for (Personagem personagem : personagens) {
            result += personagem.toString() + "\n";
        }
        result += "========================================";
        if (isFavorito()) {
            result = result.replace('=', '*');
        }
        return result;
    }

    // Outros métodos
    public void listarPersonagens() {
        listarPersonagens(false);
    }

    public void listarPersonagens(boolean apenasProtagonistas) {
        String result = "";
        for (Personagem personagem : personagens) {
            if (apenasProtagonistas) {
                result += personagem.isProtagonista() ? personagem.toString()+"\n" : "";
            } else {
                result += personagem.toString()+"\n";
            }
        }
        System.out.println(result);
    }

    // Gets e Sets
    public Personagem[] getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Personagem... personagens) {
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

}
