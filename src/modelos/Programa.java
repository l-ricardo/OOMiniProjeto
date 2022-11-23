package modelos;

import java.util.Arrays;

public class Programa { // ToDo: Fazer isso ser uma classe pai e ter classses filhas para programa de
                        // apresentador, programa de filme e de novela
    String nome;
    Horario[] horarios;
    Apresentador[] apresentadores;
    int canal; // Doubt? Como colocar o objeto aqui evitando um relacionamento bidirecional?

    // Contrutor
    public Programa(String nome, int canal) {
        this.nome = nome;
        this.canal = canal;
    }

    // Gets e Sets
    public Horario[] getHorarios() {
        return horarios;
    }

    public void setHorarios(Horario... horarios) {
        this.horarios = horarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Apresentador[] getApresentadores() {
        return apresentadores;
    }

    public void setApresentadores(Apresentador... apresentadores) {
        this.apresentadores = apresentadores;
    }

    @Override
    public String toString() {
        return "------------------" + nome + "------------------" + "\nApresentado por: " + Arrays.toString(apresentadores)
                + "\nNos horarios: "+ Arrays.toString(horarios)+ "\n";
    }

}
