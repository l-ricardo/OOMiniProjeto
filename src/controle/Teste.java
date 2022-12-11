package controle;

import modelos.Dados;

public class Teste {
    public static void main(String[] args) {
        Dados d = new Dados();

        // Teste canais
        System.out.println(d.getCanais()[0].toString());
        System.out.println(d.getCanais()[1].toString());
        System.out.println(d.getCanais()[2].toString());

        // // Teste horarios
        // System.out.println(d.getHorarios()[0].toString());
        // System.out.println(d.getHorarios()[52].toString());
        // System.out.println(d.getHorarios()[12].toString());
        // System.out.println(d.getHorarios()[47].toString());
        // System.out.println(d.getHorarios()[85].toString());

        // // Teste pessoas
        // System.out.println(d.getArtistas()[0].toString());
        // System.out.println(d.getArtistas()[1].toString());
        // System.out.println(d.getArtistas()[6].toString());
        // System.out.println(d.getArtistas()[8].toString());
        // System.out.println(d.getPersonagens()[1].toString());
        // System.out.println(d.getPersonagens()[2].toString());

        // // Teste programas
        // System.out.println(d.getProgramaTipoTalkShow()[0].toString());
        // System.out.println(d.getProgramaTipoTalkShow()[1].toString());
        // System.out.println(d.getProgramaTipoTalkShow()[2].toString());
        // System.out.println(d.getProgramaTipoTalkShow()[3].toString());
        // System.out.println(d.getProgramaTipoTalkShow()[4].toString());
        // System.out.println(d.getProgramaTipoJornal()[0].toString());
        // System.out.println(d.getProgramaTipoNovelaFilmeSerie()[0].toString());

        // // Teste metodo de pesquisa por programa especifico
        // d.getCanais()[0].pesquisarPrograma("Avenida Brasil");

        // Teste metodo de listagem de todos os programas de um canal
        // System.out.println(d.getCanais()[2].listarProgramas());

        // // Teste metodo de listagem de todos os programas em um dia escolhido
        // System.out.println(d.getCanais()[2].listarProgramas("Domingo"));

        // // Teste metodo de listar personagens
        // d.getProgramaTipoNovelaFilmeSerie()[0].listarPersonagens();
        // d.getProgramaTipoNovelaFilmeSerie()[0].listarPersonagens(true);
        
        // // Teste metodo de favoritar programa
        // System.out.println(d.getProgramaTipoTalkShow()[1].toString());
        // d.getCanais()[0].favoritarPrograma(d.getProgramaTipoTalkShow()[1]);
    }

}
