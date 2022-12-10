package modelos;

import java.util.Arrays;

public class TalkShow extends Programa {
    private Artista[] apresentadores;
    private Artista[] banda;
    private Pessoa[] convidados;

    // Construtores
    public TalkShow(String nome, Horario[] horarios, int classificacaoIndicativa, Artista[] apresentadores,
            Artista[] banda, Pessoa[] convidados) {
        super(nome, horarios, classificacaoIndicativa);
        this.apresentadores = apresentadores;
        this.banda = banda;
        this.convidados = convidados;
    }

    public TalkShow(String nome, Horario[] horarios, int classificacaoIndicativa, String descricao,
            Artista[] apresentadores, Artista[] banda, Pessoa[] convidados) {
        super(nome, horarios, classificacaoIndicativa, descricao);
        this.apresentadores = apresentadores;
        this.banda = banda;
        this.convidados = convidados;
    }

    public TalkShow(String nome, Horario[] horarios, int classificacaoIndicativa, Artista... apresentadores) {
        super(nome, horarios, classificacaoIndicativa);
        this.apresentadores = apresentadores;
    }

    @Override
    public String toString() {
        return "\n################################ " + getNome() + " ################################" +
                "\nHorarios: " + Arrays.toString(getHorarios()) +
                "\nApresentando: " + Arrays.toString(apresentadores);
    }

    // Gets e Sets
    public Artista[] getApresentadores() {
        return apresentadores;
    }

    public void setApresentadores(Artista... apresentadores) {
        this.apresentadores = apresentadores;
    }

    public Artista[] getBanda() {
        return banda;
    }

    public void setBanda(Artista... banda) {
        this.banda = banda;
    }

    public Pessoa[] getConvidados() {
        return convidados;
    }

    public void setConvidados(Pessoa... convidados) {
        this.convidados = convidados;
    }

    // Outros metodos
    public void adicionarApresentador(Artista... apresentadores) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerApresentador(String apresentadoresNome) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void adicionarMusico(Artista... musico) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerMusico(String musicoNome) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void adicionarConvidado(Artista... convidado) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerConvidado(String convidadoNome) {
        System.out.println("Funcionalidade ainda não implentada");
    }

}
