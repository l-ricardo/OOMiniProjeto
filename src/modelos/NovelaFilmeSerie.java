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
        return result;
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

    // Outros métodos
    public void listarPersonagens(boolean apenasProtagonistas) { // ToDo: Testar esse metodo
        String result = "";
        for (Personagem personagem : personagens) {
            if (apenasProtagonistas) {
                result += personagem.isProtagonista() ? personagem.toString() : "";
            } else {
                result += personagem.toString();
            }
        }
        System.out.println(result);
    }
}
