package modelos;

public class Horario {
    int horaInicio;
    int horaFim;
    String diaSemana;

    // Construtor
    public Horario(int horaInicio, int horaFim, String diaSemana) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.diaSemana = diaSemana;
    }

    // Gets e Sets
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

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    @Override
    public String toString() {
        return "Horario [horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", diaSemana=" + diaSemana + "]";
    }

}
