package model;

import java.util.ArrayList;

/**
 * Uma classe que estende programa e que pode representar qualquer tipo de
 * TalkShow, programa de entreterimento ou auditorio onde se tem opcionalmente
 * mas não obrigatorimente pessoas o fazendo como apresentadores, musicos e
 * convidados.
 */
public class TalkShow extends Programa {
    private ArrayList<Artista> apresentadores = new ArrayList<>();
    private ArrayList<Artista> musicos = new ArrayList<>();
    private ArrayList<Pessoa> convidados = new ArrayList<>();

    /**
     * Construtor que recebe o nome de um TalkShow, os dias da semana que o TalkShow
     * é transmitido, o horário de exibição, a duração do TalkShow e a classificação
     * indicativa.
     * 
     * @param nome                    Nome do TalkShow
     * @param dias                    ArrayList de inteiros que representa os dias
     *                                da semana que o TalkShow é transmitido (1 para
     *                                Domingo até 7 para Sábado.)
     * @param horario                 Horário de exibição do TalkShow
     * @param duracaoMin              Duração do TalkShow em minutos
     * @param classificacaoIndicativa Classificação indicativa do TalkShow (0 para
     *                                classificacao livre)
     */
    public TalkShow(String nome, ArrayList<Integer> dias, String horario,
            int duracaoMin, int classificacaoIndicativa) {
        super(nome, dias, horario, duracaoMin, classificacaoIndicativa);
    }

    /**
     * Construtor que recebe o nome de um TalkShow, os dias da semana que o TalkShow
     * é transmitido, o horário de exibição, a duração do TalkShow, a classificação
     * indicativa e os apresentadores.
     * 
     * @param nome                    Nome do TalkShow
     * @param dias                    ArrayList de inteiros que representa os dias
     *                                da semana que o TalkShow é transmitido (1 para
     *                                Domingo até 7 para Sábado.)
     * @param horario                 Horário de exibição do TalkShow
     * @param duracaoMin              Duração do TalkShow em minutos
     * @param classificacaoIndicativa Classificação indicativa do TalkShow (0 para
     *                                classificacao livre)
     * @param apresentadores          ArrayList de Artistas que representam os
     *                                apresentadores do TalkShow
     */
    public TalkShow(String nome, ArrayList<Integer> dias, String horario, int duracaoMin,
            int classificacaoIndicativa, ArrayList<Artista> apresentadores) {
        super(nome, dias, horario, duracaoMin, classificacaoIndicativa);
        this.apresentadores = apresentadores;
    }

    // Outros metodos //TODO: Ajustar arrays abaixos se necessario
    public void adicionarApresentador(Artista... apresentadores) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerApresentador(String apresentadorNome) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void adicionarMusico(Artista... musicos) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerMusico(String musicoNome) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void adicionarConvidado(Pessoa... convidados) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerConvidado(String convidadoNome) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    // Gets e Sets
    public ArrayList<Artista> getApresentadores() {
        return apresentadores;
    }

    public void setApresentadores(ArrayList<Artista> apresentadores) {
        this.apresentadores = apresentadores;
    }

    public ArrayList<Artista> getMusicos() {
        return musicos;
    }

    public void setMusicos(ArrayList<Artista> musicos) {
        this.musicos = musicos;
    }

    public ArrayList<Pessoa> getConvidados() {
        return convidados;
    }

    public void setConvidados(ArrayList<Pessoa> convidados) {
        this.convidados = convidados;
    }

    @Override
    public String toString() {
        // String result = "========================================\n"
        // + getNome() + " (" + getClassificacaoIndicativa() + ")\n"
        // + getDescricao() + "\n"
        // + "--------------- Horários ----------------\n";
        // for (Horario horario : getHorarios()) {
        // result += horario.toString() + "\n";
        // }
        // result += "------------ Apresentadores -------------\n";
        // for (Artista apresentador : apresentadores) {
        // result += apresentador.toString() + "\n";
        // }
        // if (musicos != null) {
        // result += "--------------- Musicos ----------------\n";
        // for (Artista musico : musicos) {
        // result += musico.toString() + "\n";
        // }
        // }
        // if (convidados != null) {
        // result += "-------------- Convidados ---------------\n";
        // for (Pessoa convidado : convidados) {
        // result += convidado.toString() + "\n";
        // }
        // }
        // result += "========================================";
        // if (isFavorito()) {
        // result = result.replace('=', '*');
        // }
        String result = getNome();
        return result;
    }
}
