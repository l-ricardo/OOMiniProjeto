package modelos;

import java.util.Arrays;

public class Jornal extends Programa {
    private Artista[] ancoras;
    private String localidade;

    // Construtores
    public Jornal(String nome, Horario[] horarios, int classificacaoIndicativa, Artista[] ancoras, String localidade) {
        super(nome, horarios, classificacaoIndicativa);
        this.ancoras = ancoras;
        this.localidade = localidade;
    }

    public Jornal(String nome, Horario[] horarios, int classificacaoIndicativa, String descricao, Artista[] ancoras,
            String localidade) {
        super(nome, horarios, classificacaoIndicativa, descricao);
        this.ancoras = ancoras;
        this.localidade = localidade;
    }

    @Override
    public String toString() {
        return "\n################################ " + getNome() + " ################################" +
                "\nHorarios: " + Arrays.toString(getHorarios()) +
                "\nApresentando: " + Arrays.toString(ancoras);
    }

    // Gets e Sets
    public Artista[] getAncoras() {
        return ancoras;
    }

    public void setAncoras(Artista... ancoras) {
        this.ancoras = ancoras;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    // Outros metodos
    public void adicionarAncora(Artista... ancoras) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerAncora(String ancorasNome) {
        System.out.println("Funcionalidade ainda não implentada");
    }
}
