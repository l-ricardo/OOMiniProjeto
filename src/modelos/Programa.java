package modelos;

public class Programa { // Doubt?? Talvez converter para classe abstrata
    String nome;
    Horario[] horarios;
    Canal canal;

    // Construtor
    public Programa(String nome, Canal canal) {
        this.nome = nome;
        this.canal = canal;
    }

    public Programa(String nome, Horario[] horarios, Canal canal) {
        this.nome = nome;
        this.horarios = horarios;
        this.canal = canal;
    }

    // Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Horario[] getHorarios() {
        return horarios; // ToDo: Checar se é necessario fazer a iteração de horarios aqui
    }

    public void setHorarios(Horario... horarios) {
        this.horarios = horarios;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }
}
