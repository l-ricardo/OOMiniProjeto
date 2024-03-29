package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

/**
 * Classe que simula um banco de dados bem como faz o gerenciamento deles.
 */
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
                artistas.add(new Artista("Lucio Mauro", 'M', "Musico", "Vocal"));
                ((Artista) getPessoa("William Boner")).setAncora(true);
                ((Artista) getPessoa("Renata Vasconcelos")).setAncora(true);

                personagens.add(new Personagem("Carminha", 'F',
                                getPessoa("Adriana Esteves"), true));
                personagens.add(new Personagem("Tufão", 'M',
                                getPessoa("Murilo Benicio")));
                personagens.add(new Personagem("Nina/Rita", 'F',
                                getPessoa("Debora Falabella"), true));
                personagens.add(new Personagem("11", 'F',
                                getPessoa("Millie Bobby Brown"), true));
                personagens.add(new Personagem("Mike", 'M',
                                getPessoa("Finn Wolfhard"), true));
                personagens.add(new Personagem("Will Byers", 'M',
                                getPessoa("Noah Schnapp"), true));
                personagens.add(new Personagem("Lucas Sinclair", 'M',
                                getPessoa("Caleb McLaughlin"), true));
                personagens.add(new Personagem("Dustin Henderson", 'M',
                                getPessoa("Gaten Matarazzo"), true));
                personagens.add(new Personagem("Bob Newby", 'M',
                                getPessoa("Sean Astin"), false));
                personagens.add(new Personagem("Bob Esponja", 'M',
                                getPessoa("Wendell Bezerra"), true));

                pessoas.add(new Pessoa("Dona Maria", 'F'));
                pessoas.add(new Pessoa("Seu João", 'M'));
                pessoas.add(new Pessoa("Adriana Esteves", 'F'));
                pessoas.add(new Pessoa("Murilo Benicio", 'M'));
                pessoas.add( new Pessoa("Debora Falabella", 'F'));
                pessoas.add(new Pessoa("Millie Bobby Brown", 'F'));
                pessoas.add(new Pessoa("Finn Wolfhard", 'M'));
                pessoas.add( new Pessoa("Noah Schnapp", 'M'));
                pessoas.add( new Pessoa("Caleb McLaughlin", 'M'));
                pessoas.add(new Pessoa("Gaten Matarazzo", 'M'));
                pessoas.add(new Pessoa("Sean Astin", 'M'));
                pessoas.add( new Pessoa("Sean Astin", 'M'));
                pessoas.add( new Pessoa("Wendell Bezerra", 'M'));

                programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Avenida Brasil",
                                new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6)), "21:00", 120,
                                new ArrayList<Personagem>(Arrays.asList(
                                                personagens.get(0),
                                                personagens.get(1),
                                                personagens.get(2))),
                                1, 300));
                programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Bagulhos Sinistros",
                                new ArrayList<Integer>(Arrays.asList(7)), "7:00", 60,
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
                                new ArrayList<Integer>(Arrays.asList(6)), "13:00", 210,
                                new ArrayList<Personagem>(Arrays.asList(
                                                personagens.get(0),
                                                personagens.get(3))),
                                0, 1));
                programaTipoNovelaFilmeSerie.add(new NovelaFilmeSerie("Bob Esponja",
                                new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), "10:00", 20,
                                new ArrayList<Personagem>(Arrays.asList(
                                                personagens.get(9))),
                                15, 1200));
                programaTipoNovelaFilmeSerie.get(3).setAnimado(true);

                programaTipoJornal.add(new Jornal("Jornal Nacional",
                                new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6)), "20:00", 60,
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(5),
                                                artistas.get(6))),
                                "Nacional"));

                programaTipoTalkShow.add(new TalkShow("Mais Você",
                                new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6)), "8:00", 90,
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(0),
                                                artistas.get(1)))));
                programaTipoTalkShow.add(new TalkShow("Hora do Faro",
                                new ArrayList<Integer>(Arrays.asList(7)), "15:00", 60,
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(2)))));
                programaTipoTalkShow.get(1).setConvidados(
                                new ArrayList<Pessoa>(Arrays.asList(
                                                pessoas.get(0),
                                                pessoas.get(1))));
                programaTipoTalkShow.add(new TalkShow("Programa do Silvio Santos",
                                new ArrayList<Integer>(Arrays.asList(1)), "16:00", 300,
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(3)))));
                programaTipoTalkShow.add(new TalkShow("Roda Roda Jequiti",
                                new ArrayList<Integer>(Arrays.asList(1)), "5:00", 90,
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(3)))));
                programaTipoTalkShow.add(new TalkShow("Caldeirao",
                                new ArrayList<Integer>(Arrays.asList(7)), "15:00", 240,
                                new ArrayList<Artista>(Arrays.asList(
                                                artistas.get(4)))));
                programaTipoTalkShow.get(4).setMusicos(
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
                canais.add(new Canal("n", 105));
                canais.add(new Canal("n", 106));
        }

        // -------------------------------- Gets e Sets --------------------------------
        public ArrayList<Canal> getCanais() {
                Collections.sort(canais); // Ordena alfabeticamente pelo nome
                return canais;
        }

        public void setCanais(ArrayList<Canal> canais) {
                this.canais = canais;
        }

        public ArrayList<Artista> getArtistas() {
                Collections.sort(artistas); // Ordena alfabeticamente pelo nome
                return artistas;
        }

        public void setArtistas(ArrayList<Artista> artistas) {
                this.artistas = artistas;
        }

        public ArrayList<Personagem> getPersonagens() {
                Collections.sort(personagens); // Ordena alfabeticamente pelo nome
                return personagens;
        }

        public void setPersonagens(ArrayList<Personagem> personagens) {
                this.personagens = personagens;
        }

        public ArrayList<Pessoa> getPessoas() {
                Collections.sort(pessoas); // Ordena alfabeticamente pelo nome
                return pessoas;
        }

        public void setPessoas(ArrayList<Pessoa> pessoas) {
                this.pessoas = pessoas;
        }

        public ArrayList<NovelaFilmeSerie> getProgramaTipoNovelaFilmeSerie() {
                Collections.sort(programaTipoNovelaFilmeSerie); // Ordena alfabeticamente pelo nome
                return programaTipoNovelaFilmeSerie;
        }

        public void setProgramaTipoNovelaFilmeSerie(ArrayList<NovelaFilmeSerie> programaTipoNovelaFilmeSerie) {
                this.programaTipoNovelaFilmeSerie = programaTipoNovelaFilmeSerie;
        }

        public ArrayList<TalkShow> getProgramaTipoTalkShow() {
                Collections.sort(programaTipoTalkShow); // Ordena alfabeticamente pelo nome
                return programaTipoTalkShow;
        }

        public void setProgramaTipoTalkShow(ArrayList<TalkShow> programaTipoTalkShow) {
                this.programaTipoTalkShow = programaTipoTalkShow;
        }

        public ArrayList<Jornal> getProgramaTipoJornal() {
                Collections.sort(programaTipoJornal); // Ordena alfabeticamente pelo nome
                return programaTipoJornal;
        }

        public void setProgramaTipoJornal(ArrayList<Jornal> programaTipoJornal) {
                this.programaTipoJornal = programaTipoJornal;
        }

        // -------------------------- Metodos auxiliares ----------------------------
        /**
         * Junta todos os diferentes tipos de programas em um mesmo array e
         * os coloca em ordem alfabetica.
         * 
         * @return Um ArrayList com todos os programas em ordem alfabetica
         */
        public ArrayList<Programa> getTodosProgramas() {
                ArrayList<Programa> todosProgramas = new ArrayList<Programa>();
                todosProgramas.addAll(programaTipoJornal);
                todosProgramas.addAll(programaTipoNovelaFilmeSerie);
                todosProgramas.addAll(programaTipoTalkShow);
                Collections.sort(todosProgramas); // Ordena alfabeticamente pelo nome
                return todosProgramas;
        }

        /**
         * Junta todos os diferentes tipos de pessoas em um mesmo array e
         * as coloca em ordem alfabetica.
         * 
         * @return Um ArrayList com todas as pessoas em ordem alfabetica
         */
        public ArrayList<Pessoa> getTodasPessoas() {
                ArrayList<Pessoa> todasPessoas = new ArrayList<Pessoa>();
                todasPessoas.addAll(pessoas);
                todasPessoas.addAll(personagens);
                todasPessoas.addAll(artistas);
                Collections.sort(todasPessoas); // Ordena alfabeticamente pelo nome
                return todasPessoas;
        }

        /**
         * Método que retorna uma lista de canais, filtrada por uma string, caso filtro
         * seja null se comporta como um getCanais()
         * 
         * @param filtro string do nome do canal que se esta se buscando
         * @return Retorna um ArrayList de Canais.
         */
        public ArrayList<Canal> getCanais(String filtro) {
                if (filtro != null) {
                        ArrayList<Canal> canaisFiltrados = new ArrayList<>();
                        for (Canal canal : canais) {
                                if (canal.getNome().contains(filtro)) {
                                        canaisFiltrados.add(canal);
                                }
                        }
                        Collections.sort(canaisFiltrados);
                        return canaisFiltrados; // Ordena alfabeticamente pelo nome
                }
                return getCanais();
        }

        /**
         * Sobrecarga do getTodosProgramas(), método que retorna uma lista de programas,
         * filtrada por uma string, caso filtro seja null se comporta como o
         * getTodosProgramas()
         * 
         * @param filtro string do nome do programa que se esta se buscando
         * @return Retorna um ArrayList de Programas.
         */
        public ArrayList<Programa> getTodosProgramas(String filtro) {
                if (filtro != null) {
                        ArrayList<Programa> programasFiltrados = new ArrayList<>();
                        for (Programa programa : getTodosProgramas()) {
                                if (programa.getNome().contains(filtro)) {
                                        programasFiltrados.add(programa);
                                }
                        }
                        Collections.sort(programasFiltrados);
                        return programasFiltrados; // Ordena alfabeticamente pelo nome
                }
                return getTodosProgramas();
        }

        /**
         * Sobrecarga do getTodasPessoas(), método que retorna uma lista de pessoas,
         * filtrada por uma string, caso filtro seja null se comporta como o
         * getTodasPessoas()
         * 
         * @param filtro string do nome da pessoa que se esta se buscando
         * @return Retorna um ArrayList de Pessoas.
         */
        public ArrayList<Pessoa> getTodasPessoas(String filtro) {
                if (filtro != null) {
                        ArrayList<Pessoa> pessoasFiltradas = new ArrayList<>();
                        for (Pessoa pessoa : getTodasPessoas()) {
                                if (pessoa.getNome().contains(filtro)) {
                                        pessoasFiltradas.add(pessoa);
                                }
                        }
                        Collections.sort(pessoasFiltradas);
                        return pessoasFiltradas; // Ordena alfabeticamente pelo nome
                }
                return getTodasPessoas();
        }

        /**
         * Encontra um unico objeto canal no "banco de dados" d, quando seu nome é
         * exatamente igual ao do nome passado como parametro.
         * 
         * @param nome Nome do canal
         * @return O canal cujo nome é o mesmo do parametro nome
         */
        public Canal getCanal(String nome) {
                Canal result = null;
                for (Canal canal : getCanais()) {
                        if (canal.getNome().equals(nome)) {
                                result = canal;
                        }
                }
                return result;
        }

        /**
         * Encontra um unico objeto programa no "banco de dados" d, quando seu nome é
         * exatamente igual ao do nome passado como parametro.
         * 
         * @param nome Nome do programa
         * @return O programa cujo nome é o mesmo do parametro nome
         */
        public Programa getPrograma(String nome) {
                Programa result = null;
                for (Programa programa : getTodosProgramas()) {
                        if (programa.getNome().equals(nome)) {
                                result = programa;
                        }
                }
                return result;
        }

        /**
         * Encontra um unico objeto pessoa no "banco de dados" d, quando seu nome é
         * exatamente igual ao do nome passado como parametro.
         * 
         * @param nome Nome da pessoa
         * @return A pessoa cujo nome é o mesmo do parametro nome
         */
        public Pessoa getPessoa(String nome) {
                Pessoa result = null;
                for (Pessoa pessoa : getTodasPessoas()) {
                        if (pessoa.getNome().equals(nome)) {
                                result = pessoa;
                        }
                }
                return result;
        }

        /**
         * Deleta um canal desse "banco de dados" d, atraves de seu nome.
         * 
         * @param nome Nome do canal
         */
        public void deletarCanal(String nome) {
                for (Canal canal : getCanais()) {
                        if (canal.getNome().equals(nome)) {
                                getCanais().remove(canal);
                                return;
                        }
                }
        }

        /**
         * Deleta um programa desse "banco de dados" d, atraves de seu nome.
         * 
         * @param nome Nome do programa
         */
        public void deletarPrograma(String nome) {
                for (Programa programa : getTodosProgramas()) {
                        if (programa.getNome().equals(nome)) {
                                if (programa instanceof NovelaFilmeSerie) {
                                        getProgramaTipoNovelaFilmeSerie().remove(programa);
                                        return;
                                }
                                if (programa instanceof TalkShow) {
                                        getProgramaTipoTalkShow().remove(programa);
                                        return;
                                }
                                if (programa instanceof Jornal) {
                                        getProgramaTipoJornal().remove(programa);
                                        return;
                                }
                        }
                }
        }

        /**
         * Deleta uma pessoa desse "banco de dados" d, atraves de seu nome.
         * 
         * @param nome Nome da pessoa
         */
        public void deletarPessoa(String nome) {
                for (Pessoa pessoa : getTodasPessoas()) {
                        if (pessoa.getNome().equals(nome)) {
                                if (pessoa instanceof Artista) {
                                        getArtistas().remove(pessoa);
                                        return;
                                }
                                if (pessoa instanceof Personagem) {
                                        getPersonagens().remove(pessoa);
                                        return;
                                }
                                if (pessoa instanceof Pessoa) {
                                        getPessoas().remove(pessoa);
                                        return;
                                }
                        }
                }
        }

        /**
         * Seleciona entre os artistas apenas aqueles que são musicos e os retona.
         * 
         * @return Retorna array com artistas que são musicos
         */
        public ArrayList<Artista> getMusicos() {
                ArrayList<Artista> musicos = new ArrayList<>();
                for (Artista artista : artistas) {
                        if (artista.isMusico()) {
                                musicos.add(artista);
                        }
                }
                return musicos;
        }

        /**
         * Seleciona entre os artistas apenas aqueles que são ancoras e os retona.
         * 
         * @return Retorna array com artistas que são ancoras
         */
        public ArrayList<Artista> getAncoras() {
                ArrayList<Artista> ancoras = new ArrayList<>();
                for (Artista artista : artistas) {
                        if (artista.isAncora()) {
                                ancoras.add(artista);
                        }
                }
                return ancoras;
        }
}