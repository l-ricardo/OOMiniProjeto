package model;

import java.util.ArrayList;

/**
 * Classe que estende programa e que pode modelar qualquer tipo de
 * jornal ou noticiario.
 */
public class Jornal extends Programa {
    private ArrayList<Artista> ancoras;
    private String localidade;

    // -------------------------------- Contrutores --------------------------------
    /**
     * Construtor que recebe o nome de um Jornal, os dias da semana que o Jornal
     * é transmitido, o horário de exibição, a duração do Jornal.
     * 
     * @param nome       Nome do Jornal
     * @param dias       ArrayList de inteiros que representa os dias
     *                   da semana que o Jornal é transmitido (1 para
     *                   Domingo até 7 para Sábado.)
     * @param horario    Horário de exibição do Jornal
     * @param duracaoMin Duração do Jornal em minutos
     * 
     */
    public Jornal(String nome, ArrayList<Integer> dias, String horario,
            int duracaoMin) {
        super(nome, dias, horario, duracaoMin);
    }

    /**
     * Construtor que recebe o nome de um noticiario, os dias da semana que o
     * noticiario é transmitido, o horário de exibição, a duração do noticiario.
     * 
     * @param nome       Nome do noticiario
     * @param dias       ArrayList de inteiros que representa os dias
     *                   da semana que o noticiario é transmitido (1
     *                   para Domingo até 7 para Sábado.)
     * @param horario    Horário de exibição do noticiario
     * @param duracaoMin Duração do noticiario em minutos
     * @param ancoras    ArrayList de Artistas que representam os
     *                   ancoras do noticiario
     * @param localidade Se o noticiario é Local, Nacional, etc...
     */
    public Jornal(String nome, ArrayList<Integer> dias, String horario, int duracaoMin,
            ArrayList<Artista> ancoras, String localidade) {
        super(nome, dias, horario, duracaoMin);
        this.ancoras = ancoras;
        this.localidade = localidade;
    }

    // -------------------------------- Gets e Sets --------------------------------
    public ArrayList<Artista> getAncoras() {
        return ancoras;
    }

    public void setAncoras(ArrayList<Artista> ancoras) {
        this.ancoras = ancoras;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    // ---------------------------- Metodos Auxiliares ----------------------------
    /**
     * 
     * Verifica se existe um ancora com o nome especificado agregado a essa classe.
     * 
     * @param nome Nome do ancora
     * @return Retorna 'true' se o ancora existir e 'false' caso contrário.
     */
    public boolean existeAncora(String nome) {
        for (Artista ancora : ancoras) {
            if (nome == ancora.getNome()) {
                return true;
            }
        }
        return false;
    }

    // --------------------------------- toString ---------------------------------
    @Override
    public String toString() {
        // String result = "========================================\n"
        // + getNome() + " (" + getClassificacaoIndicativa() + ")\n"
        // + "Cobertura " + localidade + "\n"
        // + getDescricao() + "\n"
        // + "--------------- Horários ----------------\n";
        // for (Horario horario : getHorarios()) {
        // result += horario.toString() + "\n";
        // }
        // result += "--------------- Âncoras ----------------\n";
        // for (Artista ancora : ancoras) {
        // result += ancora.toString() + "\n";
        // }
        // result += "========================================";
        // if (isFavorito()) {
        // result = result.replace('=', '*');
        // }
        String result = getNome();
        return result;
    }
}