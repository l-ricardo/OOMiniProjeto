package model;

/**
 * Classe que estende de pessoa e modela uma pessoa real que tem algum
 * grau de notoriedade por fazer parte de programs de tv, como por exemplo:
 * Humoristas, Jornalistas, Entrevistadores, Atores, Dubladores, Músicos, etc...
 */
public class Artista extends Pessoa {
    private String tipo; // Ex: Humorista, Jornalista, Entrevistador, etc...
    private boolean musico;
    private boolean ancora;
    private String instrumento;
    {
        musico = false;
        ancora = false;
        instrumento = "Nenhum";
    }

    // -------------------------------- Contrutores --------------------------------
    /**
     * Contrutor que recebe nome, sexo e qual o tipo de artista uma pessoa é.
     * 
     * @param nome Nome do artista
     * @param sexo Char com a sigla (letra inicial) do sexo do artista
     * @param tipo Especialidade do artista, se ele é Humorista, Jornalista,
     *             Entrevistador, etc..
     */
    public Artista(String nome, char sexo, String tipo) {
        super(nome, sexo);
        this.tipo = tipo;
    }

    /**
     * Contrutor que cria um artista do tipo musico ele recebe nome, sexo, tipo de
     * musico e qual instrumento a pessoa toca.
     * 
     * @param nome        Nome do artista
     * @param sexo        Char com a sigla (letra inicial) do sexo do artista
     * @param tipo        Nesse caso muito provavelmente esse parametro deve receber
     *                    Musico.
     * @param instrumento Qual intrumento esse artista toca
     */
    public Artista(String nome, char sexo, String tipo, String instrumento) {
        this(nome, sexo, tipo);
        this.musico = true;
        this.instrumento = instrumento;
    }

    // -------------------------------- Gets e Sets --------------------------------
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isMusico() {
        return musico;
    }

    public void setMusico(boolean musico) {
        this.musico = musico;
    }

    public boolean isAncora() {
        return ancora;
    }

    public void setAncora(boolean ancora) {
        this.ancora = ancora;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    // --------------------------------- toString ---------------------------------
    @Override
    public String toString() {
        // if (isMusico()) {
        // return tipo + " " + nome + " no " + instrumento;
        // }
        // return tipo + " " + nome;
        return getNome();
    }
}