package models;

/**
 * Uma classe que estende de pessoa e representa uma pessoa ficticia de um
 * programa de entreterimento que pode ou não ser protagonista de dado show.
 * 
 * @see Pessoa
 */
public class Personagem extends Pessoa {
    private Pessoa ator;
    private boolean protagonista;
    {
        protagonista = false;
    }

    // Construtores
    /**
     * Contrutor que recebe o nome de um personagem, seu sexo e o ator ou dublador
     * que intrepreta tal personagem.
     * 
     * @param nome Nome do personagem
     * @param sexo Char com a sigla (letra inicial) do sexo do personagem
     * @param ator Pessoa que representa um ator ou dublador responsavel por
     *             intrepretar o referido personagem
     * 
     */
    public Personagem(String nome, char sexo, Pessoa ator) {
        super(nome, sexo);
        this.ator = ator;
    }

    /**
     * Contrutor que recebe o nome de um personagem, seu sexo, o ator ou dublador
     * que intrepreta tal personagem e se o personagem é ou não protragonista no
     * show ao qual pertence.
     * 
     * @param nome         Nome do personagem
     * @param sexo         Char com a sigla (letra inicial) do sexo do personagem
     * @param ator         Pessoa que representa um ator ou dublador responsavel por
     *                     intrepretar o referido personagem
     * @param protagonista Boleano, se True o personagem é protagonista no show ao
     *                     qual pertence
     */
    public Personagem(String nome, char sexo, Pessoa ator, boolean protagonista) {
        this(nome, sexo, ator);
        this.protagonista = protagonista;
    }

    // Gets e Sets
    public Pessoa getAtor() {
        return ator;
    }

    public void setAtor(Pessoa ator) {
        this.ator = ator;
    }

    public boolean isProtagonista() {
        return protagonista;
    }

    public void setProtagonista(boolean protagonista) {
        this.protagonista = protagonista;
    }

    @Override
    public String toString() {
        if (ator != null) {
            return ator.toString() + " como " + nome;
        }
        return nome;
    }
}
