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
     * é transmitido, o horário de exibição, a duração do TalkShow.
     * 
     * @param nome       Nome do TalkShow
     * @param dias       ArrayList de inteiros que representa os dias
     *                   da semana que o TalkShow é transmitido (1 para
     *                   Domingo até 7 para Sábado.)
     * @param horario    Horário de exibição do TalkShow
     * @param duracaoMin Duração do TalkShow em minutos
     * 
     */
    public TalkShow(String nome, ArrayList<Integer> dias, String horario,
            int duracaoMin) {
        super(nome, dias, horario, duracaoMin);
    }

    /**
     * Construtor que recebe o nome de um TalkShow, os dias da semana que o TalkShow
     * é transmitido, o horário de exibição, a duração do TalkShow e os
     * apresentadores.
     * 
     * @param nome           Nome do TalkShow
     * @param dias           ArrayList de inteiros que representa os dias
     *                       da semana que o TalkShow é transmitido (1 para
     *                       Domingo até 7 para Sábado.)
     * @param horario        Horário de exibição do TalkShow
     * @param duracaoMin     Duração do TalkShow em minutos
     * 
     * @param apresentadores ArrayList de Artistas que representam os
     *                       apresentadores do TalkShow
     */
    public TalkShow(String nome, ArrayList<Integer> dias, String horario, int duracaoMin,
            ArrayList<Artista> apresentadores) {
        super(nome, dias, horario, duracaoMin);
        this.apresentadores = apresentadores;
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

    /**
     * 
     * Verifica se existe um apresentador com o nome especificado agregado a essa
     * classe.
     * 
     * @param nome Nome do apresentador
     * @return Retorna 'true' se o apresentador existir e 'false' caso contrário.
     */
    public boolean existeApresentador(String nome) {
        for (Artista apresentador : apresentadores) {
            if (nome == apresentador.getNome()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * Verifica se existe um musico com o nome especificado agregado a essa classe.
     * 
     * @param nome Nome do musico
     * @return Retorna 'true' se o musico existir e 'false' caso contrário.
     */
    public boolean existeMusico(String nome) {
        for (Artista musico : musicos) {
            if (nome == musico.getNome()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * Verifica se existe um convidado com o nome especificado agregado a essa
     * classe.
     * 
     * @param nome Nome do convidado
     * @return Retorna 'true' se o convidado existir e 'false' caso contrário.
     */
    public boolean existeConvidado(String nome) {
        for (Pessoa convidado : convidados) {
            if (nome == convidado.getNome()) {
                return true;
            }
        }
        return false;
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
