package modelos;

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
        String result = "========================================\n"
                + getNome() + " (" + getClassificacaoIndicativa() + ")\n"
                + "Cobertura " + localidade + "\n"
                + getDescricao() + "\n"
                + "--------------- Horários ----------------\n";
        for (Horario horario : getHorarios()) {
            result += horario.toString() + "\n";
        }
        result += "--------------- Âncoras ----------------\n";
        for (Artista ancora : ancoras) {
            result += ancora.toString() + "\n";
        }
        result += "========================================";
        if (isFavorito()) {
            result = result.replace('=', '*');
        }
        return result;
    }

    // Outros metodos
    public void adicionarAncora(Artista... ancoras) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerAncora(String ancoraNome) {
        System.out.println("Funcionalidade ainda não implentada");
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

}
