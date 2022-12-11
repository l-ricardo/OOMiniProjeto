package modelos;

public abstract class Programa {
    private String nome;
    private Horario[] horarios;
    private int classificacaoIndicativa; // 0 significa Livre
    private String descricao;
    private boolean favorito;
    {
        favorito = false;
        descricao = "Nenhuma descrição foi fornecida";
    }

    // Construtores
    public Programa(String nome, Horario[] horarios, int classificacaoIndicativa) {
        this.nome = nome;
        this.horarios = horarios;
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public Programa(String nome, Horario[] horarios, int classificacaoIndicativa, String descricao) {
        this(nome, horarios, classificacaoIndicativa);
        this.descricao = descricao;
    }

    // Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Horario[] getHorarios() {
        return horarios;
    }

    public void setHorarios(Horario... horarios) {
        this.horarios = horarios;
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

}
