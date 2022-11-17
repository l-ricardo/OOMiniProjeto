package modelos;

public class Programa {
    String nome;
    String[] apresentadores; // ToDo: talvez tirar isso daqui pra um novo objeto
    int horaInicio;
    int horaFim;
    String[] diasSemana;
    Canal canal;

    // Contrutor
    public Programa(String nome, String[] apresentadores, int horaInicio, int horaFim, String[] diasSemana,
            Canal canal) {
        this.nome = nome;
        this.apresentadores = apresentadores;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.diasSemana = diasSemana;
        this.canal = canal;
    }

    // Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getApresentadores() {
        return apresentadores;
    }

    public void setApresentadores(String[] apresentadores) {
        this.apresentadores = apresentadores;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(int horaFim) {
        this.horaFim = horaFim;
    }

    public String[] getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(String[] diasSemana) {
        this.diasSemana = diasSemana;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

}
