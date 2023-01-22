package controle;

import models.Dados;

public class Teste {
    public static void main(String[] args) {
        Dados d = new Dados();

        // Teste canais
        System.out.println(d.getCanais().get(0).toString());
        System.out.println(d.getCanais().get(1).toString());
        System.out.println(d.getCanais().get(2).toString());

        // // Teste horarios
        // System.out.println(d.getHorarios().get(0).toString());
        // System.out.println(d.getHorarios().get(5)].toString());
        // System.out.println(d.getHorarios().get(1)].toString());
        // System.out.println(d.getHorarios().get(4)].toString());
        // System.out.println(d.getHorarios().get(8)].toString());

        // // Teste pessoas
        // System.out.println(d.getArtistas().get(0).toString());
        // System.out.println(d.getArtistas().get(1).toString());
        // System.out.println(d.getArtistas().get(6).toString());
        // System.out.println(d.getArtistas().get(8).toString());
        // System.out.println(d.getPersonagens().get(1).toString());
        // System.out.println(d.getPersonagens().get(2).toString());

        // // Teste programas
        // System.out.println(d.getProgramaTipoTalkShow().get(0).toString());
        // System.out.println(d.getProgramaTipoTalkShow().get(1).toString());
        // System.out.println(d.getProgramaTipoTalkShow().get(2).toString());
        // System.out.println(d.getProgramaTipoTalkShow().get(3).toString());
        // System.out.println(d.getProgramaTipoTalkShow().get(4).toString());
        // System.out.println(d.getProgramaTipoJornal().get(0).toString());
        // System.out.println(d.getProgramaTipoNovelaFilmeSerie().get(0).toString());

        // // Teste metodo de pesquisa por programa especifico
        // d.getCanais().get(0).pesquisarPrograma("Avenida Brasil");

        // // Teste metodo de listagem de todos os programas de um canal
        // System.out.println(d.getCanais().get(2).listarProgramas());

        // // Teste metodo de listagem de todos os programas em um dia escolhido
        // System.out.println(d.getCanais().get(2).listarProgramas("Domingo"));

        // // Teste metodo de listar personagens
        // d.getProgramaTipoNovelaFilmeSerie().get(0).listarPersonagens();
        // d.getProgramaTipoNovelaFilmeSerie().get(0).listarPersonagens(true);

        // // Teste metodo de favoritar programa
        // System.out.println(d.getProgramaTipoTalkShow().get(1).toString());
        // d.getCanais().get(0).favoritarPrograma(d.getProgramaTipoTalkShow().get(1));
    }

}
