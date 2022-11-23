package main;

import modelos.Apresentador;
import modelos.Canal;
import modelos.Horario;
import modelos.Programa;

public class main {
    public static void main(String[] args) {

        Apresentador[] apresentadores = new Apresentador[50];
        Canal[] canais = new Canal[10];
        Programa[] programas = new Programa[100];
        Horario[] horarios = new Horario[24 * 7 + 100];

        // Criando valores de exemplo
        apresentadores[0] = new Apresentador("Ana Maria Braga", 'F');
        apresentadores[1] = new Apresentador("Louro Mané", 'M');
        apresentadores[2] = new Apresentador("Rodrigo Faro", 'M');
        apresentadores[3] = new Apresentador("Silvio Santos", 'M');
        apresentadores[4] = new Apresentador("Marcos Mion", 'M');

        canais[0] = new Canal("Globo", 8);
        canais[1] = new Canal("Record", 10);
        canais[2] = new Canal("SBT", 2);

        programas[0] = new Programa("Mais Você", 8);
        programas[1] = new Programa("Hora do Faro", 10);
        programas[2] = new Programa("Caldeirao", 8);
        programas[3] = new Programa("Programa do Silvio Santos", 2);
        programas[4] = new Programa("Roda Roda Jequiti", 2);

        for (int i = 0; i < 24; i++) {
            horarios[i] = new Horario(i, i + 1, "Domingo");
        }
        for (int i = 24; i < 48; i++) {
            horarios[i] = new Horario(i - 24, i - 24 + 1, "Segunda");
        }
        for (int i = 48; i < 72; i++) {
            horarios[i] = new Horario(i - 48, i - 48 + 1, "Terça");
        }
        for (int i = 72; i < 96; i++) {
            horarios[i] = new Horario(i - 72, i - 72 + 1, "Quarta");
        }
        for (int i = 96; i < 120; i++) {
            horarios[i] = new Horario(i - 96, i - 96 + 1, "Quinta");
        }
        for (int i = 120; i < 144; i++) {
            horarios[i] = new Horario(i - 120, i - 120 + 1, "Sexta");
        }
        for (int i = 144; i < 168; i++) {
            horarios[i] = new Horario(i - 144, i - 144 + 1, "Sabado");
        }

        programas[0].setApresentadores(apresentadores[0], apresentadores[1]);
        programas[1].setApresentadores(apresentadores[2]);
        programas[2].setApresentadores(apresentadores[4]);
        programas[3].setApresentadores(apresentadores[3]);
        programas[4].setApresentadores(apresentadores[3]);

        programas[0].setHorarios(horarios[7], horarios[14], horarios[31], horarios[50]);
        programas[1].setHorarios(horarios[2], horarios[10], horarios[40], horarios[50]);
        programas[2].setHorarios(horarios[44], horarios[51], horarios[85], horarios[60]);
        programas[3].setHorarios(horarios[19], horarios[90], horarios[0], horarios[50]);
        programas[4].setHorarios(horarios[21], horarios[14], horarios[3]);

        canais[0].setProgramas(programas[0], programas[2]);
        canais[1].setProgramas(programas[1]);
        canais[2].setProgramas(programas[3], programas[4]);

        // Teste
        System.out.println(canais[0].toString());
        System.out.println(canais[1].toString());
        System.out.println(canais[2].toString());

    }
}
