package models;

public class Horario {
    private float horaInicio;
    private float horaFim;
    private String diaSemana;

    // Construtor
    public Horario(float horaInicio, float horaFim, String diaSemana) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.diaSemana = diaSemana;
    }

    @Override
    public String toString() {
        return diaSemana + " das " + horaInicio + " as " + horaFim;
    }

    // Gets e Sets
    public float getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(float horaInicio) {
        this.horaInicio = horaInicio;
    }

    public float getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(float horaFim) {
        this.horaFim = horaFim;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

}
