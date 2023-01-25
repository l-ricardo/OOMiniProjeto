package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Dados {
        private ArrayList<Canal> canais = new ArrayList<>();
        private ArrayList<Artista> artistas = new ArrayList<>();
        private ArrayList<Personagem> personagens = new ArrayList<>();
        private ArrayList<Pessoa> pessoas = new ArrayList<>();
        private ArrayList<NovelaFilmeSerie> programaTipoNovelaFilmeSerie = new ArrayList<>();
        private ArrayList<TalkShow> programaTipoTalkShow = new ArrayList<>();
        private ArrayList<Jornal> programaTipoJornal = new ArrayList<>();

        // Criando valores de exemplo
        {
                artistas.add(new Artista("Ana Maria Braga", 'F', "Apresentadora"));
                artistas.add(new Artista("Louro Mané", 'M', "Humorista"));
                artistas.add(new Artista("Rodrigo Faro", 'M', "Apresentador"));
                artistas.add(new Artista("Silvio Santos", 'M', "Apresentador"));
                artistas.add(new Artista("Marcos Mion", 'M', "Apresentador"));
                artistas.add(new Artista("William Boner", 'M', "Jornalista"));
                artistas.add(new Artista("Renata Vasconcelos", 'F', "Jornalista"));
                artistas.add(new Artista("Lucio Mauro", 'M', "Musico", "Vocal e guitarra"));

                personagens.add(new Personagem("Carminha", 'F',
                                new Pessoa("Adriana Esteves", 'F'), true));
                personagens.add(new Personagem("Tufão", 'M',
                                new Pessoa("Murilo Benicio", 'M')));
                personagens.add(new Personagem("Nina/Rita", 'F',
                                new Pessoa("Debora Falabella", 'F'), true));
                personagens.add(new Personagem("11", 'F',
                                new Pessoa("Millie Bobby Brown", 'F'), true));
                personagens.add(new Personagem("Mike", 'M',
                                new Pessoa("Finn Wolfhard", 'M'), true));
                personagens.add(new Personagem("Will Byers", 'M',
                                new Pessoa("Noah Schnapp", 'M'), true));
                personagens.add(new Personagem("Lucas Sinclair", 'M',
                                new Pessoa("Caleb McLaughlin", 'M'), true));
                personagens.add(new Personagem("Dustin Henderson", 'M',
                                new Pessoa("Gaten Matarazzo", 'M'), true));
                personagens.add(new Personagem("Bob Newby", 'M',
                                new Pessoa("Sean Astin", 'M'), false));
                personagens.add(new Personagem("Bob Esponja", 'M',
                                new Pessoa("Wendell Bezerra", 'M'), true));

                pessoas.add(new Pessoa("Dona Maria", 'F'));
                pessoas.add(new Pessoa("Seu João", 'M'));

                programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Avenida Brasil",
                                new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6)), "21:00", 120, 16,
                                new ArrayList<Personagem>(Arrays.asList(
                                                personagens.get(0),
                                                personagens.get(1),
                                                personagens.get(2))),
                                1, 300));
                programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Bagulhos Sinistros",
                                new ArrayList<Integer>(Arrays.asList(7)), "7:00", 60, 12,
                                new ArrayList<Personagem>(Arrays.asList(
                                                personagens.get(3),
                                                personagens.get(4),
                                                personagens.get(5),
                                                personagens.get(6),
                                                personagens.get(7),
                                                personagens.get(8))),
                                4, 32));
                programaTipoNovelaFilmeSerie.get(1).setFavorito(true);
                programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Vingadores",
                                new ArrayList<Integer>(Arrays.asList(6)), "13:00", 210, 14,
                                new ArrayList<Personagem>(Arrays.asList(
                                                personagens.get(0),
                                                personagens.get(3))),
                                0, 1));
                programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Bob Esponja",
                                new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), "10:00", 20, 0,
                                new ArrayList<Personagem>(Arrays.asList(
                                                personagens.get(9))),
                                15, 1200));
                programaTipoNovelaFilmeSerie.get(3).setAnimado(true);

                programaTipoJornal.add(new Jornal("Jornal Nacional",
                                new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6)), "20:00", 60, 0,
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(5),
                                                artistas.get(6))),
                                "Nacional"));

                programaTipoTalkShow.add(new TalkShow("Mais Você",
                                new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6)), "8:00", 90, 0,
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(0),
                                                artistas.get(1)))));
                programaTipoTalkShow.add(new TalkShow("Hora do Faro",
                                new ArrayList<Integer>(Arrays.asList(7)), "15:00", 60, 10,
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(2)))));
                programaTipoTalkShow.get(1).setConvidados(
                                new ArrayList<Pessoa>(Arrays.asList(
                                                pessoas.get(0),
                                                pessoas.get(1))));
                programaTipoTalkShow.add(new TalkShow("Programa do Silvio Santos",
                                new ArrayList<Integer>(Arrays.asList(1)), "16:00", 300, 0,
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(3)))));
                programaTipoTalkShow.add(new TalkShow("Roda Roda Jequiti",
                                new ArrayList<Integer>(Arrays.asList(1)), "5:00", 90, 0,
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(3)))));
                programaTipoTalkShow.add(new TalkShow("Caldeirao",
                                new ArrayList<Integer>(Arrays.asList(7)), "15:00", 240, 0,
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(4)))));
                programaTipoTalkShow.get(4).setBanda(
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(7))));

                canais.add(new Canal("Globo", 8,
                                new ArrayList<Programa>(Arrays.asList(
                                                programaTipoNovelaFilmeSerie.get(0),
                                                programaTipoNovelaFilmeSerie.get(2),
                                                programaTipoJornal.get(0),
                                                programaTipoTalkShow.get(0),
                                                programaTipoTalkShow.get(4)))));
                canais.add(new Canal("Record", 10,
                                new ArrayList<Programa>(Arrays.asList(
                                                programaTipoNovelaFilmeSerie.get(3),
                                                programaTipoTalkShow.get(1)))));
                canais.add(new Canal("SBT", 2,
                                new ArrayList<Programa>(Arrays.asList(
                                                programaTipoNovelaFilmeSerie.get(1),
                                                programaTipoTalkShow.get(2),
                                                programaTipoTalkShow.get(3)))));
                canais.add(new Canal("a", 91));
                canais.add(new Canal("b", 92));
                canais.add(new Canal("c", 93));
                canais.add(new Canal("d", 94));
                canais.add(new Canal("e", 95));
                canais.add(new Canal("f", 96));
                canais.add(new Canal("g", 97));
                canais.add(new Canal("h", 98));
                canais.add(new Canal("i", 99));
                canais.add(new Canal("j", 100));
                canais.add(new Canal("k", 101));
                canais.add(new Canal("l", 102));
                canais.add(new Canal("m", 103));
                canais.add(new Canal("n", 104));
        }

        // Gets e sets
        public ArrayList<Canal> getCanais() {
                return canais;
        }

        public void setCanais(ArrayList<Canal> canais) {
                this.canais = canais;
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

        public ArrayList<TalkShow> getProgramaTipoTalkShow() {
                return programaTipoTalkShow;
        }

        public void setProgramaTipoTalkShow(ArrayList<TalkShow> programaTipoTalkShow) {
                this.programaTipoTalkShow = programaTipoTalkShow;
        }

        public ArrayList<Jornal> getProgramaTipoJornal() {
                return programaTipoJornal;
        }

        public void setProgramaTipoJornal(ArrayList<Jornal> programaTipoJornal) {
                this.programaTipoJornal = programaTipoJornal;
        }

        // -------------------------- Metodos auxiliares ----------------------------
        /**
         * Encontra um objeto programa no "banco de dados" d, atraves de seu nome
         * 
         * @param nome Nome do programa
         * @return O programa cujo nome é o mesmo do parametro nome
         */
        public Programa acharPrograma(String nome) {
                Programa result = null;
                for (Programa programa : programaTipoTalkShow) {
                        if (nome == programa.getNome()) {
                                result = programa;
                        }
                }
                for (Programa programa : programaTipoJornal) {
                        if (nome == programa.getNome()) {
                                result = programa;
                        }
                }
                for (Programa programa : programaTipoNovelaFilmeSerie) {
                        if (nome == programa.getNome()) {
                                result = programa;
                        }
                }
                return result;
        }

        /**
         * Encontra um objeto canal no "banco de dados" d, atraves de seu nome
         * 
         * @param nome Nome do canal
         * @return O canal cujo nome é o mesmo do parametro nome
         */
        public Canal acharCanal(String nome) {
                Canal result = null;
                for (Canal canal : canais) {
                        if (nome == canal.getNome()) {
                                result = canal;
                        }
                }
                return result;
        }

        /**
         * Deleta um canal desse "banco de dados" d, atraves de seu nome
         * 
         * @param nome Nome do canal
         */
        public void deletarCanal(String nome) {
                for (Canal canal : canais) {
                        if (canal.getNome() == nome) {
                                canais.remove(canal);
                                return;
                        }
                }
        }
}
