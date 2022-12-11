package modelos;

public class Dados { // Doubt? Preciso de declarar o tamanho dos Arrays aqui?
    private Canal[] canais = new Canal[10];
    private Horario[] horarios = new Horario[24 * 7 + 100];
    private Artista[] artistas = new Artista[50];
    private Personagem[] personagens = new Personagem[50];
    private Pessoa[] pessoas = new Pessoa[20];
    private NovelaFilmeSerie[] programaTipoNovelaFilmeSerie = new NovelaFilmeSerie[50];
    private TalkShow[] programaTipoTalkShow = new TalkShow[30];
    private Jornal[] programaTipoJornal = new Jornal[30];

    // Criando valores de exemplo
    {
        for (int i = 0; i < 24; i++) {
            horarios[i] = new Horario(i, i + 1, "Domingo");
        }
        for (int i = 24; i < 48; i++) {
            horarios[i] = new Horario(i - 24, i - 24 + 1, "Segunda");
        }
        for (int i = 48; i < 72; i++) {
            horarios[i] = new Horario(i - 48, i - 48 + 1, "Terça");
        }
        for (int i = 72; i < 96; i++) {
            horarios[i] = new Horario(i - 72, i - 72 + 1, "Quarta");
        }
        for (int i = 96; i < 120; i++) {
            horarios[i] = new Horario(i - 96, i - 96 + 1, "Quinta");
        }
        for (int i = 120; i < 144; i++) {
            horarios[i] = new Horario(i - 120, i - 120 + 1, "Sexta");
        }
        for (int i = 144; i < 168; i++) {
            horarios[i] = new Horario(i - 144, i - 144 + 1, "Sabado");
        }

        artistas[0] = new Artista("Ana Maria Braga", 'F', "Apresentadora");
        artistas[1] = new Artista("Louro Mané", 'M', "Humorista");
        artistas[2] = new Artista("Rodrigo Faro", 'M', "Apresentador");
        artistas[3] = new Artista("Silvio Santos", 'M', "Apresentador");
        artistas[4] = new Artista("Marcos Mion", 'M', "Apresentador");
        artistas[5] = new Artista("William Boner", 'M', "Jornalista");
        artistas[6] = new Artista("Renata Vasconcelos", 'F', "Jornalista");
        // artistas[7] = new Artista("Eliana Marques", 'F', "Garota do tempo");
        artistas[8] = new Artista("Lucio Mauro", 'M', "Musico", true, "Vocal e guitarra");

        personagens[0] = new Personagem("Carminha", 'F', new Pessoa("Adriana Esteves", 'F'));
        personagens[1] = new Personagem("Tufão", 'M', new Pessoa("Murilo Benicio", 'M'));
        personagens[2] = new Personagem("Nina/Rita", 'F', new Pessoa("Debora Falabella", 'F'));

        pessoas[0] = new Pessoa("Dona Maria", 'F');
        pessoas[1] = new Pessoa("Seu João", 'M');

        programaTipoNovelaFilmeSerie[0] = new NovelaFilmeSerie("Avenida Brasil",
                new Horario[] { horarios[7], horarios[14], horarios[31], horarios[50] }, 16,
                new Personagem[] { personagens[0], personagens[1], personagens[2] }, 1, 300);

        programaTipoTalkShow[0] = new TalkShow("Mais Você",
                new Horario[] { horarios[2], horarios[10], horarios[40], horarios[50] }, 0);
        programaTipoTalkShow[1] = new TalkShow("Hora do Faro", null, 12, artistas[2]);
        programaTipoTalkShow[2] = new TalkShow("Programa do Silvio Santos", null, 12, artistas[3]);
        programaTipoTalkShow[3] = new TalkShow("Roda Roda Jequiti", null, 12, artistas[3]);
        programaTipoTalkShow[4] = new TalkShow("Caldeirao", null, 12, new Artista[] { artistas[4] },
                new Artista[] { artistas[8] }, new Pessoa[] { pessoas[0], pessoas[1] });

        programaTipoTalkShow[0].setApresentadores(artistas[0],artistas[1]);
        programaTipoTalkShow[1].setHorarios( horarios[25], horarios[44], horarios[26], horarios[47]);
        programaTipoTalkShow[2].setHorarios( horarios[69], horarios[57], horarios[4], horarios[7]);
        programaTipoTalkShow[3].setHorarios( horarios[30], horarios[71], horarios[58], horarios[75]);
        programaTipoTalkShow[4].setHorarios( horarios[78], horarios[1], horarios[95], horarios[25]);

        programaTipoJornal[0] = new Jornal("Jornal Nacional",
                new Horario[] { horarios[0], horarios[24], horarios[34], horarios[48] }, 0,
                new Artista[] { artistas[5], artistas[6] }, "Nacional");

        canais[0] = new Canal("Globo", 8);
        canais[1] = new Canal("Record", 10);
        canais[2] = new Canal("SBT", 2, programaTipoTalkShow[2], programaTipoTalkShow[3]);

        canais[0].setProgramas(programaTipoNovelaFilmeSerie[0], programaTipoJornal[0], programaTipoTalkShow[0],
                programaTipoTalkShow[4]);
        canais[1].setProgramas(programaTipoTalkShow[1]);

    }

    public Canal[] getCanais() {
        return canais;
    }

    public void setCanais(Canal[] canais) {
        this.canais = canais;
    }

    public Horario[] getHorarios() {
        return horarios;
    }

    public void setHorarios(Horario[] horarios) {
        this.horarios = horarios;
    }

    public Artista[] getArtistas() {
        return artistas;
    }

    public void setArtistas(Artista[] artistas) {
        this.artistas = artistas;
    }

    public Personagem[] getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Personagem[] personagens) {
        this.personagens = personagens;
    }

    public Pessoa[] getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoa[] pessoas) {
        this.pessoas = pessoas;
    }

    public NovelaFilmeSerie[] getProgramaTipoNovelaFilmeSerie() {
        return programaTipoNovelaFilmeSerie;
    }

    public void setProgramaTipoNovelaFilmeSerie(NovelaFilmeSerie[] programaTipoNovelaFilmeSerie) {
        this.programaTipoNovelaFilmeSerie = programaTipoNovelaFilmeSerie;
    }

    public TalkShow[] getProgramaTipoTalkShow() {
        return programaTipoTalkShow;
    }

    public void setProgramaTipoTalkShow(TalkShow[] programaTipoTalkShow) {
        this.programaTipoTalkShow = programaTipoTalkShow;
    }

    public Jornal[] getProgramaTipoJornal() {
        return programaTipoJornal;
    }

    public void setProgramaTipoJornal(Jornal[] programaTipoJornal) {
        this.programaTipoJornal = programaTipoJornal;
    }

}