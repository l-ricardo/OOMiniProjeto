package model;

import java.util.ArrayList;

/**
 * Classe que modela um canal de televisão.
 */
public class Canal implements Comparable<Canal> {
    private String nome;
    private int numero;
    private ArrayList<Programa> programas = new ArrayList<>();

    // -------------------------------- Contrutores --------------------------------
    /**
     * Contrutor que recebe o nome do canal e o número em que ele pode ser
     * sintonizado.
     * 
     * @param nome   Nome do canal
     * @param numero Número do canal
     */
    public Canal(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    /**
     * Contrutor que recebe o nome do canal, o número em que ele pode ser
     * sintonizado e os programas que ele exibe.
     * 
     * @param nome      Nome do canal
     * @param numero    Número do canal
     * @param programas ArrayList com os programas que dado canal possui em sua
     *                  grade
     * 
     */
    public Canal(String nome, int numero, ArrayList<Programa> programas) {
        this(nome, numero);
        this.programas = programas;
    }

    // -------------------------------- Gets e Sets --------------------------------
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(ArrayList<Programa> programas) {
        this.programas = programas;
    }

    // ---------------------------- Metodos Auxiliares ----------------------------
    /**
     * 
     * Verifica se existe um programa com o nome especificado agregado a essa
     * classe.
     * 
     * @param nome Nome do programa
     * @return Retorna 'true' se o programa existir e 'false' caso contrário.
     */
    public boolean existePrograma(String nome) {
        for (Programa programa : programas) {
            if (nome == programa.getNome()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Esse override ensina a biblioteca java.util qual atributo de canal deve
     * ser usado na comparação entre canais. Possibilita o uso do método
     * Collections.sort() para ordernar canais alfabeticamente.
     * 
     * @param outroCanal O outro canal ao qual será feita a comparação
     * @return O nome do canal
     */
    @Override
    public int compareTo(Canal outroCanal) {
        return this.nome.compareTo(outroCanal.nome);
    }

    // --------------------------------- toString ---------------------------------
    @Override
    public String toString() {
        // String result = "========================================\n"
        // + "Canal " + numero + ": " + nome + "\n"
        // + "------------- Programação --------------\n";
        // result += programas != null ? listarProgramas() : "Não existe nenhum programa
        // registrado!";
        // result += "========================================";
        // return result;
        // return " Canal " + numero + ": " + nome;
        return nome;
    }
}