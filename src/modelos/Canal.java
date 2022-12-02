package modelos;

public class Canal {
    String nome;
    int numero;

    // Construtor
    public Canal(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "\n###################### Canal " + numero + ": " + nome + " ######################\n";
    }

    // Gets e Sets
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

}