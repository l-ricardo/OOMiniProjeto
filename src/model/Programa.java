package model;

import java.util.ArrayList;
import java.time.DayOfWeek;

/**
 * Uma classe abstrata que representa um programa generico que é transmitido na
 * televisão.
 */
public abstract class Programa implements Comparable<Programa> {
    private String nome;
    private ArrayList<DayOfWeek> diasExibicao = new ArrayList<>();
    private String horario;
    private int duracaoMin;
    private int classificacaoIndicativa; // 0 significa Livre
    private String descricao;
    private boolean favorito;
    {
        favorito = false;
        descricao = "Nenhuma descrição foi fornecida";
    }

    /**
     * Construtor que recebe o nome do programa, os dias da semana que o programa é
     * transmitido, o horário de exibição, a duração do programa e a classificação
     * indicativa.
     * 
     * @param nome                    Nome do programa
     * @param dias                    ArrayList de inteiros que representa os dias
     *                                da semana que o programa é transmitido (1 para
     *                                Domingo até 7 para Sábado.)
     * @param horario                 Horário de exibição do programa
     * @param duracaoMin              Duração do programa em minutos
     * @param classificacaoIndicativa Classificação indicativa do programa (0 para
     *                                classificacao livre)
     */
    public Programa(String nome, ArrayList<Integer> dias, String horario,
            int duracaoMin, int classificacaoIndicativa) {
        this.nome = nome;
        this.setDiasExibicao(dias);
        this.horario = horario;
        this.duracaoMin = duracaoMin;
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    // Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<DayOfWeek> getDiasExibicao() {
        return diasExibicao;
    }

    /**
     * Metodo set para dias de exibição do programa porém deve receber um
     * ArrayList de interios onde 1 representa Domingo, 2 representa Segunda até 7
     * que representa Sábado.
     * 
     * @param diasExibicaoNum ArrayList de inteiros que representa os dias
     *                        da semana que o programa é transmitido
     */
    public void setDiasExibicao(ArrayList<Integer> diasExibicaoNum) {
        this.diasExibicao.clear();
        for (int dia : diasExibicaoNum) {
            this.diasExibicao.add(DayOfWeek.of(dia));
        }
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getDuracaoMin() {
        return duracaoMin;
    }

    public void setDuracaoMin(int duracaoMin) {
        this.duracaoMin = duracaoMin;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    /**
     * Esse override ensina a biblioteca java.util qual atributo de programa deve
     * ser usado na comparação entre programas. Possibilita o uso do método
     * Collections.sort() para ordernar programas alfabeticamente.
     * 
     * @param outroPrograma O outro programa ao qual será feita a comparação
     * @return O nome do programa
     */
    @Override
    public int compareTo(Programa outroPrograma) {
        return this.nome.compareTo(outroPrograma.nome);
    }
}
