package models;

import java.util.ArrayList;
import java.util.Arrays;

public class Dados {
    private ArrayList<Canal> canais = new ArrayList<>();
    private ArrayList<Horario> horarios = new ArrayList<>();
    private ArrayList<Artista> artistas = new ArrayList<>();
    private ArrayList<Personagem> personagens = new ArrayList<>();
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    private ArrayList<NovelaFilmeSerie> programaTipoNovelaFilmeSerie = new ArrayList<>();
    private ArrayList<NovelaFilmeSerie> programaTipoTalkShow = new ArrayList<>();
    private ArrayList<Jornal> programaTipoJornal = new ArrayList<>();

    // Criando valores de exemplo
    {
        for (int i = 0; i < 24; i++) {
            horarios.add(new Horario(i, i + 1, "Domingo"));
        }
        for (int i = 24; i < 48; i++) {
            horarios.add(new Horario(i - 24, i - 24 + 1, "Segunda"));
        }
        for (int i = 48; i < 72; i++) {
            horarios.add(new Horario(i - 48, i - 48 + 1, "Terça"));
        }
        for (int i = 72; i < 96; i++) {
            horarios.add(new Horario(i - 72, i - 72 + 1, "Quarta"));
        }
        for (int i = 96; i < 120; i++) {
            horarios.add(new Horario(i - 96, i - 96 + 1, "Quinta"));
        }
        for (int i = 120; i < 144; i++) {
            horarios.add(new Horario(i - 120, i - 120 + 1, "Sexta"));
        }
        for (int i = 144; i < 168; i++) {
            horarios.add(new Horario(i - 144, i - 144 + 1, "Sabado"));
        }

        artistas.add(new Artista("Ana Maria Braga", 'F', "Apresentadora"));
        artistas.add(new Artista("Louro Mané", 'M', "Humorista"));
        artistas.add(new Artista("Rodrigo Faro", 'M', "Apresentador"));
        artistas.add(new Artista("Silvio Santos", 'M', "Apresentador"));
        artistas.add(new Artista("Marcos Mion", 'M', "Apresentador"));
        artistas.add(new Artista("William Boner", 'M', "Jornalista"));
        artistas.add(new Artista("Renata Vasconcelos", 'F', "Jornalista"));
        artistas.add(new Artista("Lucio Mauro", 'M', "Musico", true, "Vocal e guitarra"));

        personagens.add(new Personagem("Carminha", 'F', new Pessoa("Adriana Esteves", 'F'), true));
        personagens.add(new Personagem("Tufão", 'M', new Pessoa("Murilo Benicio", 'M')));
        personagens.add(new Personagem("Nina/Rita", 'F', new Pessoa("Debora Falabella", 'F'), true));

        pessoas.add(new Pessoa("Dona Maria", 'F'));
        pessoas.add(new Pessoa("Seu João", 'M'));

        // TODO: Corrigir constrututores de programas
        programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Avenida Brasil",
                new ArrayList<Horario>(Arrays.asList(horarios.get(7), horarios.get(14),
                        horarios.get(31), horarios.get(50))),
                16, new ArrayList<Personagem>(Arrays.asList(personagens.get(0), personagens.get(1),
                        personagens.get(2))),
                1, 300));
        programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Avenida Brasil",
                new ArrayList<Horario>(Arrays.asList(horarios.get(7), horarios.get(14),
                        horarios.get(31), horarios.get(50))),
                16, new ArrayList<Personagem>(Arrays.asList(personagens.get(0), personagens.get(1),
                        personagens.get(2))),
                1, 300));
        programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Avenida Brasil",
                new ArrayList<Horario>(Arrays.asList(horarios.get(7), horarios.get(14),
                        horarios.get(31), horarios.get(50))),
                16, new ArrayList<Personagem>(Arrays.asList(personagens.get(0), personagens.get(1),
                        personagens.get(2))),
                1, 300));
        programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Avenida Brasil",
                new ArrayList<Horario>(Arrays.asList(horarios.get(7), horarios.get(14),
                        horarios.get(31), horarios.get(50))),
                16, new ArrayList<Personagem>(Arrays.asList(personagens.get(0), personagens.get(1),
                        personagens.get(2))),
                1, 300));
        programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Avenida Brasil",
                new ArrayList<Horario>(Arrays.asList(horarios.get(7), horarios.get(14),
                        horarios.get(31), horarios.get(50))),
                16, new ArrayList<Personagem>(Arrays.asList(personagens.get(0), personagens.get(1),
                        personagens.get(2))),
                1, 300));
        programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Avenida Brasil",
                new ArrayList<Horario>(Arrays.asList(horarios.get(7), horarios.get(14),
                        horarios.get(31), horarios.get(50))),
                16, new ArrayList<Personagem>(Arrays.asList(personagens.get(0), personagens.get(1),
                        personagens.get(2))),
                1, 300));

        // programaTipoTalkShow.add(new TalkShow("Mais Você",new
        // ArrayList<Horario>(Arrays.asList(horarios.get(2), horarios.get(10),
        // horarios.get(40), horarios.get(50))),0));

        // programaTipoTalkShow.add(new TalkShow("Hora do Faro",new
        // ArrayList<Horario>(Arrays.asList(horarios.get(25), horarios.get(44),
        // horarios.get(26), horarios.get(47))),12, new ArrayList<Artista>(Arrays.asList
        // (artistas.get(2)))));

        // programaTipoTalkShow.add(new TalkShow("Programa do Silvio Santos",new
        // ArrayList<Horario>(Arrays.asList(horarios.get(69), horarios.get(57),
        // horarios.get(4), horarios.get(7))),12, new ArrayList<Artista>(Arrays.asList
        // (artistas.get(3)))));

        // programaTipoTalkShow.add(new TalkShow("Roda Roda Jequiti",new
        // ArrayList<Horario>(Arrays.asList(horarios.get(30), horarios.get(71),
        // horarios.get(58), horarios.get(75))),12, new ArrayList<Artista>(Arrays.asList
        // (artistas.get(3)))));

        // programaTipoTalkShow.add(new TalkShow("Caldeirao",new
        // ArrayList<Horario>(Arrays.asList(horarios.get(78), horarios.get(1),
        // horarios.get(95), horarios.get(25))),12, new ArrayList<Artista>(Arrays.asList
        // ( artistas.get(4) )),new ArrayList<Artista>(Arrays.asList ( artistas.get(8)
        // )), new ArrayList<Pessoa>(Arrays.asList ( pessoas.get(0), pessoas.get(1)
        // ))));

        // programaTipoJornal.add(new Jornal("Jornal Nacional",
        // new ArrayList<Horario>(Arrays.asList( horarios.get(0), horarios.get(24),
        // horarios.get(34), horarios.get(48))), 0,
        // new ArrayList<Artista>(Arrays.asList (artistas.get(5), artistas.get(6))),
        // "Nacional"));

        canais.add(new Canal("Globo", 8
        // ,
        // programaTipoNovelaFilmeSerie.get(0),
        // programaTipoJornal.get(0),
        // programaTipoTalkShow.get(0),
        // programaTipoTalkShow.get(4)
        ));
        canais.add(new Canal("Record", 10
        // ,
        // programaTipoTalkShow.get(1)
        ));
        canais.add(new Canal("SBT", 2
        // ,
        // programaTipoTalkShow.get(2),
        // programaTipoTalkShow.get(3)
        ));
        canais.add(new Canal("a", 8));
        canais.add(new Canal("b", 8));
        canais.add(new Canal("c", 8));
        canais.add(new Canal("d", 8));
        canais.add(new Canal("e", 8));
        canais.add(new Canal("f", 8));
        canais.add(new Canal("g", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
        canais.add(new Canal("h", 8));
    }

    // Gets e sets
    public ArrayList<Canal> getCanais() {
        return canais;
    }

    // retorna um canal especifico
    public Canal getCanal(int indice) {
        return canais.get(indice);
    }

    public void setCanais(ArrayList<Canal> canais) {
        this.canais = canais;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(ArrayList<Personagem> personagens) {
        this.personagens = personagens;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public ArrayList<NovelaFilmeSerie> getProgramaTipoNovelaFilmeSerie() {
        return programaTipoNovelaFilmeSerie;
    }

    public void setProgramaTipoNovelaFilmeSerie(ArrayList<NovelaFilmeSerie> programaTipoNovelaFilmeSerie) {
        this.programaTipoNovelaFilmeSerie = programaTipoNovelaFilmeSerie;
    }

    public ArrayList<NovelaFilmeSerie> getProgramaTipoTalkShow() {
        return programaTipoTalkShow;
    }

    public void setProgramaTipoTalkShow(ArrayList<NovelaFilmeSerie> programaTipoTalkShow) {
        this.programaTipoTalkShow = programaTipoTalkShow;
    }

    public ArrayList<Jornal> getProgramaTipoJornal() {
        return programaTipoJornal;
    }

    public void setProgramaTipoJornal(ArrayList<Jornal> programaTipoJornal) {
        this.programaTipoJornal = programaTipoJornal;
    }

}
