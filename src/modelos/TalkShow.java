package modelos;

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
        String result = "========================================\n"
                + getNome() + " (" + getClassificacaoIndicativa() + ")\n"
                + getDescricao() + "\n"
                + "--------------- Horários ----------------\n";
        for (Horario horario : getHorarios()) {
            result += horario.toString() + "\n";
        }
        result += "------------ Apresentadores -------------\n";
        for (Artista apresentador : apresentadores) {
            result += apresentador.toString() + "\n";
        }
        if (banda != null) {
            result += "--------------- Banda ----------------\n";
            for (Artista musico : banda) {
                result += musico.toString() + "\n";
            }
        }
        if (convidados != null) {
            result += "-------------- Convidados ---------------\n";
            for (Pessoa convidado : convidados) {
                result += convidado.toString() + "\n";
            }
        }
        result += "========================================";
        if (isFavorito()) {
            result = result.replace('=', '*');
        }
        return result;
    }

    // Outros metodos
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

}
