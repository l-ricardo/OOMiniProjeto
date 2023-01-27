package model;

import java.util.ArrayList;

/**
 * Uma classe que estende programa e que pode representar qualquer tipo de
 * jornal ou noticiario.
 */
public class Jornal extends Programa {
    private ArrayList<Artista> ancoras;
    private String localidade;

    /**
     * Construtor que recebe o nome de um noticiario, os dias da semana que o
     * noticiario é transmitido, o horário de exibição, a duração do noticiario e a
     * classificação indicativa.
     * 
     * @param nome                    Nome do noticiario
     * @param dias                    ArrayList de inteiros que representa os dias
     *                                da semana que o noticiario é transmitido (1
     *                                para Domingo até 7 para Sábado.)
     * @param horario                 Horário de exibição do noticiario
     * @param duracaoMin              Duração do noticiario em minutos
     * @param classificacaoIndicativa Classificação indicativa do noticiario (0 para
     *                                classificacao livre)
     * @param ancoras                 ArrayList de Artistas que representam os
     *                                ancoras do noticiario
     * @param localidade              Se o noticiario é Local, Nacional, etc...
     */
    public Jornal(String nome, ArrayList<Integer> dias, String horario, int duracaoMin,
            int classificacaoIndicativa, ArrayList<Artista> ancoras, String localidade) {
        super(nome, dias, horario, duracaoMin, classificacaoIndicativa);
        this.ancoras = ancoras;
        this.localidade = localidade;
    }

    // Outros metodos //TODO: Ajustar arrays abaixos se necessario
    public void adicionarAncora(Artista... ancoras) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerAncora(String ancoraNome) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    // Gets e Sets
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
