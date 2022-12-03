package controle;

// import modelos.Apresentador;
// import modelos.Canal;
import modelos.Dados;
// import modelos.Horario;
// import modelos.Programa;

public class Teste {
    public static void main(String[] args) {
        Dados d = new Dados();

        // // Teste canais
        // System.out.println(d.getCanais()[0].toString());
        // System.out.println(d.getCanais()[1].toString());
        // System.out.println(d.getCanais()[2].toString());

        // // Teste horarios
        // System.out.println(d.getHorarios()[0].toString());
        // System.out.println(d.getHorarios()[52].toString());
        // System.out.println(d.getHorarios()[12].toString());
        // System.out.println(d.getHorarios()[47].toString());
        // System.out.println(d.getHorarios()[85].toString());

        // // Teste pessoas
        // System.out.println(d.getApresentadores()[0].toString());
        // System.out.println(d.getApresentadores()[1].toString());
        // System.out.println(d.getApresentadores()[6].toString());
        // System.out.println(d.getPersonagens()[1].toString());
        // System.out.println(d.getPersonagens()[2].toString());


        // // Teste programas
        // System.out.println(d.getProgramaTipoTalkShowJornal()[0].toString());
        // System.out.println(d.getProgramaTipoTalkShowJornal()[1].toString());
        // System.out.println(d.getProgramaTipoTalkShowJornal()[2].toString());
        // System.out.println(d.getProgramaTipoTalkShowJornal()[3].toString());
        // System.out.println(d.getProgramaTipoTalkShowJornal()[4].toString());
        // System.out.println(d.getProgramaTipoTalkShowJornal()[5].toString());
        // System.out.println(d.getProgramaTipoNovelaFilmeSerie()[0].toString());

        // // Teste metodo de pesquisa
        d.pesquisarPrograma("Avenida Brasil");

        // Teste metodo de listagem por data e canal
        // d.listarProgramas("Globo", "Domingo");
    }
}
