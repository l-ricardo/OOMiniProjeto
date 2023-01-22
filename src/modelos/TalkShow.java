package modelos;

import java.util.ArrayList;

public class TalkShow extends Programa {
    private ArrayList<Artista> apresentadores = new ArrayList<>();
    private ArrayList<Artista> banda = new ArrayList<>();
    private ArrayList<Pessoa> convidados = new ArrayList<>();

    // Construtores
    public TalkShow(String string, ArrayList<Horario> horarios, int classificacaoIndicativa) {
        super(string, horarios, classificacaoIndicativa);
    }

    public TalkShow(String nome, ArrayList<Horario> horarios, int classificacaoIndicativa,
            ArrayList<Artista> apresentadores,
            ArrayList<Artista> banda, ArrayList<Pessoa> convidados) {
        this(nome, horarios, classificacaoIndicativa);
        this.apresentadores = apresentadores;
        this.banda = banda;
        this.convidados = convidados;
    }

    public TalkShow(String nome, ArrayList<Horario> horarios, int classificacaoIndicativa, String descricao,
            ArrayList<Artista> apresentadores, ArrayList<Artista> banda, ArrayList<Pessoa> convidados) {
        super(nome, horarios, classificacaoIndicativa, descricao);
        this.apresentadores = apresentadores;
        this.banda = banda;
        this.convidados = convidados;
    }

    public TalkShow(String nome, ArrayList<Horario> horarios, int classificacaoIndicativa,
            ArrayList<Artista> apresentadores) {
        this(nome, horarios, classificacaoIndicativa);
        this.apresentadores = apresentadores;
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
        // if (banda != null) {
        // result += "--------------- Banda ----------------\n";
        // for (Artista musico : banda) {
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

    // Outros metodos //TODO: Ajustar arrays abaixos se necessario
    public void adicionarApresentador(Artista... apresentadores) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerApresentador(String apresentadorNome) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void adicionarMusico(Artista... musicos) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerMusico(String musicoNome) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void adicionarConvidado(Pessoa... convidados) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerConvidado(String convidadoNome) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    // Gets e Sets
    public ArrayList<Artista> getApresentadores() {
        return apresentadores;
    }

    public void setApresentadores(ArrayList<Artista> apresentadores) {
        this.apresentadores = apresentadores;
    }

    public ArrayList<Artista> getBanda() {
        return banda;
    }

    public void setBanda(ArrayList<Artista> banda) {
        this.banda = banda;
    }

    public ArrayList<Pessoa> getConvidados() {
        return convidados;
    }

    public void setConvidados(ArrayList<Pessoa> convidados) {
        this.convidados = convidados;
    }

}
